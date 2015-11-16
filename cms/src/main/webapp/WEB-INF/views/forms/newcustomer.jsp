<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:if test="${not empty Customer}">
   <h4>Uue klient</h4>
	<form:form modelAttribute="Customer"  name="NewCustomer" id="NewCustomer" action="#">
		<form:hidden path="customer" />
		<table>
			<tr>
				<td>Eesnimi</td>
				<td><form:input path="firstName" /></td>
				<td><span class = "spanError" id="firstNameErrors"></span></td>
			</tr>
			<tr>
				<td>Perenimi</td>
				<td><form:input path="lastName" /></td>
				<td><span class = "spanError" id="lastNameErrors"></span></td>
			</tr>
			<tr>
				<td>Isikukood</td>
				<td><form:input path="identityCode" /></td>
				<td><span class = "spanError" id="identityCodeErrors"></span></td>
			</tr>
			<tr>
				<td>Sünni aeg</td>
				<td><form:input path="birthDate" /></td>
				<td><span class = "spanError" id="birthDateErrors"></span></td>
			</tr>
			<tr>
				<td>Märkused</td>
				<td><form:input path="note" /></td>
				<td><span class = "spanError" id="noteErrors"></span></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><div id="CustomerSubmit"><input type="submit" value="Salvesta" onclick="javascript:postForm('NewCustomer');"/></div></td>
			</tr>
			
		</table>
		
	</form:form>

	<div id = "content"><div id = "result"></div></div>

</c:if>
