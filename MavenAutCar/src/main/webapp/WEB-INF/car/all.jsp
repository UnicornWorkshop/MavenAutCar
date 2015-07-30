<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Cars</title>
</head>
<body>
	<div id="header">
		<h1>Car Section</h1>
	</div>

	<div id="nav">
		<a href="/car/all">Car</a><br> <a href="/client/all">Client</a><br>
		<a href="/contact/all">Contact</a><br> <a href="/equipment/all">Equipment</a><br>
		<a href="/office/all">Office</a><br>
	</div>

	<div id="section">
		<h1>All Cars</h1>
		<p>
	<table border="1">
		<tr>
			<td width="50px">id</td>
			<td width="100px">kapacita</td>
			<td width="100px">pobocka</td>
			<td width="100px">velikost</td>
			<td width="100px">vybava</td>
			<td width="100px">vykonnost</td>
			<td width="100px">znacka</td>
		</tr>
		<c:forEach items="${cars}" var="car">
			<tr>
				<td>${car.id}</td>
				<td>${car.kapacita}</td>
				<td>${car.pobocka.mesto}(id: ${car.pobocka.id})</td>
				<td>${car.velikost}</td>
				<td>${car.vybava}</td>
				<td>${car.vykonnost}</td>
				<td>${car.znacka}</td>
			</tr>
		</c:forEach>
	</table>
		</p>

		<p>
			<a href="/car/all">ALL</a> | <a href="/car/add">ADD</a> | <a
				href="/car/update">UPDATE</a> | <a href="/car/delete">DELETE</a>
			|
		</p>
	</div>

	<div id="footer">Copyright © V&P</div>

</body>
</html>