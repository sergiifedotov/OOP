<%@ page import="hw9.taxi.domain.Client" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 12.03.2015
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<html>
<head>
    <title>Отредактировать заказ</title>
</head>
<body>

<p><a href="dashboard.jsp"><<< to dashboard</a></p>
<h4>${orderMessage}</h4>
<form action="/orderEditServlet">
    <input type="hidden" name="action" value="saveOrder"/>
    <input type="hidden" name="orderId" value="${orderId}"/>
    <p>Клиент:</p>
    <%
        List<Client> list = (List<Client>) session.getAttribute("clientList");
        Long defaultClientId = (Long)session.getAttribute("defaultClientId");
        out.print("<select name=\"clientChoice\">");
        for (Client client : list) {
            out.print("<option value=\"" + client.getId() + "\"");
            if (client.getId() == defaultClientId) {
                out.print(" selected");
            }
            out.print(">" + client + "</option>");
        }
        out.print("</select>");
    %>
    <p>Сумма:</p>
    <input type="text" name="amount" value="${defaultAmount}"/><br>
    <p>Адрес подачи:</p>
    <input type="text" name="addressFrom" value="${defaultAddressFrom}"/><br>
    <p>Адрес назначения:</p>
    <input type="text" name="addressTo" value="${defaultAddressTo}"/><br><br>
    <input type="submit" name="register" value="Сохранить"/>
</form>
</body>
</html>
