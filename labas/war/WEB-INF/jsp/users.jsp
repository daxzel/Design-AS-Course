<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Пользователи системы</h2>

<table class="bordertable">
	<thead>
		<tr>
			<th style="width: 70%;">Имя пользователя</th>
			<th style="width: 30%;">Действия</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${userList}" var="user">
				<tr>
						<td onclick="location.href=''">${user.name}</td>
						<td><a href="/users/delete/${user.key}" class="ym-button ym-delete">Удалить</a><a href="/users/edit/${user.key}" class="ym-button ym-edit">Изменить</a></td>
				</tr>
		</c:forEach>
	</tbody>
	
</table>
<a href="add" class="ym-button ym-add">Добавить</a>




