<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 09.03.2015
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<p><a href="registerClient.jsp">зарегистрировать клиента</a></p>
<p><a href="/clientShowPortionServlet">вывести всех клиентов порциями по 10 человек</a></p>
<p><a href="/clientShowSumServlet">вывести всех клиентов наездивших на сумму больше указанной</a></p>
<p><a href="/clientShowMonthServlet">вывести всех клиентов, делавших заказы за последний месяц</a></p>
<br>
<p><a href="/orderCreateServlet">оформить заказ</a></p>
<p><a href="/orderShowPortionServlet">вывести список всех заказов порциями по 5 штук</a></p>
<p><a href="/orderShowServlet">вывести список заказов на сумму в указанном диапазоне</a></p>
<p><a href="/orderEditServlet">отредактировать заказ</a></p>
</body>
</html>
