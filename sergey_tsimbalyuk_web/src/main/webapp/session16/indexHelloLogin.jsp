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
<form action="/login" method="get">
    <select name="login">
        <option value="Vasiliy Petrovich">Vasya</option>
        <option value="Petr Vasilievich">Petya</option>
        <%--<option selected="selected" value="login">login</option>--%>
    </select>
    <input type="submit" name="login">
</form>
</body>
</html>
