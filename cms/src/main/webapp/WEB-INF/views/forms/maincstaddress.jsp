<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:if test="${not empty CstAddress}">

	<form:form modelAttribute="CstAddress" name="CstAddressOnMain" id="CstAddressOnMain" action="#">
		<form:hidden path="cstAddress" />
		<table>
		    <tr>
				<td colspan="2">Kliendi peamine aadress</td>
				
				<td width="200px"><span class = "spanError" id="addressTypeErrors"></span></td>
				<td rowspan="8" valign="top">Lõikelaud <input type="submit" value="Kopeeri" onclick="javascript:postForm('ClipboardOnMain');" />	
				<div id="ClipboardOnMain"></div></td>
			</tr>
			<tr>
				<td>Aadress</td>
				<td><form:input path="address"/></td>
				<td><span class = "spanError" id="addressErrors"></span></td>
				
			</tr>
			<tr>
				<td>Maja</td>
				<td><form:input path="house" /></td>
				<td><span class = "spanError" id="houseErrors"></span></td>
			</tr>
			<tr>
				<td>Linn/Küla</td>
				<td><form:input path="townCounty" /></td>
				<td><span class = "spanError" id="townCountyErrors"></span></td>
			</tr>
			<tr>
				<td>Maakond</td>
				<td><form:input path="county" /></td>
				<td><span class = "spanError" id="countyErrors"></span></td>
			</tr>

			<tr>
				<td>Indeks</td>
				<td><form:input path="zip" /></td>
				<td><span class = "spanError" id="zipErrors"></span></td>
			</tr>
			<tr>
				<td>Märkused</td>
				<td><form:input path="note" /></td>
				<td><span class = "spanError" id="noteErrors"></span></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"></td>
				
			</tr>
		</table>
	</form:form>
</c:if>


