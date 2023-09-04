<%@page import="com.tyss.myresturantapplication.dto.Admin"%>
<%@page import="com.tyss.myresturantapplication.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Super Admin Home Page</title>
<style>
* {
	padding: 0px;
	margin: 0px;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

nav {
	display: flex;
	justify-content: space-between;
	padding: 20px;
}

form {
	display: flex;
	flex-direction: column;
	width: 15%;
	background-color: silver;
	border-radius: 10px;
	padding: 20px 40px;
	margin: auto;
	box-shadow: 0px 0px 10px black;
}

form>input {
	margin: auto;
	padding: 8px;
	border-radius: 5px;
	background-color: silver;
	border: 1px solid white;
	margin: 10px 0px;
}

form>input:hover {
	border-color: green;
}

form>h2 {
	margin-bottom: 10px;
	text-align: center;
	background-color: silver;
	border-radius: 5px;
	box-shadow: 0px 0px 5px black;
	padding: 5px 10px;
}

table {
	background-color: silver;
	margin: auto;
	border-radius: 10px;
	padding: 10px 30px;
	box-shadow: 0px 0px 10px black;
}

.adminlist {
	text-align: center;
	width: 60%;
	margin: auto;
	padding-top: 10px;
}

button {
	color: white;
	background-color: crimson;
	border: none;
	border-radius: 5px;
	padding: 5px 10px;
	font-family: sans-serif;
	font-weight: bold;
	box-shadow: 0px 0px 10px white;
}

button:hover {
	transform: scale(1.1);
	transition: 100ms;
}

#color {
	height: 20px;
	width: 50px;
	background-color: black;
	color: white;
	text-align: center;
	align-items: center;
	font-weight: bold;
	padding: 3px;
	border-radius: 5px;
}

#nav {
	display: flex;
	align-items: center;
}

#nav>a {
	margin-left: 20px;
}

</style>
<script>
	let count = 0;
	function theme() {
		let divEle = document.getElementById("color");
		let divBody = document.getElementById("body");
		if (count == 0) {
			divBody.style.color = "white";
			divBody.style.backgroundColor = "Grey";
			divEle.style.backgroundColor = "White";
			divEle.style.color = "black";
			count++;
		} else {
			divBody.style.color = "black";
			divBody.style.backgroundColor = "white";
			divEle.style.backgroundColor = "black";
			divEle.style.color = "white"
			count--;
		}
	}
</script>
</head>
<body id="body">
	<nav>
		<div>
			<h1>Welcome Mr.${name}</h1>
			<h3>Your Role : ${role}</h3>
		</div>
		<div id="nav">
			<div id="color" onclick="theme()">Theme</div>
			<a href="logout"><button>Logout</button></a>
		</div>
	</nav>

	<hr>
	<br>
	<br>




	<form action="createadmin" method="post" enctype="multipart/form-data">
		<h2>Create Admin :</h2>
		<label for="name">Name :</label> <input type="text" id="name"
			name="name" placeholder="Enter Name" /> <label for="email">Email
			:</label><input type="text" id="email" name="email" placeholder="Enter Email" />
		<label for="password">Password :</label><input type="text"
			id="password" name="password" placeholder="Enter Password" />
			<input type="file" name="image" >
			 <input type="hidden" name="role" value="ADMIN" readonly="readonly" />
		<button type="submit"
			style="background-color: green; margin-top: 20px;">
			
			Create-Admin</button>
	</form>


	<br>
	<br>
	<hr />
	<br>
	<br>
	<div class="adminlist">
		<h2>Admin List:</h2>
		<br>
		<table cellpadding="20" cellspacing="30">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Role</th>
				<th>Delete</th>
			</tr>
			<%
			for (Admin admin : new AdminDao().findAllAdmin()) {
			%>
			<tr>
				<td><%=admin.getName()%></td>
				<td><%=admin.getEmail()%></td>
				<td><%=admin.getPassword()%></td>
				<td><%=admin.getRole()%></td>
				<td><a href="deleteadmin?id=<%=admin.getId()%>"><button
							type="button">DELETE</button></a></td>
			</tr>
			<%
			}
			%>
		</table>
		<br>
	</div>
	<br>
	<br>
	<hr>
	<br>
	<a href="logout"><button style="margin-left: 48%;">Logout</button></a>
	<br>
	<br>
</body>
</html>