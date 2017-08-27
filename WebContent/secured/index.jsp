<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>- Manage Orders & Dishes -</title>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
	<link rel="stylesheet" href="css/index-style.css"> 
</head>


<div class="w3-container">
	<center><h1>Management</h1></center>
	<center><%=new java.util.Date()%></center>
</div>

	<div class="w3-container w3-khaki" style="text-align:center;">
		<h3>Order</h3>
		<div style="overflow-x:auto;">
			<table border=1>
				  <tr>
				  	<th>Paid? </th>
				    <th>Picked? </th>
				    <th>Customer Name</th>
				    <th colspan="2">Dish</th>
				    <th colspan="2">Contact</th>
				    <th colspan="2">Pickup</th>
				    <th>Price</th>
				    <th>Payment</th>
				    <th>Note</th>
				  </tr>
				<tbody>
					<c:forEach var="tempOrder" items="${ORDER_LIST}">
						<c:url var="paidLink" value="AdminControllerServlet">
							<c:param name="command" value="PAID" />
							<c:param name="email" value="${tempOrder.email }" />
							<c:param name="dishName" value="${tempOrder.dishName }" />
						</c:url>
						<c:url var="pickedLink" value="AdminControllerServlet">
							<c:param name="command" value="PICKED" />
							<c:param name="email" value="${tempOrder.email }" />
							<c:param name="dishName" value="${tempOrder.dishName }" />
						</c:url>
						<tr>
							<td>
							<a href="${paidLink }">
							<c:if test="${tempOrder.isPaid()}">
								&#x2611
							</c:if>
							<c:if test="${not tempOrder.isPaid()}">
								&#x2610
							</c:if>
							</a>
							</td>
							<td>
							<a href="${pickedLink }">
							<c:if test="${tempOrder.isPicked()}">
								&#x2611
							</c:if>
							<c:if test="${not tempOrder.isPicked()}">
								&#x2610
							</c:if>
							</a>
							</td>
							<td>${tempOrder.userName }</td>
							<td>${tempOrder.dishId }</td>
							<td>${tempOrder.dishName }</td>
							<td>${tempOrder.email }</td>
							<td>${tempOrder.cell }</td>
							<td>${tempOrder.time }</td>
							<td>${tempOrder.place }</td>
							<td>$${tempOrder.price }</td>
							<td>${tempOrder.payment }</td>
							<td>${tempOrder.note }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
		<br/>
	</div>	
	<br/>
	<div class="w3-container w3-light-grey" style="text-align:center;">
		<h3>Dish</h3>
		<center>
			<table border=1>
				<col width="10%">
				<col width="60%">
				<col width="10%">
				<col width="20%">
				<tbody>
					<c:forEach var="tempDish" items="${DISH_LIST}">
						<c:url var="tempLink" value="AdminControllerServlet">
							<c:param name="command" value="LOAD" />
							<c:param name="dishName" value="${tempDish.dishName }" />
						</c:url>
						<c:url var="deleteLink" value="AdminControllerServlet">
							<c:param name="command" value="DELETE" />
							<c:param name="dishId" value="${tempDish.dishId }" />
							<c:param name="dishName" value="${tempDish.dishName }" />
							<c:param name="price" value="${tempDish.price }" />
						</c:url>
						<tr>
							<td>${tempDish.dishId }</td>
							<td>${tempDish.dishName }</td>
							<td>$${tempDish.price }</td>
							<td>
								<a href="${tempLink }">Update</a>
								|
								<a href="${deleteLink }"
								onclick="if(!(confirm('Are you sure you want to delete this stduent?'))) return false">
								Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
			<br/>
		</center>
		<br/>
		<input type="button" value="Add New Dish"
			onclick="window.location.href='add-dish.jsp; return false;'"
			class="w3-btn w3-black" style="text-align:center;"/>
		<br/>
	</div>
</body>

</html>