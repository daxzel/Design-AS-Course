<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Общие затраты</h2>

<table class="bordertable table_pie">
	<thead>
		<tr>
            <th>На рекламу</th>
            <th>На производство</th>
            <th>На хранение</th>
            <th>На транспортировку</th>
            <th>Другие</th>

		</tr>
	</thead>
	<tbody>
        <tr>
		    <td>${result.adCost}</td>
			<td>${result.costsProduction}</td>
			<td>${result.storageCost}</td>
			<td>${result.transportationCosts}</td>
			<td>${result.otherCost}</td>
		</tr>
	</tbody>
</table>
