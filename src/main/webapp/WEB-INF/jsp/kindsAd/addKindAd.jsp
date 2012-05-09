<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<% 
	String action;
	String name;
	if (pageContext.findAttribute("add").equals(new Boolean(true))){
		action = "Добавить";
		name = "Добавление";
	}else{
		action = "Изменить";
		name = "Изменение";
	}
%>

<h2><%=name%> типа рекламы</h2>

<form:form method="post" action="/kindsAd/" commandName="kindAd" class="ym-form ">

	<form:hidden path="key"/>

	<div class="ym-fbox-text">
		<form:label path="name">Название<sup
				class="ym-required" title="Это поле обязательно.">*</sup>
		</form:label>
		<form:input path="name" size="10" />
	</div>
	
	<div class="ym-fbox-button">
		<input type="submit" class="save" value="<%=action%>" /> <a href="/kindsAd"class="ym-button">Отмена</a>
	</div>
	
	
</form:form>