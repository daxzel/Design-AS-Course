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
		<c:forEach items="${kindAdList}" var="kindAd">
				<tr>
						<td onclick="location.href=''">${kindAd.name}</td>
						<td><a href="/users/delete/${kindAd.key}" class="ym-button ym-delete">Удалить</a><a href="/users/edit/${kindsAd.key}" class="ym-button ym-edit">Изменить</a></td>
				</tr>
		</c:forEach>
	</tbody>
</table>
<a href="add" class="ym-button ym-add">Добавить</a>
