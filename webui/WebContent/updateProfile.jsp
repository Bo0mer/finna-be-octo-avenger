<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function validateEmail(email) { 
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
function validateForm() {
    var name = document.forms["profileForm"]["name"].value;
    var email = document.forms["profileForm"]["email"].value;
    if (name == null || name == "") {
        alert("Name must be filled out.");
        return false;
    }
    if (email == null || email == "") {
    	alert("Email must be filled out.");
    	return false;
    }
    if (!validateEmail(email)) {
    	return false;
    }
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello for first time</title>
</head>
<body>
Hello! It seems that this is your first login. Please share with us your details. <br/>
	<form name="profileForm" method="post" action="CreateUser" onsubmit="return validateForm()">
		<label>Full name:</label> <input type="text" name="name"> <br /> 
		<label>E-mail:</label> <input type="text" name="email"> <br />
		<input type="submit">
		<br />
	</form>
</body>
</html>