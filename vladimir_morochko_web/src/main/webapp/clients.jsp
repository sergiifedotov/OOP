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

<%
    session = request.getSession();
    List<Client> list = (List<Client>) session.getAttribute("clientList");
    response.getWriter().print(
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
        response.getWriter().print(
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
    response.getWriter().print("</table>");
%>
</body>
</html>
