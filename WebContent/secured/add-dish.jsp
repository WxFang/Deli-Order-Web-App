<!DOCTYPE html>
<html>

<head>
	<title>- Add Dish -</title>
	
	<link type="text/css" rel="stylesheet" href="../css/action-style.css">
	<link type="text/css" rel="stylesheet" href="../css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="hader">
			<h1>Chinese Deli</h1>
		</div>
	</div>

	<div id="container">
		<h3>Add Dish</h3>
		
		<form action="AdminControllerServlet" method="POST">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table class="center" style="width:40%;">
				<tbody>
					<tr>
						<td><label>Dish Name:</label></td>
						<td><input type="text" name="dishName" value="${THE_DISH.dishName}" /></td>
					</tr>

					<tr>
						<td><label>Price:</label></td>
						<td><input type="text" name="price" value="${THE_DISH.price}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save Change" class="save" /></td>
					</tr>
				</tbody>
			</table>
		
		</form>
		
	</div>


</body>


</html>