<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/styleheet.css" type="text/css"/>
<title>CMS::CGroup</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/topMenu.jsp"/>

		<h2>Gruppide haldus</h2>
		
			<c:if test="${not empty groupList}">
			<table>
			<c:forEach var="gr" items="${groupList}">
			 <tr>
			 <td>${gr.CGroup}</td>
			 <td>${gr.name}</td>
			 <td>${gr.description}</td>
			 <td>${gr.created} </td>
			 <td>${gr.updated} </td>
			 <td><a href = "?id=${gr.CGroup}">edit</a> </td>
			 <td><a href = "?deleteID=${gr.CGroup}">Remove</a> </td>
			</tr>
			</c:forEach>
			 <tr>
			 <td></td>
			 <td></td>
			 <td></td>
			 <td></td>
			 <td></td>
			 <td></td>
			 <td><a href = "?new">Lisa Uus</a> </td>
			</tr>
			</table>
            </c:if>
            <c:if test="${not empty group}">
                   
            <form:form modelAttribute="group" >
              <form:hidden path="cGroup"/>
              <table>
           <tr>
			<td>Grupi Nimi</td>
            <td><form:input path="name" /></td>
			<td><form:errors path="name" /></td>
           </tr>  
           
           <tr>
			<td>Grupi kirjeldus</td>
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
		<c:if test="${empty groupList}"><a href = "?new">Lisa Uus</a></c:if>
	
</body>
</html>