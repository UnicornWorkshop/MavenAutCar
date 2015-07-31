<jsp:include page="//WEB-INF/layout/header.jsp"></jsp:include>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
function func () {
	
	//if (window.jQuery) {alert("ok");}
	
	$.postJSON = function(url, data, callback) {
	    return jQuery.ajax({
	    headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
	    'type': 'POST',
	    'url': url,
	    'data': JSON.stringify(data),
	    'dataType': 'json',
	    'success': callback
	    });
	};
	
	var value = document.getElementById('jmeno').value;
	var object = {"jmeno": value};
	
	$.postJSON("http://localhost:8080/MavenAutCar/client/add", object, null);	
}
</script>

<form id="form" onsubmit='func()'>
<input id="jmeno" name="jmeno" value="" />
<input type="submit" value="insert client" />
</form>

<jsp:include page="//WEB-INF/layout/footer.jsp"></jsp:include>