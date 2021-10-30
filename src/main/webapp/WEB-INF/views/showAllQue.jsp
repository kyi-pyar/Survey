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
	
	<ol start="${q_no }">
	<c:forEach var="all" items="${questions }">	
	<li >
	Title . ${all.que.upload_title }<br>
	About . ${all.que.upload_Question }<br>
	posted on ${all.que.upload_date } by ${all.cname }<br>	
	</li>	
	</c:forEach>
	</ol>	
	</div>	
	<div>
	Page :
	<c:forEach begin="1" end="${pages}" var="page"><a href="showAllQue?p_no=${page}"> ${page } </a> </c:forEach>	
	</div>

</body>
</html>