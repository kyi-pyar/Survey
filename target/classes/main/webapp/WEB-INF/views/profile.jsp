<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	<div><jsp:include page="header.jsp"></jsp:include></div>
	<div class='middle'>
	<c:set value="${sessionScope.user }" var="user"></c:set>
	
	
	 <img src="<c:url value="/resources/img/${user.profile_pic }"></c:url>" width="300px" height="200px" alt="user photo"></img><br>  
	
	
	ID:${user.id }<br>
	Name:${user.name }<br>	
	Email:${user.email }<br>
	Role:${user.role }<br>
	<a href="uploadPhoto">Upload Profile Pic</a><br>
	<a href="download_photo?photo=${user.profile_pic }">Download Profile Pic</a><br>
	<a href="#">Upload Question</a><br>
	<a href="#">View Uploaded Question</a>
	<c:if test="${user.role eq 'ADMIN'  }">
	<br>
	<a href="manage_user">Manage Users</a>
	</c:if>	
	</div>

</body>
</html>