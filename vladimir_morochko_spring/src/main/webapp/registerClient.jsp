<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 09.03.2015
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<html>
<head>
    <title>Зарегистрировать клиента</title>

</head>
<body>
<h4>${clientMessage}</h4>
<p><a href="dashboard.jsp"><<< dashboard</a></p>
<form action="/clientCreateServlet">
    <p>Имя клиента:</p>
    <input type="text" name="name" value=""/>
    <p>Фамилия клиента:</p>
    <input type="text" name="surname" value=""/>
    <p>Телефон:</p>
    <input type="text" name="phone" value=""/>
    <p>Адрес:</p>
    <input type="text" name="address" value=""/><br><br>
    <input type="submit" name="register" value="Зарегистрировать"/>
</form>
</body>
</html>
