<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Survey</title>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"></c:url>">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" >
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
	<nav>
		<label class="logo">Survey</label>
		<ul>
			<li><a href="register">Registration</a></li>
			<li><a href="login">Login</a></li>			
			<li><a href="showAllQue?p_no=1">Show Questions</a></li>			
			<c:if test="${sessionScope.user ne null }">
			<li><a href="logout">Logout</a></li>
			<li><a href="uploadQue">Upload Question</a></li>
			<li><a href="profile">Hello ${user.name }</a></li>
			</c:if>
		</ul>		
	</nav>

</body>
</html>