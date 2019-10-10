package ru.sds.iBank.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.sds.iBank.dao.interf.IDao;
import ru.sds.iBank.entities.Account;
import ru.sds.iBank.entities.Card;
import ru.sds.iBank.entities.Client;
import ru.sds.iBank.entities.PayDocument;

public class Dao implements IDao {
	
	private final String classDriverName = "com.mysql.jdbc.Driver";
	private final String jdbcUrl = "jdbc:mysql://localhost:3306/ibank?autoReconnect=true&useSSL=false";
	private final String SQL_SELECT_CLIENT_BY_LOGIN = "SELECT * FROM ibank.Client WHERE login = ?";
	private final String SQL_SELECT_CLIENT_BY_ID = "SELECT * FROM ibank.Client WHERE idClient = ?";
	private final String SQL_SELECT_ACCOUNT_BY_NUMBER = "SELECT * FROM ibank.account WHERE number = ?";
	private final String SQL_SELECT_ACCOUNT_BY_ID = "SELECT * FROM ibank.account WHERE idaccount = ?";
	private final String SQL_SELECT_CARD_BY_NUMBER = "SELECT * FROM ibank.Card WHERE number = ?";
	private final String SQL_SELECT_CARD_BY_ID = "SELECT * FROM ibank.Card WHERE idCard = ?";
	private final String SQL_SELECT_ACCOUNT_BY_CLIENT_ID = "SELECT * FROM ibank.account WHERE id_client = ?";
	private final String SQL_SELECT_CARD_BY_CLIENT_ID = "SELECT * FROM ibank.Card WHERE id_client = ?";
	private final String SQL_UPDATE_WRITTE_OFF = "UPDATE ibank.account set rest=rest-? where number=?";
	private final String SQL_UPDATE_ENROLLEMENT = "UPDATE ibank.account set rest=rest+? where number=?";
	private final String SQL_SELECT_PAYDOCUMENT_BY_ID = "SELECT * FROM ibank.payDocument WHERE idpayDocument = ?";
	
