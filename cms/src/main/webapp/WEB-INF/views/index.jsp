<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/styleheet.css" type="text/css"/>
<title>CMS</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/topMenu.jsp"/>


		<h2>Esileht</h2>
		<h3><a href="Search">Klientide otsing</a></h3>
		<h3>Abistavad tööriistad</h3>
		<ul>
		    
			<li><a href="groupManager">Gruppide Haldus</a></li>
			<li><a href="CommDeviceType">Sidevahendite tüübid</a></li>
			<li><a href="empUser">Kasutajad</a></li>
		</ul>
		<h2>Jadadiagrammid</h2>
		 <img alt="" src="${pageContext.request.contextPath}/static/diagrams/SQ_add_new_client.png">
		  <img alt="" src="${pageContext.request.contextPath}/static/diagrams/SQ_modifyGroups.png">
	   <h2>Klassidiagrammid</h2>
	   <img alt="" src="${pageContext.request.contextPath}/static/diagrams/CD_Search.png">
	   <img alt="" src="${pageContext.request.contextPath}/static/diagrams/CD_Employee.png">
	   <img alt="" src="${pageContext.request.contextPath}/static/diagrams/CD_Customer.png">
	   <img alt="" src="${pageContext.request.contextPath}/static/diagrams/CD_Cgroup.png">
	   <img alt="" src="${pageContext.request.contextPath}/static/diagrams/CD_CustomerGroup.png">
	   <img alt="" src="${pageContext.request.contextPath}/static/diagrams/CD_CstAddress.png">
	   <img alt="" src="${pageContext.request.contextPath}/static/diagrams/CD_commdev.png">
</body>
</html>