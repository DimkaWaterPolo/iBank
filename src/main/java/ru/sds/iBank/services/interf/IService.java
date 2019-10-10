package ru.sds.iBank.services.interf;

import java.util.Date;
import java.util.List;

import ru.sds.iBank.entities.Account;
import ru.sds.iBank.entities.Card;
import ru.sds.iBank.entities.Client;
import ru.sds.iBank.entities.PayDocument;


public interface IService {
	
	//авторизация пользователя
	boolean isLogin(String login, String password);
	
	//клиент по его логину
	Client getClientByLogin(String login);
	
	//клиент по id
	Client getClientById(int id);
	
	//список счетов по id клиента
	List<Account> getAccounts4Client(int id);
	
	//список карт по id клиента
	List<Card> getCards4Client(int id);
	
	//список документов по совершенным транзакциям
	List<PayDocument> getPayDocuments4Client(int id, String paymentDirect, Date startDate, Date endDate);

	//проверка исполнения транзакции
	boolean doPayment (PayDocument payDocument);

}