	public Dao() {
		try {
			Class.forName(classDriverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Client getClientByLogin(String login) {
		Client client = null;
		
		try(Connection connection = DriverManager.getConnection(jdbcUrl, "root", "shheglo1996v");
				PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CLIENT_BY_LOGIN);
				) {
			statement.setString(1, login);
			
			try(ResultSet resultSet = statement.executeQuery();){
			
			while(resultSet.next()) {
				client = new Client(resultSet.getInt("idClient"), 
						resultSet.getString("firstName"),
							resultSet.getString("lastName"), 
								resultSet.getString("surName"), 
									resultSet.getDate("bornName"),
										resultSet.getDate("regData"),
											resultSet.getString("login"),
												resultSet.getString("password"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return client;
	}

	public Client getClientById(int id) {
		Client client = null;
		
		try(Connection connection = DriverManager.getConnection(jdbcUrl, "root", "shheglo1996v");
				PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CLIENT_BY_ID);
				) {
			statement.setInt(1, id);
			
			try(ResultSet resultSet = statement.executeQuery();){
			
			while(resultSet.next()) {
				client = new Client(resultSet.getInt("idClient"), 
						resultSet.getString("firstName"),
							resultSet.getString("lastName"), 
								resultSet.getString("surName"), 
									resultSet.getDate("bornName"),
										resultSet.getDate("regData"),
											resultSet.getString("login"),
												resultSet.getString("password"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return client;
	}

	public Account getAccountByNumber(String number) {
		Account account = null;
		
		try(Connection connection = DriverManager.getConnection(jdbcUrl, "root", "shheglo1996v");
				PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ACCOUNT_BY_NUMBER);
				) {
			statement.setString(1, number);
			
			try(ResultSet resultSet = statement.executeQuery();){
			
			while(resultSet.next()) {
				account = new Account(resultSet.getInt("idaccount"), 
										resultSet.getString("number"),
											resultSet.getString("name"), 
												resultSet.getDate("opendate"),
													resultSet.getDate("closedate"),
														resultSet.getInt("rest"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return account;
	}

	public Account getAccountById(int id) {
		Account account = null;
		
		try(Connection connection = DriverManager.getConnection(jdbcUrl, "root", "shheglo1996v");
				PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ACCOUNT_BY_ID);
				) {
			statement.setInt(1, id);
			
			try(ResultSet resultSet = statement.executeQuery();){
			
			while(resultSet.next()) {
				account = new Account(resultSet.getInt("idaccount"), 
										resultSet.getString("number"),
											resultSet.getString("name"), 
												resultSet.getDate("opendate"),
													resultSet.getDate("closedate"),
														resultSet.getInt("rest"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return account;
	}

	public Card getCardById(int id) {
		Card card = null;
		
		try(Connection connection = DriverManager.getConnection(jdbcUrl, "root", "shheglo1996v");
				PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CARD_BY_ID);
				) {
			statement.setInt(1, id);
			
			try(ResultSet resultSet = statement.executeQuery();){
			
			while(resultSet.next()) {
				card = new Card(resultSet.getInt("idCard"), 
											resultSet.getString("number"), 
												resultSet.getString("name"), 
													resultSet.getDate("opendate")
														);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return card;
	}

	public PayDocument getPayDocumentById(int id) {
		PayDocument payDocument = null;
		
		try(Connection connection = DriverManager.getConnection(jdbcUrl, "root", "shheglo1996v");
				PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PAYDOCUMENT_BY_ID);
				) {
			statement.setInt(1, id);
			
			try(ResultSet resultSet = statement.executeQuery();){
			
			while(resultSet.next()) {
				payDocument = new PayDocument(resultSet.getInt("idpayDocument"), 
													resultSet.getInt("number"), 
														resultSet.getDate("data"), 
															resultSet.getDouble("sum"), 
																resultSet.getString("appointment"), 
																	resultSet.getString("payerAccount"), 
																		resultSet.getString("receiverAccount"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return payDocument;
	}

	public List<Account> getAccountsByClientId(int id) {
		List<Account> accounts = new ArrayList<Account>();
		Client client = getClientById(id);
		
		if(client==null) {
		return null;
		}
		
		try(Connection connection = DriverManager.getConnection(jdbcUrl, "root", "shheglo1996v");
				PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ACCOUNT_BY_CLIENT_ID);
				) {
			statement.setInt(1, client.getId());
			
			try(ResultSet resultSet = statement.executeQuery();){
			
			while(resultSet.next()) {
			accounts.add(new Account(resultSet.getInt("idaccount"),
													resultSet.getString("number"),
														resultSet.getString("name"),
															resultSet.getDate("opendate"),
																resultSet.getDate("closedate"),
																	resultSet.getInt("rest"),
																		getClientById(resultSet.getInt("id_client"))));
				
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return accounts;
		
	}

	public List<Card> getCardsByClientId(int id) {
		List<Card> cards = new ArrayList<Card>();
		Client client = getClientById(id);
		
		if(client==null) {
			return null;
		}
		
		try(Connection connection = DriverManager.getConnection(jdbcUrl, "root", "shheglo1996v");
				PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CARD_BY_CLIENT_ID);
				) {
			statement.setInt(1, client.getId());
			
			try(ResultSet resultSet = statement.executeQuery();){
			
			while(resultSet.next()) {
				cards.add(new Card(resultSet.getInt("idCard"), resultSet.getString("number"), resultSet.getString("name"), 
										resultSet.getDate("opendate"), resultSet.getDate("closedata")));
				
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return cards;
	}

	public List<PayDocument> getPayDocumentByClientId(int id, String nameTransaction, Date startData, Date endData) {
		List<PayDocument> payDocuments = new ArrayList<PayDocument>();
		return payDocuments;
	}

	public boolean doPayment(PayDocument payDocument) {
		if (!(updateWritteOff(payDocument) && updateEnrollment(payDocument))) {
			return false;
		}
		return true;
	}
	
	public boolean updateWritteOff(PayDocument payDocument) {
		
		Account account = getAccountByNumber(payDocument.getPayerAccount());
		if(account == null) {
			return false;
		}
		if(account.getRest()<payDocument.getSum()) {
			return false;
		}
		try(Connection connection = DriverManager.getConnection(jdbcUrl, "root", "shheglo1996v");
				PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_WRITTE_OFF);
				) {
			statement.setDouble(1, payDocument.getSum());
			statement.setString(2, payDocument.getPayerAccount());
			
			if(statement.executeUpdate() == 0) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateEnrollment(PayDocument payDocument) {
		
		Account account = getAccountByNumber(payDocument.getReceiverAccount());
		if(account == null) {
			return false;
		}
		try(Connection connection = DriverManager.getConnection(jdbcUrl, "root", "shheglo1996v");
				PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ENROLLEMENT);
				) {
			statement.setDouble(1, payDocument.getSum());
			statement.setString(2, payDocument.getReceiverAccount());
			
			if(statement.executeUpdate() == 0) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Card getCardByNumber(String number) {
		
	Card card = null;
		
		try(Connection connection = DriverManager.getConnection(jdbcUrl, "root", "shheglo1996v");
				PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CARD_BY_NUMBER);
				) {
			statement.setString(1, number);
			
			try(ResultSet resultSet = statement.executeQuery();){
			
			while(resultSet.next()) {
				card = new Card(resultSet.getInt("idCard"), 
											resultSet.getString("number"), 
												resultSet.getString("name"), 
													resultSet.getDate("opendate")
														);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return card;
	}
}
