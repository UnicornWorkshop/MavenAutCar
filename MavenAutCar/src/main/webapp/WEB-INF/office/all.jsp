<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Offices</title>
</head>
<body>

<table border="1">
<tr>
<td width="50px">id</td>
<td width="150px">mesto</td>
</tr>
<c:forEach items="${offices}" var="pobocka">
  <tr>
  <td>${pobocka.id}</td>
  <td>${pobocka.mesto}</td>
  </tr>
</c:forEach>
</table>

</body>
</html>