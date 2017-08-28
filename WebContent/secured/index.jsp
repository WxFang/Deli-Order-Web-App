<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>- Manage Orders & Dishes -</title>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	 <link href='http://fonts.googleapis.com/css?family=Oleo+Script' rel='stylesheet' type='text/css'>
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"> 
	<link rel="stylesheet" href="../css/index-style.css"> 
</head>


<div class="w3-container center">
	<h1>Management</h1>
	<%=new java.util.Date()%>
</div>

	<div class="w3-container center" id="order">
		<h3>Order</h3>
		<div style="overflow-x:auto;">
			<table style="text-align:center;">
					<c:url var="orderDishLink" value="AdminControllerServlet">
							<c:param name="command" value="LIST" />
							<c:param name="sql" value="select * from `order` order by dishId ASC, isPaid, isPicked" />
					</c:url>
					<c:url var="orderUserLink" value="AdminControllerServlet">
							<c:param name="command" value="LIST" />
							<c:param name="sql" value="select * from `order` order by userName ASC, isPaid, isPicked" />
					</c:url>
				  <tr>
				  	<th>Paid? </th>
				    <th>Picked? </th>
				    <th>Customer Name
				    <a href="${orderUserLink }"><i class="fa fa-fw fa-sort"></i></a>
				    </th>
				    <th colspan="2">Dish
				    <a href="${orderDishLink }"><i class="fa fa-fw fa-sort"></i></a>
				    </th>
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
							<td class="center">
							<a href="${paidLink }">
							<c:if test="${tempOrder.isPaid()}">
								&#x2611
							</c:if>
							<c:if test="${not tempOrder.isPaid()}">
								&#x2610
							</c:if>
							</a>
							</td>
							<td class="center">
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
	<center>
	<div class="w3-container" id="dish">
		<br/>
		<h3>Dish</h3>
			<table style="text-align:center;">
				<tr>
					<th>Dish Id</th>
					<th>Dish Name</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<tbody class="center">
					<col width="10%">
					<col width="60%">
					<col width="10%">
					<col width="20%">
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
							<td class="center">${tempDish.dishId }</td>
							<td>${tempDish.dishName }</td>
							<td class="center">$${tempDish.price }</td>
							<td class="center"><a href="${tempLink }">Update</a>
								|
								<a href="${deleteLink }"
								onclick="if(!(confirm('Are you sure you want to delete this dish?'))) return false">
								Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		<br/>
		<input class="w3-btn w3-white w3-round" id="button" value="Add New Dish" 
	onclick="window.location.href='add-dish.jsp; return false;'"/>
		<br/>
		<br/>
	</div>
	</center>
	<br/>
	<br/><br/>
</body>

</html>