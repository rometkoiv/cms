<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:if test="${not empty CommDevAndType}">

	<form:form modelAttribute="CommDevAndType" action="#">
		<form:hidden path="commDevice" />
		<form:hidden path="orderb" />
		<table>
		
			<tr>
				<td>Tüüp</td>
				<td>
				 <c:if test="${not empty typeList}">
				<form:select path="commDeviceType" items="${typeList}"	multiple="false"></form:select>
				</c:if>
				</td>
				<td><span class = "spanError" id="commDeviceTypeErrors"></span></td>
			</tr>
			<tr>
				<td>Kontakt</td>
				<td><form:input path="valueText" /></td>
				<td><span class = "spanError" id="valueTextErrors"></span></td>
			</tr>
			
			<tr>
				<td></td>
				<td colspan="2"><input type="submit" value="Salvesta" onclick="javascript:postForm('CommDevAndType');"/></td>
			</tr>
			
		</table>
		
	</form:form>

	<div id = "content"><div id = "result"></div></div>

</c:if>
