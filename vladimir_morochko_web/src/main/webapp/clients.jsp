<%@ page import="java.util.List" %>
<%@ page import="hw8.taxi.domain.Client" %>
<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 03.03.2015
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>clientList</title>
</head>
<body>
<p><a href="dashboard.jsp"><<< dashboard</a></p>
<%--<p>${clientList}</p>--%>
<p>Минимальная сумма:</p>
<form action="/ClientServlet">
    <input type="hidden" name="action" value="showClientsGtSum"/>
    <input type="text" name="clientMinSum" value="${clientMinSum}"/>
    <input type="submit" name="show" value="Показать"/>
</form>
<%
    //session = request.getSession();
    List<Client> list = (List<Client>) session.getAttribute("clientList");
    out.print(
            "<table border=\"1\">" +
                    "<tr>" +
                    "<th>id</th>" +
                    "<th>name</th>" +
                    "<th>surname</th>" +
                    "<th>phone</th>" +
                    "<th>address</th>" +
                    "<th>sum</th>" +
                    "<th>lastOrderDate</th>" +
                    "</tr>");
    for (Client client : list) {
        out.print(
                "<tr>" +
                        "<td>" + client.getId() + "</td>" +
                        "<td>" + client.getName() + "</td>" +
                        "<td>" + client.getSurname() + "</td>" +
                        "<td>" + client.getPhone() + "</td>" +
                        "<td>" + client.getAddress() + "</td>" +
                        "<td>" + client.getSum() + "</td>" +
                        "<td>" + String.format("%tF", client.getLastOrderDate()) + "</td>" +
                        "</tr>"
        );
    }
    out.print("</table>");
%>
</body>
</html>
