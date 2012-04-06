<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Типы реклам</h2>

<table class="bordertable">
	<thead>
		<tr>
			<th style="width: 70%;">Название</th>
			<th style="width: 30%;">Действия</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${kindsAdList}" var="kindAd">
				<tr>
						<td onclick="location.href=''">${kindAd.name}</td>
						<td><a href="/kindsAd/delete/${kindAd.key}" class="ym-button ym-delete">Удалить</a><a href="/kindsAd/edit/${kindAd.key}" class="ym-button ym-edit">Изменить</a></td>
				</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/kindsAd/add" class="ym-button ym-add">Добавить</a>
