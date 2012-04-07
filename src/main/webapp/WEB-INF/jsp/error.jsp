<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h2>Ошибка</h2>
<c:if test="${not empty exception}">
	<h3>Ошибка <c:out value="${exception}" /></h3>
</c:if>
<c:if test="${not empty statusCode}">
	<h3>Номер ошибки <c:out value="${statusCode}" /></h3>
</c:if>