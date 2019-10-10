package ru.sds.iBank.dao.interf;

import java.util.Date;
import java.util.List;

import ru.sds.iBank.entities.Account;
import ru.sds.iBank.entities.Card;
import ru.sds.iBank.entities.Client;
import ru.sds.iBank.entities.PayDocument;

public interface IDao {
	
	//получение клиента по логину
	Client getClientByLogin(String login);
	
	//получение клиента по id
	Client getClientById(int id);
	
	//получение счета по его номеру
	Account getAccountByNumber(String number);
	
	//получение счета по его id
	Account getAccountById(int id);
	
	//получение карты по ее id
	Card getCardById(int id);
	
	//получение карты по номеру
	Card getCardByNumber(String number);
	
	//получение документа по его id
	PayDocument getPayDocumentById(int id);
	
	//получение списка счетов по id клиента
	List<Account> getAccountsByClientId(int id);
	
	//получение списка карт по id клиента
	List<Card> getCardsByClientId(int id);
	
	//список документов по транзакциям: id клиента , вид транзакции(списание, зачисление), за период
	List<PayDocument> getPayDocumentByClientId(int id, String nameTransaction, Date startData, Date endData);
	
	//результат транзакции
	boolean doPayment(PayDocument payDocument);
	
}
