<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="panel-content-wrapper">
	<div class="caption-panel-content">Платеж</div>
	<div class="splitter"></div>
	<form id="form-payment">
		<table class="payment_table">
			<caption></caption>
			<thead></thead>
			<tbody>
				<tr>
					<td>Счет плательщика</td>
					<td>
						<select id="account_payer_payment" class="input_payment">
							<c:forEach items="${accounts}" var="account">
								<option value="${account.number}">${account.number}</option>
							</c:forEach>
						</select>
						<span id="error_account_payer_payment" class="error-message"></span>
					</td>
				</tr>
				<tr>
					<td>Счет получателя</td>
					<td>
						<input id="account_receiver_payment" class="input_payment"></input>
						<span id="error_account_receiver_payment" class="error-message"></span>
					</td>
				</tr>
				<tr>
					<td>Сумма</td>
					<td>
						<input id="sum_payment" class="input_payment"></input>
						<span id="error_sum_payment" class="error-message"></span>
					</td>
				</tr>
				<tr>
					<td>Назначение</td>
					<td>
						<textarea id="ground_payment" cols="30"></textarea>
						<span id="error_ground_payment" class="error-message"></span>
					</td>
				</tr>
				<tr>
					<td class="submit" colspan="2" align="center">
						<input value="Транзакция" type="button" onclick="doPayment()"></input>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>	