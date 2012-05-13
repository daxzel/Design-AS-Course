<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Продажи</h2>

<table class="bordertable">
	<thead>
		<tr>
        		    <th style="width: 15%;">Номер продажи</th>
                   	<th style="width: 20%;">Название товара</th>
                   	<th style="width: 20%;">Название организации</th>
                   	<th style="width: 15%;">Количество</th>
                   	<th style="width: 30%;">Действия</th>
        		</tr>
	</thead>
	<tbody>
		<c:forEach items="${saleList}" var="sale">
				<tr>
				        <td onclick="location.href=''">${sale.key}</td>
						<td onclick="location.href=''">${sale.production.product.name}</td>
						<td onclick="location.href=''">${sale.organization.name}</td>
						<td onclick="location.href=''">${sale.production.count}</td>
						<td><a href="/sales/delete/${sale.key}" class="ym-button ym-delete">Удалить</a><a href="/sales/edit/${sale.key}" class="ym-button ym-edit">Изменить</a></td>
				</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/sales/add" class="ym-button ym-add">Добавить</a>
