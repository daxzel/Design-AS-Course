<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Организации</h2>

<table class="bordertable">
	<thead>
		<tr>
		    <th style="width: 30%;">код ОКПО</th>
			<th style="width: 40%;">Название организации</th>
			<th style="width: 30%;">Действия</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${organizationList}" var="organization">
				<tr>
				        <td onclick="location.href=''">${organization.NCEO}</td>
						<td onclick="location.href=''">${organization.name}</td>
						<td><a href="/organizations/delete/${organization.key}" class="ym-button ym-delete">Удалить</a><a href="/organizations/edit/${organization.key}" class="ym-button ym-edit">Изменить</a></td>
				</tr>
		</c:forEach>
	</tbody>
	
</table>
<a href="/organizations/add" class="ym-button ym-add">Добавить</a>




