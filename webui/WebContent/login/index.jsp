<%@ page import="com.finna.be.octo.avenger.core.db.model.DBUser" %>
<%@ page import="com.finna.be.octo.avenger.core.db.dao.IUserDAO" %>
<%@ page import="com.finna.be.octo.avenger.core.db.dao.impl.UserDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
        <script>
            function submitForm()
            {
            	document.loginForm.submit();
            }
        </script>
</head>
<body>
            <div id="content">

                <!-- Home -->
                <div id="home">
                    <div class="content-leftAndRight" id="login">
                        <h2> Login </h2>
                        <br>
                        <form name="loginForm" action=j_security_check method = "post">
                            <table style="float:left; padding:20px 0px 200px 20px;">
                                <tr>
                                    <td>Username:</td>
                                    <td> <input type="text" name="user_name" id="usernameInput"> </td>
                                </tr>
                                <tr>
                                    <td>Password:</td>
                                    <td> <input type="password" name="user_pass" id="passwordInput"></td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <button type="submit">Login</button>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" id="loginErrorMessage">
                                        <!-- Error message -->
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
                <!-- End home -->
            </div>
</body>
</html>