<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/styleheet.css" type="text/css"/>
<title>CMS::CommDeviceType</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/topMenu.jsp"/>

		<h2>Sidevahendite tüüpide haldus</h2>
		
			<c:if test="${not empty commdevicetypeList}">
			<table class = "listResults">
			<c:forEach var="cmm" items="${commdevicetypeList}">
			 <tr>
			 <td>${cmm.commDeviceType}</td>
			 <td>${cmm.name}</td>
			 <td>${cmm.description}</td>
			 <td><a href = "?id=${cmm.commDeviceType}">Muuda</a> </td>
			 <td><a href = "?deleteID=${cmm.commDeviceType}">Kustuta</a> </td>
			</tr>
			</c:forEach>
			 <tr>
			 <td></td>
			 <td></td>
			 <td></td>
			 <td></td>
			 <td><a href = "?new">Lisa Uus</a> </td>
			</tr>
			</table>
            </c:if>
            <c:if test="${not empty commdevicetype}">
                   
            <form:form modelAttribute="commdevicetype" >
              <form:hidden path="commDeviceType"/>
              <table>
           <tr>
			<td>Nimi</td>
            <td><form:input path="name" /></td>
			<td><form:errors path="name" /></td>
           </tr>  
           
           <tr>
			<td>Kirjeldus</td>
            <td><form:input path="description" /></td>
			<td><form:errors path="description" /></td>
           </tr>  
           <tr>
			<td></td>
            <td colspan ="2"><input type="submit" value = "Salvesta"/></td>
			 </tr> 	 	
		    </table>       
			</form:form>
		</c:if>
		<c:if test="${empty commdevicetypeList}"><a href = "?new">Lisa Uus</a></c:if>
	
</body>
</html>