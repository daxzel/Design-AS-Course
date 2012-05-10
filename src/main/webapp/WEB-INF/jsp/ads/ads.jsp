<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Рекламы</h2>

<table class="bordertable">
	<thead>
		<tr>
			<th style="width: 40%;">Продукт</th>
			<th style="width: 30%;">Тип рекламы</th>
			<th style="width: 30%;">Действия/th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${adsList}" var="ad">
				<tr>
						<td onclick="location.href=''">${ad.product.name}</td>
						<td>${ad.kindAd.name}</td>
						<td><a href="/ads/delete/${ad.key}" class="ym-button ym-delete">Удалить</a><a href="/ads/edit/${ad.key}" class="ym-button ym-edit">Изменить</a></td>
				</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/ads/add" class="ym-button ym-add">Добавить</a>
