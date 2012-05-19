<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Динамика изменения затрат и цен</h2>

<table class="bordertable">

    <hr>
    <h3>Динамика изменения затрат</h2>

    <table class="bordertable table_line">
        <thead>
            <tr>
                <c:forEach items="${result.monthCostPriceList}" var="monthCostPrice">
                                    <th>${monthCostPrice.month}</th>
                </c:forEach>
            </tr>
        </thead>

        <tbody>
                <tr>
                    <c:forEach items="${result.monthCostPriceList}" var="monthCostPrice">
                        <td>${monthCostPrice.cost}</td>
                    </c:forEach>
                </tr>
        </tbody>
	</table>


	<hr>
        <h3>Динамика изменения цены</h2>

        <table class="bordertable table_line">
            <thead>
                <tr>
                    <c:forEach items="${result.monthCostPriceList}" var="monthCostPrice">
                                        <th>${monthCostPrice.month}</th>
                    </c:forEach>
                </tr>
            </thead>

            <tbody>
                    <tr>
                        <c:forEach items="${result.monthCostPriceList}" var="monthCostPrice">
                            <td>${monthCostPrice.price}</td>
                        </c:forEach>
                    </tr>
            </tbody>
    	</table>

