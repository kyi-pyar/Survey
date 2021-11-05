<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
	<div><jsp:include page="header.jsp"></jsp:include></div>
	
	
	<div class="middle">
	<c:choose>
	<c:when test="${sessionScope.editbyEach eq 'true' }">
	<form:form modelAttribute="que"  action="editQueSave">
	<form:hidden path="question_id"/>	
	<form:input path="upload_title"  value="${que.upload_title }"/><br>
	<form:textarea path="upload_Question" value="${que.upload_Question }" rows="7" cols="30"/><br>
	<input type="submit" value="Edit"> &nbsp; <input type="reset"> 
	</form:form>
	</c:when>
	<c:otherwise>
	<form:form modelAttribute="que"  action="saveQue">
	<form:hidden path="question_id"/>
	<form:input path="upload_title"  placeholder="Enter title"/>	<br>
	<form:textarea path="upload_Question" placeholder="Enter Question" rows="7" cols="30"/><br>
	<input type="submit" value="upload"> &nbsp; <input type="reset"> 
	</form:form>
	</c:otherwise>
	</c:choose>	
	
	
	
	</div>

</body>
</html>