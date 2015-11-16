<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/styleheet.css" type="text/css"/>
<title>CMS:Login Page</title>

</head>
<body onload='document.loginForm.username.focus();'>

	<div id="login-box">
 
		<h2>120437-CMS, by romet</h2>
		<h2>Logi süsteemi</h2>
 
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
 
		<form name='loginForm'
		  action="${pageContext.request.contextPath}/login" method='POST'>
 
		<table>
			<tr>
				<td>Kasutaja:</td>
				<td><input type='text' name='username'></td>
			</tr>
			<tr>
				<td>Parool:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
			    <td>&nbsp;</td>
				<td align="right"><input name="submit" type="submit" value="Sisene" /></td>
			</tr>
		  </table>
 
		  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
 
		</form>
	</div>
	<c:if test="${not empty availableUsers}">
    <div  id="login-box-users">
      Kasutada saab:
       <table>
        <tr>
				<th>Kasutajanimi</th>
				<th>Parool</th>
			</tr>
       <c:forEach var="au" items="${availableUsers}">
           <tr>
				<td> ${au.username}</td>
				<td>${au.passw} </td>
			</tr>
        
       </c:forEach>
       </table>
      
    </div>
     </c:if>
</body>
</html>