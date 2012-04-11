<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
%>                                                    A


<h2><%=name%> организации</h2>

<form:form method="post" action="/organizations/" commandName="organization" class="ym-form ">

	<form:hidden path="key"/>

	<div class="ym-fbox-text">
		<form:label path="name">
		    Название фирмы
		    <sup class="ym-required" title="Это поле обязательно.">*</sup>
		</form:label>
		<form:input path="name" size="10" />
	</div>

    <div class="ym-fbox-text">
    		<form:label path="address">Адрес фирмы
    		<sup class="ym-required" title="Это поле обязательно.">*</sup>
    		</form:label>
    		<form:textarea path="address" rows="3" cols="20"  />
    	</div>


	<div class="ym-fbox-text">
		<form:label path="fioOfDirector">
		    ФИО директора
		    <sup class="ym-required" title="Это поле обязательно.">*</sup>
		</form:label>
		<form:input path="fioOfDirector" size="10" />
	</div>

		<div class="ym-fbox-text">
    		<form:label path="telephoneOfDirector">
    		    Телефон директора
    		    <sup class="ym-required" title="Это поле обязательно.">*</sup>
    		</form:label>
    		<form:input path="telephoneOfDirector" size="10" />
    	</div>

    	<div class="ym-fbox-text">
    		<form:label path="telephoneOfMarketing">
    		    Телефон службы сбыта
    		    <sup class="ym-required" title="Это поле обязательно.">*</sup>
    		</form:label>
    		<form:input path="telephoneOfMarketing" size="10" />
    	</div>

	<div class="ym-fbox-button">
		<input type="submit" class="save" value="<%=action%>" /> <a href="/users"class="ym-button">Отмена</a>
	</div>
</form:form>