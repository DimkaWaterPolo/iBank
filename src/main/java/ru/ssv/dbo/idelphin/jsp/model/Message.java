package ru.ssv.dbo.idelphin.jsp.model;

public class Message {
	
	public static final int TYPE_UNDEFINE					= -1;	// неизвестный тип сообщения
	public static final int TYPE_BANNER						= 1;	// сообщение баннера
	public static final int TYPE_ERROR_VALID_LOGIN_PASSWORD	= 2;	// ошибка валидации логина и пароля
	public static final int TYPE_ERROR_AUTHORIZATION		= 3;	// ошибка авторизации
	public static final int TYPE_RESULT_DO_PAYMENT			= 4;	// ошибка при проводки платежа
	public static final int TYPE_ERROR_SYSTEM				= 5;	// системная ошибка
	
	private int    type	= TYPE_UNDEFINE;
	private String header;
	private String content;

	public Message() {

	}

	public Message(int type, String header, String content) {
		super();
		this.type   = type;
		this.header = header;
		this.content = content;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public int getTYPE_ERROR_VALID_LOGIN_PASSWORD() {
		return TYPE_ERROR_VALID_LOGIN_PASSWORD;
	}
	
}
