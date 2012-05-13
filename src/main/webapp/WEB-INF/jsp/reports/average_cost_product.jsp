<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Заказы</h2>

<table class="bordertable">
	<thead>
		<tr>
		    <th style="width: 25%;">Месяц</th>
		     <th style="width: 25%;">Объём продаж</th>
		     <th style="width: 25%;">Выручка</th>
		     <th style="width: 25%;">Расходы на рекламу</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${result.result}" var="monthsAmountsMargins">
				<tr>
				    <td>${monthsAmountsMargins.month}</td>
				    <td>${monthsAmountsMargins.amount}</td>
				    <td>${monthsAmountsMargins.margin}</td>
				    <td>${monthsAmountsMargins.adCost}</td>
				</tr>
		</c:forEach>
	</tbody>
</table>
