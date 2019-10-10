package ru.ssv.dbo.idelphin.servicesImpl;

import java.util.Date;
import java.util.List;

import ru.ssv.dbo.idelphin.dao.IDao;
import ru.ssv.dbo.idelphin.entities.Card;
import ru.ssv.dbo.idelphin.entities.Client;
import ru.ssv.dbo.idelphin.entities.PayDocument;
import ru.ssv.dbo.idelphin.services.IService;
import ru.ssv.dbo.idelphin.entities.Account;
import ru.ssv.dbo.idelphin.exception.CheckPayDocumentException;

/**
 * Реализация интерфейса Бизнес-логики приложения.
 * 
 * Сервисный уровень приложения
 * 
 * @author Scheglov
 *
 */
public class ServiceImpl implements IService{
	
	private IDao dao;

	public void setDao(IDao dao) {
		this.dao = dao;
	}
	
	public IDao getDao() {
		return dao;
	}

	/*
	 * (non-Javadoc)
	 * @see ru.ssv.dbo.idelphin.services.IService#isLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isLogin(String login, String password) {
		Client client = dao.getClientByLogin(login);
		return (password.toUpperCase().equals(client.getPassword().toUpperCase()));
	}

	/*
	 * (non-Javadoc)
	 * @see ru.ssv.dbo.idelphin.services.IService#getClientByLogin(java.lang.String)
	 */
	@Override
	public Client getClientByLogin(String login) {
		Client client = dao.getClientByLogin(login);
		return client;
	}

	@Override
	public List<Account> getAccounts4Client(int id) {
		return dao.getAccountsByClientId(id);
	}
	
	@Override
	public List<Card> getCards4Client(int id) {
		return dao.getCardsByClientId(id);
	}

	@Override
	public List<PayDocument> getPayDocuments4Client(int id, int paymentDirect, Date startDate, Date endDate) {
		return dao.getPayDocumentsByClientId(id, paymentDirect, startDate, endDate);		
	}

	@Override
	public boolean doPayment(PayDocument payDocument) throws CheckPayDocumentException {
		return dao.doPayment(payDocument);
	}

	@Override
	public Client getClientById(int id) {
		return dao.getClientById(id);
	}

}
