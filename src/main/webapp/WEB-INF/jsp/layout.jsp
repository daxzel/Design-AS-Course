<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
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
	<link href="/resources/visualize.css" rel="stylesheet" type="text/css">
	<link href="/resources/visualize-light.css" rel="stylesheet" type="text/css">
	<link href="/resources/screen-PAGE-layout.css" rel="stylesheet" type="text/css">
	<script src="/resources/js/jquery-1.7.1.min.js" type="text/javascript"></script>
	<script src="/resources/js/jquery.tabs.js" type="text/javascript"></script>
	<script src="/resources/js/yaml-focusfix.js" type="text/javascript"></script>
	<script src="/resources/js/visualize.js" type="text/javascript"></script>
	<script src="/resources/js/application.js" type="text/javascript"></script>
	<script src="" type="text/javascript"></script>
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<div class="ym-wrapper">
	<div class="ym-wbox">
	
	    <header>
			<tiles:insertAttribute name="header" />
		</header>
	    
	    <nav id="nav">
			<div class="ym-hlist" >
				<ul>

                    <li><a href="/">Главная</a></li>
                      <sec:authorize access="hasRole('ROLE_ADMIN')">


                                          <li><a href="/users/">Пользователи</a></li>
                                          <li><a href="/products/">Товары</a></li>
                                          <li><a href="/kindsAd/">Типы реклам</a></li>
                                          <li><a href="/organizations/">Организации</a></li>

                                        </sec:authorize>


                                        <sec:authorize access="hasRole('ROLE_MANAGER')">

                                            <li><a href="/ads/">Рекламы</a></li>
                                            <li><a href="/sales/">Продажи</a></li>
                                            <li><a href="/orders/">Заказы</a></li>
                                            <li><a href="/production/">Производство</a></li>

                                        </sec:authorize>

                                        <sec:authorize access="hasRole('ROLE_ECONOMIST')">

                                            <li><a href="/reports/orders_by_product/">Отчёт по заказам на товар</a></li>
                                            <li><a href="/reports/dynamics_changes_sales/">Динамика изменения продаж</a></li>

                                        </sec:authorize>

                                        <sec:authorize access="hasRole('ROLE_ACCOUNTANT')">

                                            <li><a href="/reports/ad_cost_by_product/">Отчёт по затратам на рекламу</a></li>
                                            <li><a href="/reports/average_cost_product/">Определение средних затрат по товару</a></li>

                                        </sec:authorize>

                                        <sec:authorize access="hasRole('ROLE_DIRECTOR')">
                                            <li><a href="/reports/report_dynamics_costs/">Отчёт по динамике изменения фактических затрат</a></li>
                                        </sec:authorize>


					<li><a href="/j_spring_security_logout">Выход</a></li>
				</ul>
			</div>
		</nav>
	    <div class="ym-cbox">
			<section class="box info">
				<tiles:insertAttribute name="body" />
			</section>
	    </div>

	    <footer>
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</div>
	
</body>
</html>