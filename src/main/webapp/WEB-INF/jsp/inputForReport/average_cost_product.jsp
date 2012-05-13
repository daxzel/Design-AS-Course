<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Выбор продукта</h2>

<form:form method="post" action="/reports/ad_cost_by_product/get/" class="ym-form " commandName="productHelper">

    <div class="ym-fbox-select">
            	<form:label path="product"></sup>
            	</form:label>
            	<form:select path="product">
            		<form:options items="${productList}" itemLabel="name" />
                </form:select>
     </div>

	<div class="ym-fbox-button">
		<input type="submit" class="save" value="Показать" /> <a href="/"class="ym-button">Отмена</a>
	</div>

</form:form>