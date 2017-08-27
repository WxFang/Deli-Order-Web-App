<!DOCTYPE html>
<html>

<head>
	<title>Add Student</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div class="w3-container">
		<h3>Update Dish</h3>
		
		<form action="AdminControllerServlet" method="POST">
		
			<input type="hidden" name="command" value="UPDATE" />
			
			<input type="hidden" name="dishId" value="${THE_DISH.dishId }" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Dish Name: </label></td>
							<td><input type="text" name="dishName" value="${THE_DISH.dishName}" /></td>
					</tr>

					<tr>
						<td><label>Price: </label></td>
						<td><input type="text" name="price" value="${THE_DISH.price}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save change" class="save" /></td>
					</tr>
				</tbody>
			</table>
		
		</form>
		
	
	</div>





</body>


</html>