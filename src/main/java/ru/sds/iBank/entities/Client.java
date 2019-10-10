package ru.sds.iBank.entities;

import java.util.Date;
import java.util.List;

public class Client {
	
	private int id;
	private String firstName;
	private String lastName;
	private String surName;
	private Date bornName;
	private Date regData;
	private String login;
	private String password;
	private List<Card> cards;
	private List<Account> accounts;
	
	
	public Client() {
		super();
	}
	
	public Client(int id, String firstName, String lastName, String surName, Date bornName, Date regData, String login,
			String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.surName = surName;
		this.bornName = bornName;
		this.regData = regData;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public Date getBornName() {
		return bornName;
	}
	public void setBornName(Date bornName) {
		this.bornName = bornName;
	}
	public Date getRegData() {
		return regData;
	}
	public void setRegData(Date regData) {
		this.regData = regData;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", surName=" + surName
				+ ", bornName=" + bornName + ", regData=" + regData + ", login=" + login + ", password=" + password
				+ "]" ;
	}
	
	
	
	
	

}
