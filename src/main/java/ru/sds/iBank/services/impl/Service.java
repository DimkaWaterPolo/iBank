package ru.sds.iBank.services.impl;

import java.util.Date;
import java.util.List;

import ru.sds.iBank.dao.interf.IDao;
import ru.sds.iBank.entities.Account;
import ru.sds.iBank.entities.Card;
import ru.sds.iBank.entities.Client;
import ru.sds.iBank.entities.PayDocument;
import ru.sds.iBank.services.interf.IService;

public class Service implements IService {
	
	private IDao dao;
	

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

	public boolean isLogin(String login, String password) {
		Client client = dao.getClientByLogin(login);
		if(client==null) {
			return false;
		}
		return client.getPassword().toUpperCase().equals(password.toUpperCase());
	}

	public Client getClientByLogin(String login) {
		return dao.getClientByLogin(login);
	}

	public Client getClientById(int id) {	
		return dao.getClientById(id);
	}

	public List<Account> getAccounts4Client(int id) {
		return dao.getAccountsByClientId(id);
	}

	public List<Card> getCards4Client(int id) {
		return dao.getCardsByClientId(id);
	}

	public List<PayDocument> getPayDocuments4Client(int id, String paymentDirect, Date startDate, Date endDate) {
		return dao.getPayDocumentByClientId(id, paymentDirect, startDate, endDate);
	}

	public boolean doPayment(PayDocument payDocument) {
		return dao.doPayment(payDocument);
	}

}
