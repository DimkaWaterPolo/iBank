
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="panel-content-wrapper">
	<div class="caption-panel-content">Сообщение</div>
	<div class="splitter"></div>
	<div id="message-banner">
		<div id="header-message-banner">${message.header}</div>
		<div id="body-message-banner">${message.content}</div>
	</div>
</div>	