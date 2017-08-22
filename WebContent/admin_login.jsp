<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>


<html>

<head>
	<title>Log In Your Account</title>
</head>

<body>

	<form action="admin" method="POST">
        <h3>Log In</h3>
        <label >
            <input name="id" class="input" type="text"  placeholder="User Name">
        </label>
        <br/><br/>
        <label >
            <input name="password" class="input" type="password"  placeholder="Password">
        </label>
        <br/><br/>
        <label >
            <input class="submit"  type="submit" value="Submit">
        </label>
    </form>


</body>

</html>