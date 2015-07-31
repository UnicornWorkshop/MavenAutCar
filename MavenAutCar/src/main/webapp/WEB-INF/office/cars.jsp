<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Office - cars</title>
</head>
<body>

	<table border="1">
		<tr>
			<td width="50px">id</td>
			<td width="150px">znacka</td>
		</tr>
		<c:forEach items="${cars}" var="car">
			<tr>
				<td>${car.id}</td>
				<td>${car.znacka}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>