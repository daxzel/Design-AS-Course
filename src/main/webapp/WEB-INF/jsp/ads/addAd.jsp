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

<h2><%=name%> рекламы</h2>

<form:form method="post" action="/ads/" commandName="ad" class="ym-form ">

	<form:hidden path="key"/>

	<div class="ym-fbox-text">
		<form:label path="paymentMethod">Способ оплаты<sup
				class="ym-required" title="Это поле обязательно.">*</sup>
		</form:label>
		<form:input path="paymentMethod" size="10" />
	</div>

	<div class="ym-fbox-text">
    	<form:label path="amount">Сумма оплаты<sup
    			class="ym-required" title="Это поле обязательно.">*</sup>
    	</form:label>
        <form:input path="amount" size="10" />
    </div>

    <div class="ym-fbox-select">
    	<form:label path="kindAd"></sup>
    	</form:label>
    	<form:select path="kindAd">
    		<form:options items="${kindAdList}" itemLabel="name" />
        </form:select>
    </div>

    <div class="ym-fbox-select">
        	<form:label path="product"></sup>
        	</form:label>
        	<form:select path="product">
        		<form:options items="${productList}" itemLabel="name" />
            </form:select>
    </div>

	<div class="ym-fbox-button">
		<input type="submit" class="save" value="<%=action%>" /> <a href="/ads"class="ym-button">Отмена</a>
	</div>


</form:form>