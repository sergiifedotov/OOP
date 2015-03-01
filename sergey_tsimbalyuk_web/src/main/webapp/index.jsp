<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello User</title>
</head>
<body>
${key}
<form action="/lsrv" method="get">
    Username: <input type="text" name="login"><br>
    Password: <input type="password" name="password">

    <input type="submit" name="submit">
</form>
<%--<form action="/lsrv" method="get">--%>
<%--<h3>login: </h3><input type="text" name="login"/>--%>
<%--<h3>password: </h3><input type="text" name="password"/>--%>
<%--</br>--%>
<%--</br>--%>

<%--</form>--%>
<%--<form action="/login" method="get">--%>
<%--<select name="login">--%>
<%--<option value="Vasiliy Petrovich">Vasya</option>--%>
<%--<option value="Petr Vasilievich">Petya</option>--%>
<%--<option selected="selected" value="login">login</option>--%>
<%--</select>--%>
<%--<input type="submit" name="login">--%>
<%--</form>--%>
</body>
</html>
