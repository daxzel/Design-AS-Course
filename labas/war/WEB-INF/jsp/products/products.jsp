<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Группы товаров</h2>

<table class="bordertable">
	<thead>
		<tr>
			<th style="width: 20%;">ОКП</th>
			<th style="width: 50%;">Название</th>
			<th style="width: 30%;">Действия</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${groupList}" var="group">
				<tr>
						<td onclick="location.href='${group.NCP}'">${group.NCP}</td>
						<td>${group.name}</td>
						<td><a href="/groups/delete/${group.NCP}" class="ym-button ym-delete">Удалить</a><a href="/groups/edit/${group.NCP}" class="ym-button ym-edit">Изменить</a></td>
				</tr>
		</c:forEach>
	</tbody>
	
</table>
<a href="add" class="ym-button ym-add">Добавить</a>




