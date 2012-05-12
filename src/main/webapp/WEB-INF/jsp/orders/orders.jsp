<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Заказы</h2>

<table class="bordertable">
	<thead>
		<tr>
		    <th style="width: 70%;">Название товара</th>
			<th style="width: 30%;">Действия</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${orderList}" var="order">
				<tr>
						<td onclick="location.href=''">${sale.key}</td>
						<td><a href="/orders/delete/${order.key}" class="ym-button ym-delete">Удалить</a><a href="/orders/edit/${order.key}" class="ym-button ym-edit">Изменить</a></td>
				</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/orders/add" class="ym-button ym-add">Добавить</a>
