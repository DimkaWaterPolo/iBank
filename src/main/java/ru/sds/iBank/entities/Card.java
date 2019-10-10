package ru.sds.iBank.entities;

import java.util.Date;

public class Card {

	private int id;
    private String number;
    private String name;
    private Date opendate;
    private Date closedate;
    private Account account;
    private Client client;
    
	public Card(int id, String number, String name, Date opendate, Date closedate, Account account, Client client) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.opendate = opendate;
		this.closedate = closedate;
		this.account = account;
		this.client = client;
	}
	
	

	public Card(int id, String number, String name, Date opendate) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.opendate = opendate;
	}



	public Card(int id, String number, String name, Date opendate, Date closedate) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.opendate = opendate;
		this.closedate = closedate;
	}



	public Card() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	public Date getClosedate() {
		return closedate;
	}

	public void setClosedate(Date closedate) {
		this.closedate = closedate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", number=" + number + ", name=" + name + ", opendate=" + opendate + ", closedate="
				+ closedate  + ", account=" + account +", client=" + client + "]" +"\n";
	}
	
	
    
    
}
