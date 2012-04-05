<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Группы товаров</h2>

<c:forEach items="${groupList}" var="group">
	<h3>${group.key}</h3>
	<table class="bordertable">
		<thead>
			<tr>
				<th style="width: 20%;">ОКП</th>
				<th style="width: 50%;">Название</th>
				<th style="width: 30%;">Действия</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${group.products}" var="product">
				<tr>
					<td onclick="location.href='${product.NCP}'">${product.NCP}</td>
					<td>${product.name}</td>
					<td><a href="/products/delete/${product.NCP}"
						class="ym-button ym-delete">Удалить</a><a
						href="/products/edit/${product.NCP}" class="ym-button ym-edit">Изменить</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:forEach>
<a href="add" class="ym-button ym-add">Добавить</a>