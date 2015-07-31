<jsp:include page="//WEB-INF/layout/header.jsp"></jsp:include>
<table style="width:100%; border-spacing:0;">
	<tbody>
		<td width="50px">id</td>
		<td width="150px">name</td>
	</tbody>
	<c:forEach items="${clients}" var="client">
		<tr>
			<td>${client.id}</td>
			<td>${client.jmeno}</td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="//WEB-INF/layout/footer.jsp"></jsp:include>