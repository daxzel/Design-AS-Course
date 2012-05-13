<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Доли затрат</h2>

<h3>По организациям</h2>

<table class="bordertable">
	<thead>
		<tr>
		    <th style="width: 80%;">Название</th>
		    <th style="width: 20%;">Доля</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach items="${result.organizationAndShareCostList}" var="organizationAndShareCost">
				<tr>
				    <td>${organizationAndShareCost.organization.name}</td>
				    <td>${organizationAndShareCost.shareCost}%</td>
				</tr>
		</c:forEach>
	</tbody>
</table>

<h3>По типам реклам</h2>

<table class="bordertable">
	<thead>
		<tr>
		    <th style="width: 80%;">Название</th>
		    <th style="width: 20%;">Доля</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach items="${result.kindAdAndShareCostList}" var="kindAdAndShareCost">
				<tr>
				    <td>${kindAdAndShareCost.kindAd.name}</td>
				    <td>${kindAdAndShareCost.shareCost}%</td>
				</tr>
		</c:forEach>
	</tbody>
</table>


