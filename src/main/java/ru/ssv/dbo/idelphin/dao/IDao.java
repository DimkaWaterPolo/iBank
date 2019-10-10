package ru.ssv.dbo.idelphin.dao;

import java.util.Date;
import java.util.List;

import ru.ssv.dbo.idelphin.entities.Card;
import ru.ssv.dbo.idelphin.entities.Client;
import ru.ssv.dbo.idelphin.entities.Account;
import ru.ssv.dbo.idelphin.entities.PayDocument;
import ru.ssv.dbo.idelphin.exception.CheckPayDocumentException;

/**
 * Интерфейс доступа к данным (data access objects)
 * 
 * Уровень доступа к данным
 * 
 * @author Scheglov
 *
 */
public interface IDao {

	/**
	 * Возвращаем Клиента по его логину
	 * @param login - логин клиента
	 * @return Сущность Клиент
	 */
	Client getClientByLogin(String login);

	/**
	 * Возвращаем Клиента по его id
	 * @param id - id клиента
	 * @return Сущность Клиент
	 */
	Client getClientById(int id);

	/**
	 * Возвращаем Счет по его id
	 * @param id - идентификатор счета
	 * @return - сущность Счет
	 */
	Account getAccountById(int id);

	/**
	 * Возвращаем Счет по его номеру
	 * @param number - номер счета
	 * @return - сущность Счет
	 */
	Account getAccountByNumber(String number);

	/**
	 * Возвращаем Карту по ее id
	 * @param id - идентификатор Карты
	 * @return - сущность Карта
	 */
	Card getCardById(int id);
	
	/**
	 * Возвращаем Платежный Документ по его id
	 * @param id - идентификатор Платежного Документа 
	 * @return - сущность Платежный Документ
	 */
	PayDocument getPayDocumentById(int id);


	/**
	 * Возвращаем список Счетов Клиента
	 * @param id - идентификатор клиента
	 * @return - список Счетов
	 */
	List<Account> getAccountsByClientId(int id);
	
	/**
	 * Возвращаем список Карт Клиента
	 * @param id - идентификатор клиента
	 * @return - список Карт
	 */
	List<Card> getCardsByClientId(int id);
	
	/**
	 * Возвращаем список Документов Клиента
	 * @param id - идентификатор клиента
	 * @return - список Документов
	 */
	List<PayDocument> getPayDocumentsByClientId(int id, int paymentDirect, Date startDate, Date endDate);

	/**
	 * Платежная транзакция
	 * @param PayDocument  - Платежный документ
	 * @throws CheckPayDocumentException 
	 */
	boolean doPayment (PayDocument payDocument) throws CheckPayDocumentException;


}
