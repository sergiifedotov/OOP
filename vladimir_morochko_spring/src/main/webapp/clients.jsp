<%@ page import="hw9.taxi.domain.Client" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 09.03.2015
  Time: 11:00
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
<h4>${clientMessage}</h4>

<%
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
    if (list != null) {
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
    }
%>

</body>
</html>
