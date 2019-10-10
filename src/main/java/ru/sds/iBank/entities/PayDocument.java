package ru.sds.iBank.entities;

import java.util.Date;

public class PayDocument {
	
	private int id;
	private int number;
	private Date data;
	private double sum;
	private String appointment;
	private String payerAccount;
	private String receiverAccount;
	private Client client;
	
	public PayDocument() {
		super();
	}
	
	public PayDocument(int id, int number, Date data, double sum, String appointment, String payerAccount,
			String receiverAccount) {
		super();
		this.id = id;
		this.number = number;
		this.data = data;
		this.sum = sum;
		this.appointment = appointment;
		this.payerAccount = payerAccount;
		this.receiverAccount = receiverAccount;
	}


	public PayDocument(int id, int number, Date data, double sum, String appointment, String payerAccount,
			String receiverAccount, Client client) {
		super();
		this.id = id;
		this.number = number;
		this.data = data;
		this.sum = sum;
		this.appointment = appointment;
		this.payerAccount = payerAccount;
		this.receiverAccount = receiverAccount;
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public String getAppointment() {
		return appointment;
	}
	public void setAppointment(String appointment) {
		this.appointment = appointment;
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

	@Override
	public String toString() {
		return "PayDocument [id=" + id + ", number=" + number + ", data=" + data + ", sum=" + sum + ", appointment="
				+ appointment + ", payerAccount=" + payerAccount + ", receiverAccount=" + receiverAccount + "]";
	}
	
	
	

}
