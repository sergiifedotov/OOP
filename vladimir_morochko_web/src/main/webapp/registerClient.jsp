<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 03.03.2015
  форма создания клиента
  Функции:
 - зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>зарегистрировать клиента</title>
</head>
<body>
<h>${registerResultMessage}</h>
<p><a href="dashboard.jsp"><<< dashboard</a></p>
<form action="/ClientServlet">
    <input type="hidden" name="action" value="registerClient"/>
    <p>Имя клиента:</p>
    <input type="text" name="name" value=""/>
    <p>Фамилия клиента:</p>
    <input type="text" name="surname" value=""/><br>
    <p>Телефон:</p>
    <input type="text" name="phone" value=""/><br>
    <p>Адрес:</p>
    <input type="text" name="address" value=""/><br><br>
    <input type="submit" name="register" value="Зарегистрировать!"/>
</form>
</body>
</html>
