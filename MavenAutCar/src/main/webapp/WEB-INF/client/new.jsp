<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="//WEB-INF/layout/header.jsp"></jsp:include>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
$.request = function(url, method, data, callback) {
    return jQuery.ajax({
    headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    'type': method,
    'url': url,
    'data': JSON.stringify(data),
    'dataType': 'json',
    'success': null
    });
};

function insertFunc () {	
	var value = document.getElementById('jmeno').value;
	var object = {"jmeno": value};
	
	$.request("http://localhost:8080/MavenAutCar/client/add", "POST",object, null);	
}

function updateFunc(id) {	
	var value = document.getElementById('jmeno'+id).value;
	var object = {"jmeno": value};
	
	$.request("http://localhost:8080/MavenAutCar/client/update/"+id, "PUT", object, null);
}

function deleteFunc(id) {
	$.request("http://localhost:8080/MavenAutCar/client/delete/"+id, "DELETE", null, null);
}


</script>

<form id="form" onsubmit='insertFunc()'>
<input id="jmeno" name="jmeno" value="" />
<input type="submit" value="insert client" />
</form>

<table>
<tbody>
	<td width="50px">id</td>
	<td width="150px">name</td>
</tbody>
<c:forEach items="${clients}" var="client">
	<tr>
		<td>${client.id}</td>
		<td>${client.jmeno}</td>
		<td>
		<form id="form${client.id}" onsubmit="updateFunc('${client.id}')">
		<input id="jmeno${client.id}" name="jmeno" value="${client.jmeno}" />
		<input type="submit" value="update" />
		</form>
		</td>
		<td>
		<form id="formdelete${client.id}" onsubmit="deleteFunc('${client.id}')">
		<input type="submit" value="delete" />
		</form>
		</td>
	</tr>
</c:forEach>
</table>

<jsp:include page="//WEB-INF/layout/footer.jsp"></jsp:include>