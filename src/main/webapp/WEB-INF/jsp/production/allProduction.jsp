<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Производства</h2>

<table class="bordertable">
	<thead>
		<tr>
		     <th style="width: 20%;">Номер производства</th>
		    <th style="width: 30%;">Название товара</th>
		     <th style="width: 20%;">Количество</th>
			<th style="width: 30%;">Действия</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productionList}" var="production">
				<tr>
				        <td onclick="location.href=''">${production.key}</td>
						<td onclick="location.href=''">${production.product.name}</td>
						<td onclick="location.href=''">${production.count}</td>
						<td><a href="/production/delete/${production.key}" class="ym-button ym-delete">Удалить</a><a href="/production/edit/${production.key}" class="ym-button ym-edit">Изменить</a></td>
				</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/production/add" class="ym-button ym-add">Добавить</a>
