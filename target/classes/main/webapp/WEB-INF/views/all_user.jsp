<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	<div><jsp:include page="header.jsp"></jsp:include></div>
	<div class="middle">
	<c:forEach var="c" items="${customers}">
	ID: ${c.id } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${c.name }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Role: ${c.role }<br>
	Email: ${c.email }	<br>
	<a href="promote_customer?cid=${c.id }">promote</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete_customer?cid=${c.id }">delete</a>
	<hr>
	</c:forEach>
	</div>

</body>
</html>