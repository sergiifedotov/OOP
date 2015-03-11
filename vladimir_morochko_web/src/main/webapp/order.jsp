<%@ page import="hw8.taxi.domain.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="hw8.taxi.service.ClientServiceImpl" %>
<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 03.03.2015
  форма оформления/редактирования заказа
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${orderMessage}</title>
</head>
<body>
<h4>${orderMessage}</h4>
<p><a href="dashboard.jsp"><<< dashboard</a></p>
<p><a href="/OrderServlet?action=editOrder&orderId=${prevOrderId}"><<< предыдущий заказ  </a>
<a href="/OrderServlet?action=editOrder&orderId=${nextOrderId}">   следующий заказ >>></a></p>
<form action="/OrderServlet">
    <input type="hidden" name="action" value="saveOrder"/>
    <p>Клиент:</p>
<%
    List<Client> list = ClientServiceImpl.clientService.getClients();
    Long defaultClientId = (Long)session.getAttribute("defaultClientId");
    out.print("<select name=\"clientChoice\">");

    for (Client client : list) {
        out.print("<option value=\"" + client.getId() + "\"");
        if (client.getId() == defaultClientId) {
            out.print(" selected");
        }
        out.print(">");
        out.print(client);
        out.print("</option>");
    }
    out.print("</select>");
%>
    <p>Сумма:</p>
    <input type="text" name="amount" value="${defaultAmount}"/><br>
    <p>Адрес подачи:</p>
    <input type="text" name="addressFrom" value="${defaultAddressFrom}"/><br>
    <p>Адрес назначения:</p>
    <input type="text" name="addressTo" value="${defaultAddressTo}"/><br><br>

    <input type="submit" name="register" value="Сохранить!"/>
</form>

</body>
</html>
