<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Заказы</h2>

<table class="bordertable">
	<thead>
		<tr>
		    <th style="width: 20%;">Заказчик</th>
		     <th style="width: 20%;">Срок поставки</th>
		     <th style="width: 10%;">Объём</th>
		     <th style="width: 20%;">Стоимость</th>
		     <th style="width: 20%;">Дата предоплаты</th>
		     <th style="width: 10%;">Цена за единицу</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${orderList}" var="order">
				<tr>
				    <td>${order.organization.name}</td>
				    <td>${order.dateBegin}</td>
				    <td>${order.production.count}</td>
				    <td>${order.amount}</td>
				    <td>${order.datePayment}</td>
				    <td>${order.price}</td>
				</tr>
		</c:forEach>
	</tbody>
</table>
