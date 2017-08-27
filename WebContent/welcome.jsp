<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>


<html>

<head>
	<title>- Enjoy Deli -</title>
	
	 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
	 <link type="text/css" rel="stylesheet" href="css/welcome-style.css">
</head>

<body>

<center>
	<h5><a href="login.jsp">Administer Login</a></h5>
	<h1>Chinese Deli</h1>
	<br><%=new java.util.Date()%><br><br>
</center>

<form action="OrderControllerServlet" method="POST">
	<input type="hidden" name="command" value="ADD" />

	<div class="w3-container w3-khaki" style="margin:auto; width:50%;">
		<center><h3>Menu</h3></center>
		<table>
			<col width="600">
			<col width="50">
			<tbody>
				<c:forEach var="tempDish" items="${DISH_LIST}">
					<tr>
						<td><input type="radio" name ="dishName" value="${tempDish.dishName }" required> ${tempDish.dishName }<br/></td>
						<td>$${tempDish.price }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
		<br/>
	</div>	
	<br>
	<div class="w3-container w3-teal" style="margin:auto; width:50%;">
		<h3>Pick Time</h3>
		<input type="radio" name="time" value="11:30" required> 11:30
		<input type="radio" name="time" value="12:00" required> 12:00
		<input type="radio" name="time" value="12:30" required> 12:30
		<h3>Pick Place</h3>
		<input type="radio" name="place" value="Student Center" required> Student Center
		<input type="radio" name="place" value="Tech Square" required> Tech Square 
		<input type="radio" name="place" value="100 Midtown" required> 100 Midtown
		<input type="radio" name="place" value="glc/10th" required> glc/10th
		<h3>Payment</h3>
		<input type="radio" name="payment" value="Venmo" required> Venmo
		<input type="radio" name="payment" value="Debit Card" required> Debit Card
		<input type="radio" name="payment" value="Paypal" required> Paypal
		<br/><br/>
	</div>	
	<br>
	<div class="w3-container w3-indigo" style="margin:auto; width:50%;">
		<h3>Contact</h3>
		<table>
			<tbody>
				<tr>
					<td>Name: </td>
					<td><input type="text" name="name" required/></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><input type="text" name="email" required/></td>
				</tr>
				<tr>
					<td>Telephone number: </td>
					<td><input type="text" name="cell" required/></td>
				</tr>
			</tbody>
		</table>
		<br/>
	</div>
	<br>
	<div class="w3-container w3-light-grey" style="margin:auto; width:50%;">
		<h3>Note</h3>
		<input type="text" name="note" style="width:100%; height:100%"/>
		<br/><br/>
	</div>
	<br>
	<div class="w3-container" style="margin:auto; width:20%;">
		<input type="submit" value="Submit new order" class="w3-btn w3-black w3-block w3-round" onclick="alert('Order Submitted!');"/>
	</div>
</form>

</body>

</html>