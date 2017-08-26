<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>


<html>

<head>
	<title>- Enjoy Deli -</title>
	
	 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
</head>

<body>

<center>
	<h5><a href="login.jsp">Administer Login</a></h5>
	<h1>Menu</h1>
	<br><%=new java.util.Date()%><br>
</center>

<div class="w3-container">
	<c:forEach var="tempDish" items="${DISH_LIST}">
		${tempDish.dishName}<br/>
	</c:forEach>
</div>

</body>

</html>