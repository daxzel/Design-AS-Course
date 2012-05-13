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

<h2><%=name%> продажи</h2>

<form:form method="post" action="/sales/" commandName="sale" class="ym-form ">

	<form:hidden path="key"/>

	<div class="ym-fbox-text">
		<form:label path="transportationCosts">Транспортные затраты<sup
				class="ym-required" title="Это поле обязательно.">*</sup>
		</form:label>
		<form:input path="transportationCosts" size="10" />
	</div>

	<div class="ym-fbox-text">
    		<form:label path="otherCosts">Другие затраты<sup
    				class="ym-required" title="Это поле обязательно.">*</sup>
    		</form:label>
    		<form:input path="otherCosts" size="10" />
    </div>

    <div class="ym-fbox-text">
        		<form:label path="idShop">Код точки продажи<sup
        				class="ym-required" title="Это поле обязательно.">*</sup>
        		</form:label>
        		<form:input path="idShop" size="10" />
    </div>

     <div class="ym-fbox-text">
                		<form:label path="dateBegin">Дата заказа<sup
                				class="ym-required" title="Это поле обязательно.">*</sup>
                		</form:label>
                		<form:input path="dateBegin" size="10" />
        </div>

    <div class="ym-fbox-text">
            		<form:label path="amount">Сумма<sup
            				class="ym-required" title="Это поле обязательно.">*</sup>
            		</form:label>
            		<form:input path="amount" size="10" />
    </div>

    <div class="ym-fbox-select">
            	<form:label path="production"></sup>
            	</form:label>
            	<form:select path="production">
            		<form:options items="${productionList}" itemLabel="key" />
                </form:select>
    </div>

    <div class="ym-fbox-select">
               	<form:label path="organization"></sup>
               	</form:label>
               	<form:select path="organization">
               		<form:options items="${organizationList}" itemLabel="name" />
                </form:select>
    </div>




	<div class="ym-fbox-button">
		<input type="submit" class="save" value="<%=action%>" /> <a href="/sales"class="ym-button">Отмена</a>
	</div>


</form:form>