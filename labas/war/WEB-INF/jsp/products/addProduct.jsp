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


<h2><%=name%> продукта</h2>

<form:form method="post" action="/products/" commandName="product" class="ym-form ">

	<form:hidden path="key"/>
	
	<form:hidden path="group"/>

	<div class="ym-fbox-text">
		<form:label path="NCP">код ОКП<sup
				class="ym-required" title="Это поле обязательно.">*</sup>
		</form:label>
		<form:input path="NCP" size="10" />
	</div>
	
	<div class="ym-fbox-text">
		<form:label path="name">Название товара<sup
				class="ym-required" title="Это поле обязательно.">*</sup>
		</form:label>
		<form:input path="name" size="10" />
	</div>
	
	<div class="ym-fbox-text">
		<form:label path="size">Размер товара
		</form:label>
		<form:input path="size" size="10" />
	</div>
	
	<div class="ym-fbox-text">
		<form:label path="developer">Изготовитель</sup>
		</form:label>
		<form:input path="developer" size="10" />
	</div>
	
	<div class="ym-fbox-text">
		<form:label path="manufacturer">Разработчик</sup>
		</form:label>
		<form:input path="manufacturer" size="10" />
	</div>
	
	<div class="ym-fbox-text">
		<form:label path="features">Характеристики</sup>
		</form:label>
		<form:textarea path="features" rows="3" cols="20"  />
	</div>

	<div class="ym-fbox-button">
		<input type="submit" class="save" value="<%=action%>" /> <a href="/users"class="ym-button">Отмена</a>
	</div>
	
	
</form:form>