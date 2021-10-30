<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

<div><jsp:include page="header.jsp"></jsp:include></div>
<div class="middle">
<h2>Registration</h2>

<form:form action="savecutomer" modelAttribute="customer">
Enter name: <form:input path="name"/><form:errors path="name" class="error"></form:errors><br>
Enter password: <form:input path="password"/><form:errors path="password" class="error"></form:errors><br>
Enter email: <form:input path="email"/><form:errors path="email" class="error"></form:errors><br>
<input type="submit"> <input type="reset">
</form:form>

</div>
</body>
</html>