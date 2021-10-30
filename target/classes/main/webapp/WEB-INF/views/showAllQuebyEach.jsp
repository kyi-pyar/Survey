<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div>
<jsp:include page="header.jsp"></jsp:include></div>
	<div class="middle">
	
	<ol>
	<c:forEach var="que" items="${questions }">	
	<li>
	Title . ${que.upload_title }<br>
	About . ${que.upload_Question }<br>
	posted on ${que.upload_date } <br>
	<a href="editQue?q_id=${que.question_id }">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteQue?q_id=${que.question_id }">Delete</a>
	</li>
	
	</c:forEach>
	</ol>
	
	</div>

</body>
</html>