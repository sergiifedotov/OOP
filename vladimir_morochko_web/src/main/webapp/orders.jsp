<%@ page import="hw8.taxi.domain.Order" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 03.03.2015
  список заказов
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>orderList</title>
</head>
<body>
<p><a href="dashboard.jsp"><<< dashboard</a></p>

<form action="/OrderServlet">
    <input type="hidden" name="action" value="showOrders"/>
    <p>Минимальная сумма:
    <input type="text" name="lowerLimit" value="${lowerLimit}"/></p>
    <p>Максимальная сумма:
    <input type="text" name="upperLimit" value="${upperLimit}"/></p><br>
    <input type="submit" name="show" value="Показать"/>
</form>

<%
    //session = request.getSession();
    List<Order> list = (List<Order>) session.getAttribute("orderList");
    out.print(
            "<table border=\"1\">" +
                    "<tr>" +
                    "<th>id</th>" +
                    "<th>client</th>" +
                    "<th>amount</th>" +
                    "<th>addressFrom</th>" +
                    "<th>addressTo</th>" +
                    "</tr>");
    for (Order order : list) {
        out.print(
                "<tr>" +
                        "<td>" + order.getId() + "</td>" +
                        "<td>" + order.getClient() + "</td>" +
                        "<td>" + order.getAmount() + "</td>" +
                        "<td>" + order.getAddressFrom() + "</td>" +
                        "<td>" + order.getAddressTo() + "</td>" +
                        "</tr>"
        );
    }
    out.print("</table>");
%>
</body>
</html>
