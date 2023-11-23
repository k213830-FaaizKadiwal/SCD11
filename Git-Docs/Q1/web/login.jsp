<%-- 
    Document   : login
    Created on : Oct 12, 2023, 8:47:34 AM
    Author     : k213830
--%>

<!-- login.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
    <form action="rememberMeLogin" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <input type="checkbox" id="rememberMe" name="rememberMe"> Remember Me<br>

        <input type="submit" value="Login">
    </form>
</body>
</html>

