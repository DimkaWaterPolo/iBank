package ru.ssv.dbo.idelphin.controllers;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ru.ssv.dbo.idelphin.entities.Account;
import ru.ssv.dbo.idelphin.entities.Client;
import ru.ssv.dbo.idelphin.entities.PayDocument;
import ru.ssv.dbo.idelphin.exception.CheckPayDocumentException;
import ru.ssv.dbo.idelphin.jsp.model.DocsFilter;
import ru.ssv.dbo.idelphin.jsp.model.Message;
import ru.ssv.dbo.idelphin.services.IService;


/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes(value={"client", "docsFilter"})

public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private static final String MESSAGE_HEADER_BANER = "Внимание";
	private static final String MESSAGE_CONTEXT_BANER = "Уважаемые клиенты Московского Нефтехимического Банка, предлагаем Вам депозитный продукт Растущий процент с доходностью до 10% годовых. <br> Ждем Вас в отделениях нашего Банка.";
	
	private static final String MESSAGE_HEADER_ERROR_VALID_LOGIN = "Ошибка валидации";
	private static final String MESSAGE_CONTEXT_ERROR_VALID_LOGIN = "Неверно указан логин или пароль";

	private static final String MESSAGE_HEADER_ERROR_AUTHORIZATION = "Ошибка авторизации";
	private static final String MESSAGE_CONTEXT_ERROR_AUTHORIZATION = "Неверно указан логин или пароль";

	private static final String MESSAGE_HEADER_DO_PAYMENT = "Результат проводки платежа";
	private static final String MESSAGE_CONTEXT_SUCCESS_DO_PAYMENT = "Успешное выполнение операции";
	private static final String MESSAGE_CONTEXT_ERROR_DO_PAYMENT = "Ошибка при выполнении операции";
	
	private static final String MESSAGE_HEADER_ERROR_SYSTEM = "Системная ошибка";
		
	
	@Autowired
	@Qualifier("service")
	private IService service; 
	
	public HomeController() {
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		logger.info("Контроллер направляет на страницу авторизации пользователя");
		
		model.addAttribute("client", new Client());
		model.addAttribute("message", new Message(Message.TYPE_BANNER, MESSAGE_HEADER_BANER, MESSAGE_CONTEXT_BANER));
		model.addAttribute("docsFilter",  new DocsFilter(DocsFilter.DIRECT_PAYMENT_ALL, new Date(), new Date()));
		
		return "logon";
	}

	@RequestMapping(value = "checkUser", method = RequestMethod.POST)
	public String checkUser(@Valid /*@ModelAttribute("client")*/ Client client, BindingResult bindingResult,  Model model) {
		
		logger.info("Валидация логина и пароля");
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", new Message(Message.TYPE_ERROR_VALID_LOGIN_PASSWORD, MESSAGE_HEADER_ERROR_VALID_LOGIN, MESSAGE_CONTEXT_ERROR_VALID_LOGIN));
			return "logon";
		}
		
		logger.info("Авторизация пользователя");
		
		if (!service.isLogin(client.getLogin(), client.getPassword())) {
			model.addAttribute("message", new Message(Message.TYPE_ERROR_AUTHORIZATION, MESSAGE_HEADER_ERROR_AUTHORIZATION, MESSAGE_CONTEXT_ERROR_AUTHORIZATION));
			return "logon";
		}
		
		logger.info("Пользователь авторизован");
		logger.info("Считываем информацию о пользователе");
		
		client = service.getClientByLogin(client.getLogin());
		model.addAttribute("client", client);
		
		logger.info("Перенаправляем (redirect) пользователя в личный кабинет: {}", client.toString());
		
		return "redirect:/redirect2Home";
	}

	@RequestMapping(value = "redirect2Home", method = RequestMethod.GET)
	public String redirect2Home(@ModelAttribute Client client, Model model) {
		logger.info("Redirect в личный кабинет пользователя");
		model.addAttribute("accounts", service.getAccounts4Client(client.getId()));
		return "home";
	}
	
	@RequestMapping(value = "ajaxMENU_ACCOUNTS", method = RequestMethod.GET)
	public String getAccounts(@ModelAttribute Client client, Model model) {
		logger.info("Обработка Ajax-запроса по полученю списка счетов");
		model.addAttribute("accounts", service.getAccounts4Client(client.getId()));
		return "ajaxAccounts";
	}

	@RequestMapping(value = "ajaxMENU_CARDS", method = RequestMethod.GET)
	public String getCards(@ModelAttribute Client client, Model model) {
		logger.info("Обработка Ajax-запроса по получению списка карт");
		model.addAttribute("cards", service.getCards4Client(client.getId()));
		return "ajaxCards";
	}

	@RequestMapping(value = "ajaxMENU_DOCS", method = RequestMethod.GET)
	public String getDocs(@ModelAttribute Client client, @ModelAttribute DocsFilter docsFilter, Model model) {
		logger.info("Обработка Ajax-запроса по получению списка документов");
		model.addAttribute("docs", service.getPayDocuments4Client(client.getId(), docsFilter.getDirect(), docsFilter.getStartDate(), docsFilter.getEndDate()));
		model.addAttribute("docsFilter", docsFilter);
		return "ajaxDocs";
	}

	@RequestMapping(value = "getDocsAjax", method = RequestMethod.POST)
	public String getDocsAjax(@ModelAttribute Client client, @ModelAttribute DocsFilter docsFilter, Model model) {
		logger.info("Обработка Ajax-запроса по получению списка документов");
		model.addAttribute("docs", service.getPayDocuments4Client(client.getId(), docsFilter.getDirect(), docsFilter.getStartDate(), docsFilter.getEndDate()));
		model.addAttribute("docsFilter", docsFilter);
		return "ajaxDocs";
	}

	@RequestMapping(value = "ajaxMENU_PAYMENT", method = RequestMethod.GET)
	public String fillPayment(@ModelAttribute Client client, Model model) {
		logger.info("Обработка Ajax-запроса заполнение реквизитов платежа");
		List<Account> accounts = service.getAccounts4Client(client.getId());
		model.addAttribute("accounts", accounts);
		return "ajaxPayment";
	}

	@RequestMapping(value = "doPayment", method = RequestMethod.POST)
	public String doPayment(@ModelAttribute Client client, PayDocument payment, Model model) throws CheckPayDocumentException {
		
		logger.info("Обработка Ajax-запроса проводка платежа");
	
		Message message;
	
		if (service.doPayment(payment))
			message = new Message(Message.TYPE_RESULT_DO_PAYMENT, MESSAGE_HEADER_DO_PAYMENT, MESSAGE_CONTEXT_SUCCESS_DO_PAYMENT);
		else
			message = new Message(Message.TYPE_RESULT_DO_PAYMENT, MESSAGE_HEADER_DO_PAYMENT, MESSAGE_CONTEXT_ERROR_DO_PAYMENT);

		model.addAttribute("message", message);
		
		return "ajaxMessage";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		
		logger.info("Исключительная ситуация: " + e.getMessage());
		
		ModelAndView model = new ModelAndView();
		model.setViewName("ajaxMessage");
		model.addObject("message", new Message(Message.TYPE_ERROR_SYSTEM, MESSAGE_HEADER_ERROR_SYSTEM, e.getMessage()));
		
		return model;
	}

}
