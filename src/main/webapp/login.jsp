<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/resources/base.min.css" rel="stylesheet" type="text/css">
   	<link href="/resources/gray-theme.css" rel="stylesheet" type="text/css">
   	<link href="/resources/vlist.css" rel="stylesheet" type="text/css">
   	<link href="/resources/hlist.css" rel="stylesheet" type="text/css">
   	<link href="/resources/print.css" rel="stylesheet" type="text/css">
   	<link href="/resources/typography.css" rel="stylesheet" type="text/css">
   	<link href="/resources/tabs.css" rel="stylesheet" type="text/css">
   	<link href="/resources/screen-PAGE-layout.css" rel="stylesheet" type="text/css">
   	<script src="/resources/js/jquery-1.7.1.min.js" type="text/javascript"></script>
   	<script src="/resources/js/jquery.tabs.js" type="text/javascript"></script>
   	<script src="/resources/js/yaml-focusfix.js" type="text/javascript"></script>
   	<script src="/resources/js/application.js" type="text/javascript"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
</head>
<body>

<c:if test="${not empty param.error}">
	<font color="red"> Ошибка авторизации
	: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>

<form method="POST" class="ym-form" style="width:500px; position:relative; top:100px; left:400px;" action="<c:url value="/j_spring_security_check" />">

     <div class="ym-fbox-text">
         <label for="j_username">Имя пользователя</label>

        <input type="text" name="j_username" />
     </div>

     <div class="ym-fbox-text">
        <label for="j_password">Пароль</label>
        <input type="password" name="j_password" />
     </div>

    <div class="ym-fbox-button">
    		<input type="submit" class="save" value="Принять" />
    </div>

</form>
</body>
</html>