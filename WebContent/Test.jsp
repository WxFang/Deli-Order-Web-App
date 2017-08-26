<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>


<html>

<head>
	<title>- Test DB -</title>
	
	 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
</head>

<body>

<c:forEach var="tempDish" items="${DISH_LIST}">
	${tempDish.name}
</c:forEach>


</body>

</html>