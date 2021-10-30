<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	<div><jsp:include page="header.jsp"></jsp:include></div>
	<div class="middle">
	Hello World
	<c:if test="${sessionScope.user ne null }">
			<a href="showQuebyEach">Show Uploaded Questions</a>
	</c:if>	
	</div>

</body>
</html>