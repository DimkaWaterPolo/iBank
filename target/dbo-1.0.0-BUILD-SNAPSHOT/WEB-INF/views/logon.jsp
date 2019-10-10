<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4.loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"/>
	<title>Авторизация пользователя</title>
</head>
<body>
		<div id="page">
			<div id="maket-wrapper" class="width-page-wrapper">
				<div id="header-wrapper">
					<div id="pre-header">
						<div id="pre-header-left">
							<span id="caption-pre-header">Регистрация</span>
						</div>	
						<div id="pre-header-right">
							<a href="?lang=ru">ru</a>
							<a href="?lang=en">en</a>
						</div>
					</div>
					<div id="header">
						<div id="image-header"></div>
						<div id="text-header"><spring:message code="Internet_Bank"/></div>
						<div id="contact-header">
							<span id="phone-icon-contact-header">8 (495) 740-40-40</span>
							<span>8 (800) 200-70-40</span>
						</div>
					</div>
					<div id="after-header">
					</div>
				</div>
				<div id="content-wrapper">
					<div id="form-auth-panel">
						<div id="message-banner">
							<div id="header-message-banner">
								${message.header}
							</div>
							<div id="body-message-banner">
								${message.content}
							</div>
						</div>
						<form id="form-auth" method="post" action= "/idelphin/checkUser">
							<div id="header-form-auth">
								Войти в Интернет-банк
							</div>
							<div id="inputs-form-auth">
								<div class="input-form-auth">
									<input placeholder="Логин" size="13" id="login" name="login" type="text" class="">
									<c:if test="${message.type == message.TYPE_ERROR_VALID_LOGIN_PASSWORD}">
										<span id="login.error" class="error-message">Логин должен быть больше 6 знаков</span>
									</c:if>
								</div>
								<div class="input-form-auth">
									<input placeholder="Пароль" value="" id="password" name="password" type="password" vki_attached="true" class="">
									<c:if test="${message.type == message.TYPE_ERROR_VALID_LOGIN_PASSWORD}">
										<span id="password.error" class="error-message">Пароль должен быть от 5 до 10 знаков</span>
									</c:if>
								</div>
								<div id="button-form-auth">
									<input class="ok" value="Войти" id="submit_0" name="submit_0" type="submit">
								</div>
								<div id="message-form-auth">
									<p>Забыли Логин или Пароль? <br>Звоните (495) 223-01-01 (доб. 1043, 1051) <br>в рабочие дни с 9-00 до 18-00</p>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div id="separator-maket-footer">
				</div>
			</div>
			<div id="footer-wrapper">
				<div class="width-page-wrapper">
					<div class="column-footer">
					<p>
						<b>Система интернет-банкинга iDelphin 2.0</b>
						<br>
						Предоставляется разработчиком Щегловым Д.С.
					</p>
					</br>
					<p>
						8-800-2000-740 
						<br>
						Для звонков по России бесплатно
					</p>
					</br>					
					<p>
						<a target="-blank" href="mailto:shheglov1996@yandex.ru">
							<span>shheglov1996@yandex.ru</span>
						</a> 
						<br>
						Есть предложения? Пишите нам.
					</p>
				</div>
					<div class="column-footer">
						<p>
							<b>«Московский Нефтехимический банк» публичное <br> акционерное общество</b>
						</p>
						</br>
						<p>
							<a target="_blank" href="http://www.mnhb.ru/">БАНК «МНХБ» ПАО</a>
							<br>
							Лицензия Банка № 1411 ЦБ РФ
						</p>
						</br>					
						<p>
							<b>Присоединяйтесь к нам в социальных сетях</b>
							<p>
								<a href="https://www.facebook.com/pages/Московский-Нефтехимический-банк/1396682933918468" target="_blank"><img data-pin-nopin="true" src="resources/images/facebook.png" style="height:20px; width:20px; margin-left:5px; margin-top:4px;"></a>
							</p>
						</p>					
					</div>
					<div class="column-footer">	
						<p>
							<a href="docs/tarifihandy_bank.pdf">Тарифы на предоставление держателям банковских карт БАНКА «МНХБ» ПАО услуг Интернет-банка с использованием Системы iDelphin 2.0</a>
						</p>
						</br>
						<p>
							<a href="docs/Pravila HandyBank.pdf">Правила предоставления держателям банковских карт БАНКА «МНХБ» ПАО услуг Интернет-банка с использованием Системы iDelphin 2.0</a>
						</p>
						</br>
						<p>
							<a href="docs/MNHB_HandyBank_manual.pdf">Руководство пользователя</a>
						</p>
					</div>
				</div>
			</div>
		</div>
</body>
</html>