<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>- Manage Orders & Dishes-</title>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
	<link rel="stylesheet" href="css/index-style.css"> 
</head>


<center>
	<h1>Management</h1>
	<%=new java.util.Date()%>
</center>

	<div class="w3-container w3-khaki">
		<center><h3>Orders</h3></center>
		<div style="overflow-x:auto;">
			<table>
				  <tr>
				    <th>Customer Name</th>
				    <th colspan="2">Dish</th>
				    <th colspan="2">Contact</th>
				    <th colspan="2">Pickup</th>
				    <th>Price</th>
				    <th>Payment</th>
				    <th>Paid? </th>
				    <th>Picked? </th>
				    <th>Note</th>
				  </tr>
				<tbody>
					<c:forEach var="tempOrder" items="${ORDER_LIST}">
						<tr>
							<td>${tempOrder.userName }</td>
							<td>${tempOrder.dishId }</td>
							<td>${tempOrder.dishName }</td>
							<td>${tempOrder.email }</td>
							<td>${tempOrder.cell }</td>
							<td>${tempOrder.time }</td>
							<td>${tempOrder.place }</td>
							<td>$${tempOrder.price }</td>
							<td>${tempOrder.payment }</td>
							<td>${tempOrder.isPaid() }</td>
							<td>${tempOrder.isPicked() }</td>
							<td>${tempOrder.note }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
		<br/>
	</div>	

</body>


</html>