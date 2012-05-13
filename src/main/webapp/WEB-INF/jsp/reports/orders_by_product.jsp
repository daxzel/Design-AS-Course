<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Производства</h2>

<table class="bordertable">
	<thead>
		<tr>
		     <th style="width: 100%;">Номер заказа</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${orderList}" var="order">
				<tr>
				        <td onclick="location.href=''">${order.key}</td>
				</tr>
		</c:forEach>
	</tbody>
</table>
