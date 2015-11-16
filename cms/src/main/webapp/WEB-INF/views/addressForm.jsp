<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<h4>Aadressid:</h4>
		
			<c:if test="${not empty addressList}">
			<table>
			<c:forEach var="ad" items="${addressList}">
			 <tr>
			 <td>${ad.address}</td>
			 <td>${ad.house}</td>
			 <td>${ad.townCounty}</td>
			 <td>${ad.county}</td>
			 <td>${ad.email}</td>
			 <td>${ad.mobile}</td>
			 <td>${ad.phone}</td>
			 <td>${ad.note}</td>
			 <td>${ad.created} </td>
			 <td>${ad.updated} </td>
			 <td><a href = "${pageContext.request.contextPath}/customerManager/${customerID}/address/${ad.cstAddress}">edit</a> </td>
			 <td><a href = "${pageContext.request.contextPath}/customerManager/${customerID}/address/${ad.cstAddress}/delete">Remove</a> </td>
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
			 <td></td>
			 <td></td>
			 <td></td>
			 <td></td>
			 <td><a href = "${pageContext.request.contextPath}/customerManager/${customerID}/address/0">Lisa Uus</a> </td>
			</tr>
			</table>
            </c:if>
            <c:if test="${not empty formaddress}">
                   
            <form:form modelAttribute="formaddress" >
              <form:hidden path="cstAddress"/>
              <table>
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
			<td>Linn/Küla</td>
            <td><form:input path="townCounty" /></td>
			<td><form:errors path="townCounty" /></td>
           </tr>   
           <tr>
			<td>Maakond</td>
            <td><form:input path="county" /></td>
			<td><form:errors path="county" /></td>
           </tr>   
           
            <tr>
			<td>Indeks</td>
            <td><form:input path="zip" /></td>
			<td><form:errors path="zip" /></td>
           </tr>   
            <tr>
			<tr>
			<td>Märkused</td>
            <td><form:input path="note" /></td>
			<td><form:errors path="note" /></td>
           </tr>  
           <tr>
			<td></td>
            <td colspan ="2"><input type="submit" value = "Salvesta"/></td>
			 </tr> 	 	
		    </table>       
			</form:form>
		</c:if>
		<c:if test="${(empty addressList) and (empty formaddress)}"><a href = "${pageContext.request.contextPath}/customerManager/${customerID}/address/0">Lisa Uus</a></c:if>
	
