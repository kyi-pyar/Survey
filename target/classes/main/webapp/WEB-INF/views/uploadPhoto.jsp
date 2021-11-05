<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<body>
	<div><jsp:include page="header.jsp"></jsp:include></div>
	<div class="middle">
	<form action="uploadFile" method="post" enctype="multipart/form-data">	
	Choose File: <input type="file" name="photo"><input type="submit">
	</form>
	
	</div>

</body>
</html>