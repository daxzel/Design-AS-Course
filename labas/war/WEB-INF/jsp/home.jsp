<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Scans the classpath of this application for @Components to deploy as beans -->
<!-- 	<context:component-scan base-package="daxzel" /> -->

	<!-- Configures the @Controller programming model -->
<!-- 	<mvc:annotation-driven /> -->

	<!-- Forwards requests to the "/" resource to the "welcome" view -->
<!-- 	<mvc:view-controller path="/" view-name="welcome"/> -->

	<!-- Configures Handler Interceptors -->
<!-- 	<mvc:interceptors> -->
	<!-- Changes the locale when a 'locale' request parameter is sent; e.g. /?locale=de --> 
<!-- 		<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor" /> -->
<!-- 	</mvc:interceptors> -->

	<!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources/ directory --> -->
<!-- 	<mvc:resources mapping="/resources/**" location="/resources/" /> -->

 	<!-- Saves a locale change using a cookie -->
<!-- 	<bean id="localeResolver" class="org.springframework.web.servlet.i18n.CookieLocaleResolver" /> -->

 	<!-- Application Message Bundle -->
<!-- 	<bean id="messageSource" class="org.springframework.context.support.ReloadableResourceBundleMessageSource"> -->
<!-- 		<property name="basename" value="/WEB-INF/messages/messages" /> -->
<!-- 		<property name="cacheSeconds" value="0" /> -->
<!-- 	</bean> -->

 	<!-- Resolves view names to protected .jsp resources within the /WEB-INF/views directory -->
<!-- 	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"> -->
<!-- 		<property name="prefix" value="/WEB-INF/views/"/> -->
<!-- 		<property name="suffix" value=".jsp"/> -->
<!-- 	</bean> -->

    ${message}
</body>
</html>