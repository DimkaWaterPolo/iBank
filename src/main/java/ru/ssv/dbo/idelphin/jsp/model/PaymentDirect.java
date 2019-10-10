package ru.ssv.dbo.idelphin.jsp.model;

public class PaymentDirect {
	
	private int direct;
	private String name;
	
	public PaymentDirect() {
	}

	public PaymentDirect(int direct, String name) {
		super();
		this.direct = direct;
		this.name = name;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
