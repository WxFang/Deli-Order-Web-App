<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> - Databasae Access - </title>
	<link rel="stylesheet" href="normalize.css">
	<link rel="stylesheet" href="styleLogin.css"> 
</head>
<body background="img/congruent_pentagon.png">
    <section class="loginform cf">


<form action = "LoginServlet" accept-charset="utf-8" method="post" >
    <ul>
        <li>
            <label for="user">Password</label>
            <input type="password" name="j_username"  required>
        </li>
    
  	<li>
        <input type="submit" value="Login">
    </li>
  	
    </ul>
</form>

${requestScope.error}
    </section>
</body>

</html>