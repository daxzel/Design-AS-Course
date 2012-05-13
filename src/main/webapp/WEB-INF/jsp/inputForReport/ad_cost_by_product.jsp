<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Ввод параметров запроса</h2>

<form:form method="post" action="/reports/ad_cost_by_product/get/" class="ym-form " commandName="commandObjectForAdCosts">

    <div class="ym-fbox-select">
            	<form:label path="product">Продукт</sup>
            	</form:label>
            	<form:select path="product">
            		<form:options items="${productList}" itemLabel="name" />
                </form:select>
     </div>

       <div class="ym-fbox-text">
                         		<form:label path="dateBegin">Дата начала<sup
                         				class="ym-required" title="Это поле обязательно.">*</sup>
                         		</form:label>
                         		<form:input path="dateBegin" size="10" />
                 </div>

         <div class="ym-fbox-text">
                                		<form:label path="dateEnd">Дата окончания<sup
                                				class="ym-required" title="Это поле обязательно.">*</sup>
                                		</form:label>
                                		<form:input path="dateEnd" size="10" />
                        </div>



	<div class="ym-fbox-button">
		<input type="submit" class="save" value="send" /> <a href="/"class="ym-button">Отмена</a>
	</div>

</form:form>