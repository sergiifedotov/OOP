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

</body>
</html>
