<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	<div><jsp:include page="header.jsp"></jsp:include></div>
	<div class="middle">
	<h3>Login Form</h3>
	<c:if test="${sessionScope.login eq 'not-match' }">
	<div class="error">user name and password does not match.</div>
	</c:if>
	<form action="checkuser" method="post">
	<input type="text" name="name" placeholder="Enter user name"><br><br>
	<input type="password" name="password" placeholder="Enter password"><br><br>
	<input type="submit"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset">
	</form>
	</div>
</body>
</html>