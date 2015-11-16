<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/styleheet.css" type="text/css"/>
<title>CMS:EmpUser</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/topMenu.jsp"/>

		<h2>Halda kasutajaid</h2>
		
			<c:if test="${not empty userWithNames}">
			<table>
			<c:forEach var="eu" items="${userWithNames}">
			 <tr>
			 <td>${eu.empUser}</td>
			 <td>${eu.firstName}</td>
			 <td>${eu.lastName}</td>
			 <td>${eu.username}</td>
			 <td>${eu.passw} </td>
			 <td>${eu.email} </td>
			 <td><a href = "${pageContext.request.contextPath}/empUser?userName=${eu.username}">edit</a> </td>
			 <td><a href = "${pageContext.request.contextPath}/empUser?DeleteUserName=${eu.username}">Remove</a> </td>
			</tr>
			</c:forEach>
			 <tr>
			 <td></td>
			 <td></td>
			 <td></td>
			  <td></td>
			 <td></td>
			 <td></td>
			 <td></td>
			 <td><a href = "${pageContext.request.contextPath}/empUser?new">Lisa uus</a> </td>
			</tr>
			</table>
            </c:if>
            <c:if test="${not empty userWithName}">
                   
            <form:form modelAttribute="userWithName" >
              <form:hidden path="empUser"/>
              <form:hidden path="employee"/>
              <table>
           <tr>
			<td>Eesnimi</td>
            <td><form:input path="firstName" /></td>
			<td><form:errors path="firstName" /></td>
           </tr>  
           
           <tr>
			<td>Perenimi</td>
            <td><form:input path="lastName" /></td>
			<td><form:errors path="lastName" /></td>
           </tr>  
            <tr>
			<td>username:</td>
            <td><form:input path="username" /></td>
			<td><form:errors path="username" /></td>
           </tr>  
            <tr>
			<td>password</td>
            <td><form:input path="passw" /></td>
			<td><form:errors path="passw" /></td>
           </tr> 	
            <tr>
			<td>e-mail</td>
            <td><form:input path="email" /></td>
			<td><form:errors path="email" /></td>
           </tr>
          	
            <tr>
			<td></td>
            <td colspan ="2"><input type="submit" value = "Salvesta"/></td>
			 </tr> 	 	
		    </table>       
			</form:form>
		</c:if>
		
	
</body>
</html>