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
