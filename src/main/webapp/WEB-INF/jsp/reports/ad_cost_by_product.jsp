<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Доли затрат</h2>

<h3>По организациям</h2>

<table class="bordertable table_pie">
	<thead>
		<tr>
		    <c:forEach items="${result.organizationAndShareCostList}" var="organizationAndShareCost">
                <th>${organizationAndShareCost.organization.name}</th>
            </c:forEach>

		</tr>
	</thead>
	<tbody>

				<tr>
				    <c:forEach items="${result.organizationAndShareCostList}" var="organizationAndShareCost">
				         <td>${organizationAndShareCost.shareCost}</td>
				    </c:forEach>
				</tr>

	</tbody>
</table>

<h3>По типам реклам</h2>

<table class="bordertable table_pie">
    <thead>
    		<tr>
    		    <c:forEach items="${result.kindAdAndShareCostList}" var="kindAdAndShareCost">
                    <th>${organizationAndShareCost.kindAd.name}</th>
                </c:forEach>

    		</tr>
    	</thead>
    	<tbody>

    				<tr>
    				    <c:forEach items="${result.kindAdAndShareCostList}" var="kindAdAndShareCost">
    				         <td>${organizationAndShareCost.shareCost}</td>
    				    </c:forEach>
    				</tr>

    	</tbody>
    </table>
</table>


