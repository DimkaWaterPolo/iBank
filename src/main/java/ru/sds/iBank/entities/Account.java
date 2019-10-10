package ru.sds.iBank.entities;

import java.util.Date;

public class Account {

	 private int id;
	 private String number;
	 private String name;
	 private Date opendate;
	 private Date closedate;
	 private double rest;
	 private Client client;
	 
	 
	public Account() {
		super();
	}
	public Account(int id, String number, String name, Date opendate, Date closedate, double rest, Client client) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.opendate = opendate;
		this.closedate = closedate;
		this.rest = rest;
		this.client = client;
	}
	
	
	public Account(int id, String number, String name, Date opendate, Date closedate, double rest) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.opendate = opendate;
		this.closedate = closedate;
		this.rest = rest;
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
	public double getRest() {
		return rest;
	}
	public void setRest(double rest) {
		this.rest = rest;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", number=" + number + ", name=" + name + ", opendate=" + opendate + ", closedate="
				+ closedate + ", rest=" + rest + ", client=" + client + "]";
	}
	 
	
	 
}
