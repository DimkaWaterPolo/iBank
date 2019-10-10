package ru.ssv.dbo.idelphin.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.ssv.dbo.idelphin.dao.IDao;
import ru.ssv.dbo.idelphin.entities.Account;
import ru.ssv.dbo.idelphin.entities.Card;
import ru.ssv.dbo.idelphin.entities.Client;
import ru.ssv.dbo.idelphin.entities.PayDocument;
import ru.ssv.dbo.idelphin.enums.PaymentDirectEnum;
import ru.ssv.dbo.idelphin.exception.CheckPayDocumentException;
import ru.ssv.dbo.idelphin.jsp.model.DocsFilter;

/**
 * Реализация интерфейса доступа к данным
 * 
 * Уровень доступа к данным
 * 
 * @author Scheglov
 *
 */
public class DaoImpl implements IDao {
	
	private final static String SQL_SELECT_CLIENT_BY_LOGIN ="select * from client where login=:login";
	private final static String SQL_SELECT_CLIENT_BY_ID ="select * from client where id=:id";
	private final static String SQL_SELECT_ACCOUNT_BY_ID ="select * from account where id=:id";
	private final static String SQL_SELECT_ACCOUNT_BY_NUMBER ="select * from account where number=:number";
	private final static String SQL_SELECT_ACCOUNT_COUNT_BY_NUMBER ="select count(*) from account where number=:number";
	private final static String SQL_SELECT_ACCOUNTS_BY_CLIENTID ="select * from account where id_client=:id_client";
	private final static String SQL_SELECT_CARD_BY_ID ="select * from card where id=:id";
	private final static String SQL_SELECT_CARDS_BY_CLIENTID ="select * from card where id_client=:id_client";
	private final static String SQL_SELECT_PAYDOCUMENT_BY_ID ="select * from account_payment where id=:id";
	private final static String SQL_SELECT_PAYDOCUMENTS_ALL_BY_CLIENTID ="select distinct doc.id, acc.id_client, doc.number, doc.account_payer, doc.account_receiver, doc.sum, doc.ground, doc.date from idelphin.account_payment as doc inner join idelphin.account as acc where (doc.account_payer = acc.number or doc.account_receiver = acc.number) and (acc.id_client = :id_client) and ((doc.date >= :startDate) and (doc.date <= :endDate))";
	private final static String SQL_SELECT_PAYDOCUMENTS_DEBIT_BY_CLIENTID ="select * from idelphin.account_payment as doc inner join idelphin.account as acc where (doc.account_payer = acc.number) and (acc.id_client = :id_client) and ((doc.date >= :startDate) and (doc.date <= :endDate))";
	private final static String SQL_SELECT_PAYDOCUMENTS_CREDIT_BY_CLIENTID ="select * from idelphin.account_payment as doc inner join idelphin.account as acc where (doc.account_receiver = acc.number) and (acc.id_client = :id_client) and ((doc.date >= :startDate) and (doc.date <= :endDate))";
	private final static String SQL_INSERT_PAYDOCUMENTS ="insert into idelphin.account_payment (date, number, account_payer, account_receiver, sum, ground) values (:date, :number, :account_payer, :account_receiver, :sum, :ground)";
	private final static String SQL_UPDATE_ACCOUNT_REST ="update account set rest=rest-:sum  where number=:number";
		
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Client getClientByLogin(String login) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("login", login);

