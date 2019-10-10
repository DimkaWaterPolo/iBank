/*
 * Сущности предметной области
 * Слой прикладных объектов ИС
 */

package ru.ssv.dbo.idelphin.entities;

import java.util.Date;

/**
 * Сущность - Банковская карта
 * @author Scheglov
 */
public class Card {
    
    private int id;
    private String number;
    private String name;
    private Date opendate;
    private Date closedate;
    private Account account;
    private Client client;

    public Card() {
    }

    public Card(int id, String number, String name, Date opendate, Date closedate, Account account) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.opendate = opendate;
        this.closedate = closedate;
        this.account = account;
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
}
