/*
 * Сущности предметной области
 * Слой прикладных объектов ИС
 */

package ru.ssv.dbo.idelphin.entities;

import java.util.Date;

/**
 * Сущность - Платежный Документ
 * @author Scheglov
 */
public class PayDocument {
	
	private int id;
	private int number;
	private Date date = new Date();
	private String ground;
	private double sum;
	private String payerAccount;
	private String receiverAccount;
	
	public PayDocument() {
	}

	public PayDocument(int id, int number, Date date, String ground, double sum, String payerAccount, String receiverAccount) {
		super();
		this.id = id;
		this.number = number;
		this.date = date;
		this.ground = ground;
		this.sum = sum;
		this.payerAccount = payerAccount;
		this.receiverAccount = receiverAccount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGround() {
		return ground;
	}

	public void setGround(String ground) {
		this.ground = ground;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public String getPayerAccount() {
		return payerAccount;
	}

	public void setPayerAccount(String payerAccount) {
		this.payerAccount = payerAccount;
	}

	public String getReceiverAccount() {
		return receiverAccount;
	}

	public void setReceiverAccount(String receiverAccount) {
		this.receiverAccount = receiverAccount;
	}
}
