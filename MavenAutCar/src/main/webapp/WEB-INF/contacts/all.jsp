<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Contacts</title>
</head>
<body>
	<div id="header">
		<h1>Contact Section</h1>
	</div>

	<div id="nav">
		<a href="/car/all">Car</a><br> <a href="/client/all">Client</a><br>
		<a href="/contact/all">Contact</a><br>
		<a href="/equipment/all">Equipment</a><br>
		<a href="/office/all">Office</a><br>
	</div>

	<div id="section">
		<h1>All Contacts</h1>
		<p>
		<table border="1">
			<tr>
				<td width="50px">id</td>
				<td width="150px">client</td>
				<td width="150px">typ</td>
				<td width="150px">value</td>
			</tr>
			<c:forEach items="${contacts}" var="contact">
				<tr>
					<td>${contact.id}</td>
					<td>${contact.klient.jmeno}(id: ${contact.klient.id})</td>
					<td>${contact.typ}</td>
					<td>${contact.data}</td>
				</tr>
			</c:forEach>
		</table>
		</p>

		<p>
			<a href="/contact/all">ALL</a> | <a href="/contact/add">ADD</a> |
			<a href="/contact/update">UPDATE</a> | <a href="/contact/delete">DELETE</a> |
		</p>
	</div>

	<div id="footer">Copyright � V&P</div>

</body>
</html>