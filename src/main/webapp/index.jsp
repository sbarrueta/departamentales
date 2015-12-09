<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.tresct.departamentales.hibernate.entities.PersonaCorreos"%>
<%@ page import="com.tresct.departamentales.dao.PersonaCorreosDAO"%>

<%@ page import="com.tresct.departamentales.hibernate.entities.Persona"%>
<%@ page import="com.tresct.departamentales.dao.PersonaDAO"%>
<%@ page import="com.tresct.departamentales.dao.impl.PersonaDAOImpl"%>

<%@ page import="com.tresct.departamentales.bo.PersonaBO"%>


<%@ page
	import="com.tresct.departamentales.dao.impl.PersonaCorreosDAOImpl"%>
<%@ page import="org.springframework.context.ApplicationContext"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body ng-app ng-init="nombre='Jorge'">

	<h1>Hello {{nombre}}</h1>



	<%
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		PersonaBO personaBO = (PersonaBO) context.getBean("personaBO");
//		PersonaDAO personaDAO = (PersonaDAO) context.getBean("personaDAO");
//		PersonaCorreosDAO personaCorreosDAO = (PersonaCorreosDAO) context.getBean("personaCorreosDAO");
		//System.out.println("Hola el correo es : " + personaCorreosDAO.damePersonaCorreos(3).getCorreo());
	//	PersonaDAO personaDAO = new PersonaDAOImpl();
		System.out.println("<<<<<<<<<<<<<<<< Antes de invocar al metodo");
		System.out.println("Hola el nombre es : " + personaBO.damePersonaJSON(-410));
		
		/*
		for (PersonaCorreos item : personaDAO.damePersona(410).getCorreos()){
			System.out.println(  item.getCorreo());
		}*/
	%>
</body>
</html>
