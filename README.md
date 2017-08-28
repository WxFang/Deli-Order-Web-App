## Web App for Deli Order

### Tech Stack:
Java EE, JSP, Servlet, JDBC, Mysql

### Design Pattern:
MVC, DAO

<br />

## Main Function:
Administer: Login, Add/delete dish, Update dish, Manage orders.
Customer: Choose dish, Add order, Delete order, See order.

<br />

## MVC Design Architecture
![img](http://i.imgur.com/Ry2kDsv.png)


 Servlet and Filter        |  JSP, SQL scripts, CSS and XML
:-------------------------:|:-------------------------:
![img](http://i.imgur.com/iHTT6b2.png)  |  ![img](http://i.imgur.com/8HJeafi.png)
<br />

## To be done: 
- [x]  <Strong>Create Order Class</Strong>

	- order id
	- customer name
	- phone number
	- email
	- dish name
	- dish id
	- pickup time
	- pickup address
	- dish price
	- payment way
	- is paid or not
	- is picked or not
	- note
	
- [x]  <Strong>Create Dish Class</Strong>

	- dish id (each dish has unique id, even after deleted)
	- dish name
	- price
	
- [x]  <Strong>Administer Login Page</Strong>


- [x]  <Strong>Administer Authentication (Webfilter and Servlet)</Strong>


- [x]  <Strong>Create MySQL database for dish and order</Strong>


- [x]  <Strong>Design basic customer page:<br/></Strong>
	
	- choose dishes
	- choose pick time, place and payment
	- fill in name, email, cell
	- add note
	
- [x] <Strong>Design basic administer page:<br/></Strong>

	- show all orders (order by isPaid, isPicked and customer name)
	- show all dishes 
	- add / delete dish
	- update dish info
	- update state of order (isPicked, isPaid)
	
- [x]  <Strong>Handle cookies for customer information</Strong>

	- store cookie in OrderControllerServlet (Tomcat doesn't allow " " in cookie)
	- read cookie in welcome.jsp

