<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h2>Добавление нового пользователя</h2>

<form:form method="post" action="" commandName="user" class="ym-form ">

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
		<input type="submit" class="save" value="Добавить" /> <a href="./"
			class="ym-button">Отмена</a>
	</div>
</form:form>