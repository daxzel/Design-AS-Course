<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Динамика изменения продаж и затрат на рекламу</h2>

<table class="bordertable">

    <hr>
    <h3>Динамика изменения продаж</h2>

    <table class="bordertable table_line">
        <thead>
            <tr>
                <c:forEach items="${result.result}" var="monthsAmountsMargins">
                                    <th>${monthsAmountsMargins.month}</th>
                </c:forEach>
            </tr>
        </thead>

        <tbody>
                <tr>
                    <c:forEach items="${result.result}" var="monthsAmountsMargins">
                        <td>${monthsAmountsMargins.amount}</td>
                    </c:forEach>
                </tr>
        </tbody>
	</table>


    <hr>
    <h3>Динамика изменения прибыли</h2>

<table class="bordertable table_line">
    <thead>
		<tr>
		    <c:forEach items="${result.result}" var="monthsAmountsMargins">
            				    <th>${monthsAmountsMargins.month}</th>
            </c:forEach>
		</tr>
	</thead>

	<tbody>
			<tr>
				<c:forEach items="${result.result}" var="monthsAmountsMargins">
				    <td>${monthsAmountsMargins.margin}</td>
				</c:forEach>
			</tr>
	</tbody>
</table>


    <hr>
    <h3>Динамика изменения затрат на рекламу</h2>

<table class="bordertable table_line">
    <thead>
		<tr>
		    <c:forEach items="${result.result}" var="monthsAmountsMargins">
            				    <th>${monthsAmountsMargins.month}</th>
            </c:forEach>
		</tr>
	</thead>

	<tbody>
			<tr>
				<c:forEach items="${result.result}" var="monthsAmountsMargins">
				    <td>${monthsAmountsMargins.adCost}</td>
				</c:forEach>
			</tr>
	</tbody>
</table>
