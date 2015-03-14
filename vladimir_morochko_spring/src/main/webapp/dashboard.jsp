<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 09.03.2015
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<html>
<head>
    <title>Список функций</title>
</head>
<body>

<h4>${dashboardMessage}</h4>
<p><a href="registerClient.jsp">Зарегистрировать нового клиента</a></p>
<p><a href="/clientShowPortionServlet">Вывести всех клиентов порциями по 10 человек</a></p>
<form action="/clientShowSumServlet">
    <p><input type="submit" name="action" value="Показать"/> всех клиентов, наездивших на сумму больше: <input type="text" name="clientMinSum" value="0"/></p>
</form>
<p><a href="/clientShowMonthServlet">Вывести всех клиентов, делавших заказы за последний месяц</a></p>
<br>

<p><a href="/orderCreateServlet">Оформить новый заказ</a></p>
<p><a href="/orderEditServlet?action=editOrder">Отредактировать существующий заказ</a></p>
<p><a href="/orderShowPortionServlet">Вывести список всех заказов порциями по 5 штук</a></p>

<form action="/orderShowServlet">
    <p><input type="submit" name="action" value="Показать"/> список заказов на сумму в указанном диапазоне: от <input type="text" name="orderAmountLowerLimit" value="0"/> до <input type="text" name="orderAmountUpperLimit" value="1000"/></p>
</form>

<br>
<p><a href="index.jsp">Выйти</a></p>
</body>
</html>
