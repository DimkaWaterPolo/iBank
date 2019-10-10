<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="panel-content-wrapper">
	<div class="caption-panel-content">Документы</div>
	<div class="splitter"></div>
		<table class="docs_table">
			<caption></caption>
			<thead>
				<tr>
					<td class="next_page" colspan="6"><a href="#">Следующая>></a>
					</td>
				</tr>
				<tr class="filter-table">
					<td colspan="6">
						<form id="form-filter-docs">
							<span class="span-filter-table">
							 <label	display="inline-block">Вид платежа</label>
							 <select name="direct" display="inline-block">
							 	<c:forEach items="${docsFilter.paymentDirects}" var="paymentDirect">
							 		<c:if test="${docsFilter.direct == paymentDirect.direct}">
										<option selected value="${paymentDirect.direct}">${paymentDirect.name}</option>
									</c:if>
							 		<c:if test="${docsFilter.direct != paymentDirect.direct}">
										<option value="${paymentDirect.direct}">${paymentDirect.name}</option>
									</c:if>
								</c:forEach>
							</select>
							</span>
							 <span class="span-filter-table"> 
							 	<label>с</label>
							 	 <input	name="startDate" type="date" value="<fmt:formatDate value='${docsFilter.startDate}' type='date' pattern='yyyy-MM-dd'/>"></input>
							</span>
							<span class="span-filter-table">
								 <label>по</label>
								 <input	name="endDate" type="date" value="<fmt:formatDate value='${docsFilter.endDate}' type='date' pattern='yyyy-MM-dd'/>"></input>
							</span> 
							<span class="span-filter-table"> 
								<input type="button" value="Применить" onclick="getDocsAjax()"></input>
							</span>
						</form>
					</td>
				</tr>
				<tr class="caption-columns-table">
					<th class="th_caption-column-table"></th>
					<th class="th_caption-column-table">Тип</th>
					<th class="th_caption-column-table">Номер</th>
					<th class="th_caption-column-table">Дата</th>
					<th class="th_caption-column-table">Назначение платежа</th>
					<th class="th_caption-column-table">Сумма</th>
				</tr>
				<c:forEach items="${docs}" var="doc">
					<tr class="row-table">
						<th class="th-row-table">
							<img alt="Ready" src = "<c:url value="/resources/images/ready.gif" />" />
						</th>
						<th class="th-row-table">Тип</th>
						<th class="th-row-table">${doc.number}</th>
						<th class="th-row-table"><fmt:formatDate value='${doc.date}' type='date' pattern='yyyy-MM-dd'/></th>
						<th class="th-row-table">${doc.ground}</th>
						<th class="th-row-table">${doc.sum}</th>
					</tr>
				</c:forEach>
				<tr>
					<td class="next_page" colspan="6"><a href="#">Следующая>></a>
					</td>
				</tr>

			</thead>
		</table>
</div>