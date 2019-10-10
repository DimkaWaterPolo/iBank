package ru.ssv.dbo.idelphin.jsp.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocsFilter {
	
	public static final int COUNT_DOCS_ON_PAGE = 10;
	public static final int DIRECT_PAYMENT_ALL = 1;
	public static final int DIRECT_PAYMENT_DEBIT = 2;
	public static final int DIRECT_PAYMENT_CREDIT = 3;

	private List<PaymentDirect> paymentDirects = new ArrayList<PaymentDirect>();
	
	private int direct = DIRECT_PAYMENT_ALL;
	private Date startDate;
	private Date endDate;

	private String strStartDate;
	private String strEndDate;

	public DocsFilter() {
		paymentDirects.add(new PaymentDirect(DIRECT_PAYMENT_ALL, "Все"));
		paymentDirects.add(new PaymentDirect(DIRECT_PAYMENT_DEBIT, "Списание"));
		paymentDirects.add(new PaymentDirect(DIRECT_PAYMENT_CREDIT, "Зачисление"));
	}

	public DocsFilter(int direct, Date startDate, Date endDate) {
		this();
		this.direct = direct;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getDIRECT_PAYMENT_ALL() {
		return DIRECT_PAYMENT_ALL;
	}

	public int getDIRECT_PAYMENT_DEBIT() {
		return DIRECT_PAYMENT_DEBIT;
	}

	public int getDIRECT_PAYMENT_CREDIT() {
		return DIRECT_PAYMENT_CREDIT;
	}
	
	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

	public List<PaymentDirect> getPaymentDirects() {
		return paymentDirects;
	}

	public void setPaymentDirects(List<PaymentDirect> paymentDirects) {
		this.paymentDirects = paymentDirects;
	}

	public String getStrStartDate() {
		return strStartDate;
	}

	public void setStrStartDate(String strStartDate) {
		
		this.strStartDate = strStartDate;
		
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		try {
			this.startDate = format.parse(strStartDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getStrEndDate() {
		return strEndDate;
	}

	public void setStrEndDate(String strEndDate) {
		
		this.strEndDate = strEndDate;
		
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		try {
			this.endDate = format.parse(strEndDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
		
}
