<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	<div><jsp:include page="header.jsp"></jsp:include></div>
	<div class='middle'>
	<c:set value="${sessionScope.user }" var="user"></c:set>
	ID:${user.id }<br>
	Name:${user.name }<br>
	Email:${user.email }<br>
	Role:${user.role }<br>
	<a href="#">Upload Question</a><br>
	<a href="#">View Uploaded Question</a>
	<c:if test="${user.role eq 'ADMIN'  }">
	<br>
	<a href="manage_user">Manage Users</a>
	</c:if>	
	</div>

</body>
</html>