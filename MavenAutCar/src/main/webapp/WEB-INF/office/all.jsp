<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Clients</title>
</head>
<body>
	<div id="header">
		<h1>Office Section</h1>
	</div>
	
	
	<script>
		function handleClick(var mesto) {
			
			
		}
	</script>
	<div>
		<form name="myform" onSubmit="handleClick()">
		  <input id="mesto" name="mesto" type="text">
	      <input name="Submit"  type="submit" value="Submit" onClick="handleClick(this.mesto)"/>

    	</form>	
	</div>
	
	

	<div id="nav">
		<a href="/car/all">Car</a><br> <a href="/client/all">Client</a><br>
		<a href="/contact/all">Contact</a><br>
		<a href="/equipment/all">Equipment</a><br>
		<a href="/office/all">Office</a><br>
	</div>

	<div id="section">
		<h1>All offices</h1>
		<p>
		<table border="1">
			<tr>
				<td width="50px">id</td>
				<td width="150px">location</td>
			</tr>
			<c:forEach items="${offices}" var="office">
				<tr>
					<td>${office.id}</td>
					<td>${office.mesto}</td>
				</tr>
			</c:forEach>
		</table>
		</p>

		<p>
			<a href="/office/all">ALL</a> | <a href="/office/add">ADD</a> |
			<a href="/office/update">UPDATE</a> | <a href="/office/delete">DELETE</a> |
		</p>
	</div>

	<div id="footer">Copyright � V&P</div>

</body>
</html>