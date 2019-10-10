<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="panel-content-wrapper">
	<div class="caption-panel-content">Карты</div>
	<div class="splitter"></div>
		<c:if test="${cards.size() == 0}">
			<div class="item-panel-content">
				Список пуст
			</div>
		</c:if>
		<c:if test="${cards.size() > 0}">
			<c:forEach items="${cards}" var="card">
				<div class="item-panel-content">
					<div class="left-item-panel-content">
						<div class="str1-left-item-panel-content">
							<a id="accountLinkComp_153a9df432bd69" href="#">Карта&nbsp;${card.number}&nbsp;(RUB)</a>
						</div>
						<div class="str2-left-item-panel-content">
							${card.name}. Открыт до ${card.closedate}
						</div>
					</div>
					<div class="right-item-panel-content">
						${card.account.rest} RUB
					</div>
				</div>
			</c:forEach>
		</c:if>
</div>