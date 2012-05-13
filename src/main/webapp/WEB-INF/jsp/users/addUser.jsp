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


<h2><%=name%> пользователя</h2>

<form:form method="post" action="/users/" commandName="user" class="ym-form ">

    <form:errors path="*" cssClass="box error" element="div" />

	<form:hidden path="key"/>

	<div class="ym-fbox-text">
		<form:label path="name">Имя пользователя<sup
				class="ym-required" title="Это поле обязательно.">*</sup>
		</form:label>
		<form:input path="name" size="10" />
	</div>
	<div class="ym-fbox-text">
		<form:label path="password">Пароль пользователя<sup
				class="ym-required" title="Это поле обязательно.">*</sup>
		</form:label>
		<form:password path="password" size="10" />
	</div>

	<div class="ym-fbox-select">
		<form:label path="role"></sup>
		</form:label> 
		<form:select path="role">
			<form:options items="${roleList}" itemLabel="name" />
		</form:select>
	</div>

	<div class="ym-fbox-button">
		<input type="submit" class="save" value="<%=action%>" /> <a href="/users"class="ym-button">Отмена</a>
	</div>
</form:form>