/*
 * Сущности предметной области
 * Слой прикладных объектов ИС
 */

package ru.ssv.dbo.idelphin.entities;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

/**
 * Сущность - Пользователь системы
 * @author Scheglov
 */

public class Client {
	
    private int id = -1;
    private String lastName = "";
    private String firstName = "";
    private String surName = "";
    private Date bornDate;
    private Date regDate;
    private Date inputDate;
    private String clientName = "";
    
    @Size(min=6, message="Логин должен быть больше 6 знаков")
    String login = "";
    
    @Size(min=5, max=10, message="Пароль должен быть от 5 до 10 знаков")
    String password = "";
    
    List<Account> accounts;
    List<Card> cards;

    public Client() {
    }
    
    public Client (int id, String login, String lastName, String firstName, String surName) {
    	this.id = id;
    	this.login = login;
    	this.lastName = lastName;
        this.firstName = firstName;
        this.surName = surName;
    }
    

    public Client(int id, String lastName, String firstName, String surName, Date bornDate, Date regDate, Date inputDate, String login, String password, List<Account> accounts, List<Card> cards) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.surName = surName;
        this.bornDate = bornDate;
        this.regDate = regDate;
        this.inputDate = inputDate;
        this.login = login;
        this.password = password;
        this.accounts = accounts;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public String getClientName() {
    	return this.lastName + " " + this.firstName + " " + this.surName;
    }
    
    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

  
    @Override
    public String toString() {
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append(" ID: " + this.id);
    	stringBuilder.append(" Фамилия: " + this.lastName);
    	stringBuilder.append(" Имя: " + this.firstName);
    	stringBuilder.append(" Отчество: " + this.surName);
    	stringBuilder.append(" Наименование: " + this.getClientName());
    	stringBuilder.append(" Логин: " + this.login);
    	stringBuilder.append(" Пароль: " + this.password);
    	return stringBuilder.toString();
    }
    
}
