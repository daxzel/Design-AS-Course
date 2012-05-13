<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Заказы</h2>

<table class="bordertable">
	<thead>
		<tr>
		    <th style="width: 15%;">Номер заказа</th>
           	<th style="width: 20%;">Название товара</th>
           	<th style="width: 20%;">Название организации</th>
           	<th style="width: 15%;">Количество</th>
           	<th style="width: 30%;">Действия</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${orderList}" var="order">
				<tr>
				        <td onclick="location.href=''">${order.key}</td>
                		<td onclick="location.href=''">${order.production.product.name}</td>
                		<td onclick="location.href=''">${order.organization.name}</td>
                		<td onclick="location.href=''">${order.production.count}</td>
						<td><a href="/orders/delete/${order.key}" class="ym-button ym-delete">Удалить</a><a href="/orders/edit/${order.key}" class="ym-button ym-edit">Изменить</a></td>
				</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/orders/add" class="ym-button ym-add">Добавить</a>
