<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
#header {
    background-color:black;
    color:white;
    text-align:center;
    padding:5px;
}
#nav {
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:100px;
    float:left;
    padding:5px;
}
#section {
    width:350px;
    float:left;
    padding:10px;
}
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
    padding:5px;
}
</style>
<title>Clients</title>
</head>
<body>
	<div id="header">
		<h1>Client Section</h1>
	</div>

	<div id="nav">
		<a href="/car/all">Car</a><br> <a href="/client/all">Client</a><br>
		<a href="/contact/all">Contact</a><br> <a href="/equipment/all">Equipment</a><br>
		<a href="/office/all">Office</a><br>
	</div>

	<div id="section">
		<h1>All Clients</h1>
		<p>
		<table border="1">
			<tr>
				<td width="50px">id</td>
				<td width="150px">name</td>
			</tr>
			<c:forEach items="${clients}" var="client">
				<tr>
					<td>${client.id}</td>
					<td>${client.jmeno}</td>
				</tr>
			</c:forEach>
		</table>
		</p>

		<p>
			<a href="/client/all">ALL</a> | <a href="/client/add">ADD</a> | <a
				href="/client/update">UPDATE</a> | <a href="/client/delete">DELETE</a>
			|
		</p>
	</div>

	<div id="footer">Copyright © V&P</div>

</body>
</html>