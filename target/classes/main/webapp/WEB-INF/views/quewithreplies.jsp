<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	<div><jsp:include page="header.jsp"></jsp:include></div>
	<div class="middle">
	Question: ${que.que.upload_Question } <br>
	posted by: ${que.cname } on ${que.que.upload_date }<br>
	
	<ul>
	<c:forEach items="${replies }" var="reply">
	<li> ${reply.reply_ans } <br> replied by: ${reply.name } on ${reply.reply_date }</li>	
	</c:forEach>
	
	
	</ul>
	
	
	
	</div>

</body>
</html>