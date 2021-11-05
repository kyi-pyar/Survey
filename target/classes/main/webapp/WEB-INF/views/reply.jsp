<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	<div><jsp:include page="header.jsp"></jsp:include></div>
	<div class="middle">
	
	Question: ${que }	<br> posted by ${uploader }<br>
	<form action="submitreply" >
	<input type="hidden" name="q_id" value="${que_id }">
	<input type="text" width="40px" height="50px" name="reply" placeholder="enter your reply">
	<input type="submit"> <input type="reset"> 	
	
	</form>
	
	</div>

</body>
</html>