		return jdbcTemplate.queryForObject(
				SQL_SELECT_CLIENT_BY_LOGIN,	params,
				
				new RowMapper<Client>() {
					
					@Override
					public Client mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						
						Client client = new Client();
						
						client.setId(rs.getInt("id"));
						client.setLastName(rs.getString("lastName"));
						client.setFirstName(rs.getString("firstName"));
						client.setSurName(rs.getString("surName"));
						client.setLogin(rs.getString("login"));
						client.setPassword(rs.getString("password"));
						client.setBornDate(rs.getDate("bornDate"));
						
						return client;
					}
					
				});	
	}

	@Override
	public Client getClientById(int id) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		return jdbcTemplate.queryForObject(
				SQL_SELECT_CLIENT_BY_ID,	params,
				
				new RowMapper<Client>() {
					
					@Override
					public Client mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						
						Client client = new Client();
						
						client.setId(rs.getInt("id"));
						client.setLastName(rs.getString("lastName"));
						client.setFirstName(rs.getString("firstName"));
						client.setSurName(rs.getString("surName"));
						client.setLogin(rs.getString("login"));
						client.setPassword(rs.getString("password"));
						client.setBornDate(rs.getDate("bornDate"));
						
						return client;
					}
					
				});	

	}
	
	@Override
	public Account getAccountById(int id) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		return jdbcTemplate.queryForObject(
				SQL_SELECT_ACCOUNT_BY_ID,	params,
				
				new RowMapper<Account>() {
					
					@Override
					public Account mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						
						Account account = new Account();
						
						account.setId(rs.getInt("id"));
						account.setNumber(rs.getString("number"));
						account.setName(rs.getString("name"));
						account.setOpendate(rs.getDate("openDate"));
						account.setClient(getClientById(rs.getInt("id_client")));
						account.setRest(rs.getDouble("rest"));
						return account;
					}
					
				});	
	}
	
	@Override
	public Account getAccountByNumber(String number) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("number", number);

		return jdbcTemplate.queryForObject(
				SQL_SELECT_ACCOUNT_BY_NUMBER,	params,
				
				new RowMapper<Account>() {
					
					@Override
					public Account mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						
						Account account = new Account();
						
						account.setId(rs.getInt("id"));
						account.setNumber(rs.getString("number"));
						account.setName(rs.getString("name"));
						account.setOpendate(rs.getDate("openDate"));
						account.setClient(getClientById(rs.getInt("id_client")));
						account.setRest(rs.getDouble("rest"));
						
						return account;
					}
					
				});	
		
	}

	private boolean isExistAccount(String account) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("number", account);

		return (jdbcTemplate.queryForInt(SQL_SELECT_ACCOUNT_COUNT_BY_NUMBER, params) > 0);
	}

	@Override
	public Card getCardById(int id) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		return jdbcTemplate.queryForObject(
				SQL_SELECT_CARD_BY_ID,	params,
				
				new RowMapper<Card>() {
					
					@Override
					public Card mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						
						Card card = new Card();
						
						card.setId(rs.getInt("id"));
						card.setNumber(rs.getString("number"));
						card.setName(rs.getString("name"));
						card.setOpendate(rs.getDate("openDate"));
						card.setClosedate(rs.getDate("closeDate"));
						card.setClient(getClientById(rs.getInt("id_client")));
						card.setAccount(getAccountById(rs.getInt("id_account")));
						
						return card;
					}
					
				});	
	}

	@Override
	public PayDocument getPayDocumentById(int id) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		return jdbcTemplate.queryForObject(
				SQL_SELECT_PAYDOCUMENT_BY_ID,	params,
				
				new RowMapper<PayDocument>() {
					
					@Override
					public PayDocument mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						
						PayDocument pd = new PayDocument();
						
						pd.setId(rs.getInt("id"));
						pd.setNumber(rs.getInt("number"));
						pd.setGround(rs.getString("ground"));
						pd.setDate(rs.getDate("date"));
						pd.setSum(rs.getDouble("sum"));
						pd.setPayerAccount(rs.getString("account_payer"));
						pd.setReceiverAccount(rs.getString("account_receiver"));					
						return pd;
					}
					
				});	
	}


	@Override
	public List<Account> getAccountsByClientId(int id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_client", id);

		List<Account> accounts = jdbcTemplate.query(SQL_SELECT_ACCOUNTS_BY_CLIENTID, params, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getAccountById(rs.getInt("id"));
			}
			
		});

		return accounts;
	}

	@Override
	public List<Card> getCardsByClientId(int id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_client", id);

		List<Card> cards = jdbcTemplate.query(SQL_SELECT_CARDS_BY_CLIENTID, params, new RowMapper<Card>() {

			@Override
			public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getCardById(rs.getInt("id"));
			}
			
		});
		
		return cards;
	}

	@Override
	public List<PayDocument> getPayDocumentsByClientId(int id, int paymentDirect, Date startDate, Date endDate) {

		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("id_client", id);
		params.put("startDate", new SimpleDateFormat("yyyy-MM-dd").format(startDate));
		params.put("endDate", new SimpleDateFormat("yyyy-MM-dd").format(endDate) +  "24:60:60");
			
		String sql = SQL_SELECT_PAYDOCUMENTS_ALL_BY_CLIENTID;
		
		if (paymentDirect == DocsFilter.DIRECT_PAYMENT_DEBIT)
			sql = SQL_SELECT_PAYDOCUMENTS_DEBIT_BY_CLIENTID;
		else if (paymentDirect == DocsFilter.DIRECT_PAYMENT_CREDIT)
			sql = SQL_SELECT_PAYDOCUMENTS_CREDIT_BY_CLIENTID;
		
		List<PayDocument> docs = jdbcTemplate.query(sql, params, new RowMapper<PayDocument>() {

			@Override
			public PayDocument mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getPayDocumentById(rs.getInt("id"));
			}
			
		});
		
		return docs;

	}

	@Override
	@Transactional (propagation=Propagation.REQUIRES_NEW)
	public boolean doPayment(PayDocument payDocument) throws CheckPayDocumentException {
		
		if (!checkPayDocument(payDocument))
			throw new CheckPayDocumentException("Сумма документа превышает остаток по счету");
		
		insertPayDocument(payDocument);
		
		updateCurrentAccountRest(PaymentDirectEnum.DEBIT, payDocument.getPayerAccount(), payDocument.getSum());
		
		updateCurrentAccountRest(PaymentDirectEnum.CREDIT, payDocument.getReceiverAccount(), payDocument.getSum());
		
		return true;
	}
	
	private boolean checkPayDocument(PayDocument doc) {
		return (getAccountByNumber(doc.getPayerAccount()).getRest() >= doc.getSum()); 
	}

	@Transactional (propagation=Propagation.MANDATORY)
	private boolean insertPayDocument(PayDocument doc) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("date", doc.getDate());
		params.put("number", doc.getNumber());
		params.put("account_payer", doc.getPayerAccount());
		params.put("account_receiver", doc.getReceiverAccount());
		params.put("sum", doc.getSum());
		params.put("ground", doc.getGround());
		
		return (jdbcTemplate.update(SQL_INSERT_PAYDOCUMENTS, params) > 0);
	}

	@Transactional (propagation=Propagation.MANDATORY)
	private boolean updateCurrentAccountRest(PaymentDirectEnum paymentDirectEnum, String account, double sum ) {
		
		if (! isExistAccount(account))
			return true;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("number", account);
		
		if (paymentDirectEnum == PaymentDirectEnum.DEBIT) 
			params.put("sum", sum);
		else
			params.put("sum", -sum);
		
		return (jdbcTemplate.update(SQL_UPDATE_ACCOUNT_REST, params) > 0);
	}

}
