<!DOCTYPE html>
<html>

<head>
	<title>Add Dish</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div class="w3-container">
		<h3>Add Dish</h3>
		
		<form action="AdminControllerServlet" method="POST">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td>Dish Name: </td>
						<td><input type="text" name="dishName" /></td>
					</tr>
					
					<tr>
						<td>Price: </td>
						<td><input type="text" name="price" /></td>
					</tr>
					
					<tr>
						<td></td>
						<td><input type="submit" value="Submit" class="save" /></td>
					</tr>
				</tbody>
			</table>
		
		</form>
		
	
	</div>





</body>


</html>