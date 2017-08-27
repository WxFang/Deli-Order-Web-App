<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>- Manage Orders -</title>
</head>


<center>
	<h1>Todays's Orders</h1>
	<%=new java.util.Date()%>
</center>

	<c:forEach var="tempOrder" items="${ORDER_LIST }">
		${tempOrder.dishName }<br/>
	</c:forEach>


</body>


</html>