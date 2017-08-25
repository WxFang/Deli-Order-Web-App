## Web App for Deli Order

### Tech Stack:
Java EE, JSP, Servlet, JDBC, Mysql

### Design Pattern:
MVC, DAO

## Main Function:
<span style="color:red;">Administer:</span> Login, Add/delete dish, Update dish, Manage orders.
<br/><br/>
<span style="color:red;">Customer:</span> Choose dish, Add order, Delete order, See order.

## To be done: 

- [x] Create Order Class

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
	
- [x] Administer Login Page

- [x] Administer Authentication (Webfilter and Servlet)

- [x] Create MySQL database for dish and order

- [ ] Design basic customer page:
		- [ ] check box to choose dishes
		- [ ] radio box to choose pick time, place and payment
		- [ ] fill in name, email, cell
		- [ ] add note
