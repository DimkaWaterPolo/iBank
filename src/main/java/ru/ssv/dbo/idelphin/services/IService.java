package ru.ssv.dbo.idelphin.services;

import java.util.Date;
import java.util.List;

import ru.ssv.dbo.idelphin.entities.Account;
import ru.ssv.dbo.idelphin.entities.Card;
import ru.ssv.dbo.idelphin.entities.Client;
import ru.ssv.dbo.idelphin.entities.PayDocument;
import ru.ssv.dbo.idelphin.exception.CheckPayDocumentException;

/**
 * Интерфейс Бизнес-логики приложения.
 * 
 * Сервисный уровень приложения
 * 
 * @author Scheglov
 *
 */
public interface IService {

	/**
	 * Авторизация пользователя
	 * @param login - логин
	 * @param password - пароль
	 * @return true - пользователь авторизован
	 */
	boolean isLogin(String login, String password);
	
    /**
     * Возвращаем клиента по его логину
     * @param login - логин клиента
     * @return Сущность Клиент
     */
	Client getClientByLogin(String login);

    /**
     * Возвращаем клиента по его id
     * @param id - id клиента
     * @return Сущность Клиент
     */
	Client getClientById(int id);

	/**
	 * Определяем счета Клиента
	 * @param id - id Клиент
	 */
	List<Account> getAccounts4Client(int id);
	
	/**
	 * Определяем Карты Клиента
	 * @param id - id Клиент
	 */
	List<Card> getCards4Client(int id);
	
	/**
	 * Определяем Платежные Документы Клиента
	 * @param id - id Клиент
	 */
	List<PayDocument> getPayDocuments4Client(int id, int paymentDirect, Date startDate, Date endDate);

	/**
	 * Платежная транзакция
	 * @param PayDocument  - Платежный документ
	 * @throws Exception 
	 */
	boolean doPayment (PayDocument payDocument) throws CheckPayDocumentException;

}
