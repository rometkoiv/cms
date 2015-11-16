<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<jsp:include page="/WEB-INF/views/topMenu.jsp"/>
	<h1>HTTP Status 403 - Selle kasutajaga siia ligi ei pääse</h1>

	<c:choose>
		<c:when test="${empty username}">
			<h2>Siia ei saa: 403</h2>
		</c:when>
		<c:otherwise>
			<h2>Username : ${username} <br/>Pole õigust</h2>
		</c:otherwise>
	</c:choose>

</body>
</html>