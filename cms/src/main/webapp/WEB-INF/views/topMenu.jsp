<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<DIV><c:if test="${not empty loggedIn}"> Sisse loginud:  ${loggedIn.firstName}  ${loggedIn.lastName} - <a href = "${pageContext.request.contextPath}/empUser?userName=${loggedIn.username}">Muuda kontot</a> | <a href="${pageContext.request.contextPath}/loginPage?logout">Logi välja</a> | <a href="${pageContext.request.contextPath}">Esileht</a>  | <a href="${pageContext.request.contextPath}/Search">Kliendi Otsing</a> | <a href="${pageContext.request.contextPath}/log">Log</a></c:if></DIV>

<c:if test="${not empty error}"><DIV class="error"> Viga: ${error}</DIV></c:if>
<c:if test="${not empty info}"><DIV class="info">  ${info}</DIV></c:if>

