<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 03.03.2015
  страница со списком функций (доступна после аутентификации)
  Функции:
 - зарегистрировать клиента
 - вывести всех клиентов порциями по 10 человек
 - вывести всех клиентов наездивших на сумму больше указанной
 - вывести всех клиентов, делавших заказы за последний месяц

 - оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
 - отредактировать заказ (поменять свойства заказа)
 - вывести список заказов на сумму в указанном диапазоне
 - вывести список всех заказов порциями по 5 штук
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p><a href="registerClient.jsp">зарегистрировать клиента</a></p>
<p><a href="/ClientServlet?action=showClientsByPortion">вывести всех клиентов порциями по 10 человек</a></p>
<p><a href="/ClientServlet?action=showClientsGtSum">вывести всех клиентов наездивших на сумму больше указанной</a></p>
<p><a href="/ClientServlet?action=showClientsLastMonth">вывести всех клиентов, делавших заказы за последний месяц</a></p>
<p><a href="/OrderServlet?action=createOrder">оформить заказ</a></p>
<p><a href="/OrderServlet?action=editOrder&orderId=1">отредактировать заказ</a></p>
<p><a href="/OrderServlet?action=showOrders">вывести список заказов на сумму в указанном диапазоне</a></p>
<p><a href="/OrderServlet?action=showOrdersByPortion">вывести список всех заказов порциями по 5 штук</a></p>

</body>
</html>
