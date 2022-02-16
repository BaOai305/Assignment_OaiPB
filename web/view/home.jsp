<%-- 
    Document   : home
    Created on : Feb 14, 2022, 12:27:07 PM
    Author     : Phamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username: <input type="text" name="username"/><br/>
            Password: <input type="password" name="password"/><br/>
            <input type="checkbox" value="remember" name="remember"/> Remember Me! <br/>
            <input type="submit" value="Login"/>
        </form>     </body>
</html>
