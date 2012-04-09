<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

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
	<link href="/resources/screen-PAGE-layout.css" rel="stylesheet" type="text/css">
	<script src="/resources/js/jquery-1.7.1.min.js" type="text/javascript"></script>
	<script src="/resources/js/jquery.tabs.js" type="text/javascript"></script>
	<script src="/resources/js/yaml-focusfix.js" type="text/javascript"></script>
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
					<li><a href="/users/">Пользователи</a></li>
					<li><a href="/products/">Товары</a></li>
					<li><a href="/kindsAd/">Типы реклам</a></li>
					<li><a href="/organizations/">Организации</a></li>
					<li><a href="/roles/create">Заполнить роли</a></li>
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