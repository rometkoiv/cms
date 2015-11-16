<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/styleheet.css"
	type="text/css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/styleheet.css"
	type="text/css" />
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<title>CMS::Otsing</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/topMenu.jsp" />
    <div class="searchMenu">
		<div class="searchMenu" id="searchMenuLeft">
			<c:if test="${not empty searchClient}">
				<form:form modelAttribute="searchClient">
					<table id="searchForm">
						<tr>
							<td>
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
										<td>Sündinud</td>
										<td><form:input path="birthFrom" class="datepicker"
												readonly="false" /> - <form:input path="birthTo"
												class="datepicker" readonly="false" /></td>
										<td><form:errors path="birthFrom" />
											<form:errors path="birthTo" /></td>
									</tr>
									<tr>
										<td>Isikukood</td>
										<td><form:input path="identityCode" /></td>
										<td><form:errors path="identityCode" /></td>
									</tr>
									<tr>
										<td>Märkused</td>
										<td><form:input path="note" /></td>
										<td><form:errors path="note" /></td>
									</tr>
									<tr>
										<td colspan="3"></td>
									</tr>
									<tr>
										<td>Aadress</td>
										<td><form:input path="address" /></td>
										<td><form:errors path="address" /></td>
									</tr>
									<tr>
										<td>Maja</td>
										<td><form:input path="house" /></td>
										<td><form:errors path="house" /></td>
									</tr>
									<tr>
										<td>Linn</td>
										<td><form:input path="townCounty" /></td>
										<td><form:errors path="townCounty" /></td>
									</tr>
									<tr>
										<td>Maakond</td>
										<td><form:input path="county" /></td>
										<td><form:errors path="county" /></td>
									</tr>
								</table>

							</td>
							<td><h4>Kliendi otsing</h4>
								<table>
									<c:if test="${not empty distinctEmployees}">
										<tr>
											<td>Kelle poolt lisatud</td>
											<td><form:select path="createdBy"
													items="${distinctEmployees}" multiple="true"></form:select></td>
											<td><form:errors path="createdBy" /></td>
										</tr>
									</c:if>
										<tr>
											<td>Loodud</td>
											<td><form:input path="createdFrom" class="datepicker"  readonly="true"/> - <form:input path="createdTo"	class="datepicker"  readonly="true"/></td>
											<td><form:errors path="createdFrom" />
												<form:errors path="createdTo" /></td>
										</tr>
										<c:if test="${not empty distinctEmployees}">
										<tr>
											<td>Kelle poolt muudetud</td>
											<td><form:select path="updatedBy"
													items="${distinctEmployees}" multiple="true"></form:select></td>
											<td><form:errors path="updatedBy" /></td>
										</tr>
										</c:if>
										<tr>
											<td>Muudetud</td>
											<td><form:input path="updatedFrom" class="datepicker"
													readonly="true" /> - <form:input path="updatedTo"
													class="datepicker" readonly="true" /></td>
											<td><form:errors path="updatedFrom" />
												<form:errors path="updatedTo" /></td>
										</tr>
										
								</table>

							</td>
							<td>
							<table>
							<tr><td colspan = "3"><h4><a href="${pageContext.request.contextPath}/customerManager/0">Lisa uus klient</a></h4></td></tr>
							<tr><td colspan = "3">&nbsp;</td></tr>
							
							
							<c:if test="${not empty distinctGroups}">
										<tr>
											<td>Grupid</td>
											<td><form:select path="cgGroup"
													items="${distinctGroups}" multiple="true"></form:select></td>
											<td><form:errors path="cgGroup" /></td>
										</tr>
										</c:if>
							<tr>
										<td>Sidevahend</td>
										<td><form:input path="commDevName" /></td>
										<td><form:errors path="commDevName" /></td>
									</tr>
									<tr>
											<td>Täpsed otsingutulemused</td>
											<td><form:checkbox path="strict" /></td>
											<td><form:errors path="strict" /></td>
										</tr>
									<tr>
											<td>Logi SQL päring</td>
											<td><form:checkbox path="logsql" /></td>
											<td><form:errors path="logsql" /></td>
										</tr>
									
									<tr><td></td><td><input type="submit" value="Otsi" /></td><td></td></tr>
									<tr><td colspan = "3">&nbsp;</td></tr>
									<tr><td></td><td><input type="submit" name="reset" value="Alusta Uuesti"></td><td></td></tr>
									
							</table>
							</td>
							
							
						</tr>
						
						
					</table>


				</form:form>
			</c:if>
			
		</div>
		<div class="searchMenu" id="searchMenuRight">
			<b>Kasulik teada</b><br> Otsi nupule vajutamine salvestab
			parameetrid serveri mällu.<br> Lehele naastes on sama vaade.<br>
			Kuupäeva formaat dd.mm.yyyy<br> Täpne otsing kasutab =
			tingimust, tõusutundlik.<br> Tavaline otsing kasutab like
			%otsisõna%ning suur ja pole tõusutundlik. <br>
			<br>Kõiki parameetreid kasutatakse koos.<br>
			<br> Kui aadressi välju ei otsita, kuvatakse vaid peamine
			aadress.
		</div>
	</div>
	<div class="searchResults">
		<c:if test="${not empty searchList}">
			<table id="searchResults">
			<tr>
						<th><a href = "?orderby=firstName">Eesnimi</a></th>
						<th><a href = "?orderby=lastName">Perenimi</a></th>
						<th><a href = "?orderby=birthDate">Sündinud</a></th>
						<th><a href = "?orderby=identityCode">Isikukood</a></th>
						<th><a href = "?orderby=note">Märkused</a></th>
						<th><a href = "?orderby=created">Loodud</a></th>
						<th><a href = "?orderby=createdByName">Loonud</a></th>
						<th><a href = "?orderby=updated">Uuendatud</a></th>
						<th><a href = "?orderby=updatedByName">Uuendanud</a></th>
						<th><a href = "?orderby=cgName">Grupp</a></th>
						<th><a href = "?orderby=address">Aadress</a></th>
						<th><a href = "?orderby=house">Maja</a></th>
						<th><a href = "?orderby=townCounty">Linn</a></th>
						<th><a href = "?orderby=county">Maakond</a></th>
						<th><a href = "?orderby=zip">Indeks</a></th>
						<th><a href = "?orderby=commType">SV Tüüp</a></th>
						<th><a href = "?orderby=commDev">SV</a></th>
						<th></th>

					</tr>
				<c:forEach var="sl" items="${searchList}">
					<tr>
						<td>${sl.firstName}</td>
						<td>${sl.lastName}</td>
						<td><fmt:formatDate value="${sl.birthDate}"
								pattern="dd.MM.yyyy" /></td>
						<td>${sl.identityCode}</td>
						<td>${sl.note}</td>
						<td><fmt:formatDate value="${sl.created}"
								pattern="dd.MM.yy H:mm" /></td>
						<td>${sl.createdByName}</td>
						<td><fmt:formatDate value="${sl.updated}"
								pattern="dd.MM.yy H:mm" /></td>

						<td>${sl.updatedByName}</td>
						<td>${sl.cgName}</td>
						<td>${sl.address}</td>
						<td>${sl.house}</td>
						<td>${sl.townCounty}</td>
						<td>${sl.county}</td>
						<td>${sl.zip}</td>
						<td>${sl.commDevTypeName}</td>
						<td>${sl.commDevName}</td>
						<td><a href="customerManager/${sl.customer}">Muuda</a></td>

					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty searchList}">
		Otsingut pole kasutatud või ei leitud tulemusi
		</c:if>
	</div>

	<script>
		$(function() {
			$(".datepicker").datepicker({
				dateFormat : "dd.mm.yy",
				changeMonth : true,
				changeYear : true,
				yearRange : '-90:+0'
			});
		});
	</script>


</body>
</html>