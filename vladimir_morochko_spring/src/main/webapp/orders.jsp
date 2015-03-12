<%@ page import="hw9.taxi.domain.Order" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 09.03.2015
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<html>
<head>
    <title></title>

</head>
<body>
<p><a href="dashboard.jsp"><<< to dashboard</a></p>
<h4>${orderMessage}</h4>
<%
    List<Order> list = (List<Order>) session.getAttribute("orderList");
    String action = (String) session.getAttribute("action");
    boolean editOrder = action != null && action.equals("editOrder");
    out.print(
            "<table border=\"1\">" +
                    "<tr>" +
                    "<th>id</th>" +
                    "<th>client</th>" +
                    "<th>amount</th>" +
                    "<th>addressFrom</th>" +
                    "<th>addressTo</th>");
    if (editOrder) {
        out.print("<th>edit</th>");
    }
    out.print("</tr>");
    for (Order order : list) {
        out.print(
                "<tr>" +
                        "<td>" + order.getId() + "</td>" +
                        "<td>" + order.getClient() + "</td>" +
                        "<td>" + order.getAmount() + "</td>" +
                        "<td>" + order.getAddressFrom() + "</td>" +
                        "<td>" + order.getAddressTo() + "</td>");
        if (editOrder) {
            out.print("<td><a href=\"/orderEditServlet?orderId=" + order.getId() + "\">Править</a></td>");
        }
        out.print("</tr>");
    }
    out.print("</table>");
%>
</body>
</html>
