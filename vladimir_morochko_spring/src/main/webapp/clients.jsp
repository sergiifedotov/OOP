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
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<p><a href="dashboard.jsp"><<< to dashboard</a></p>

<p>Минимальная сумма:</p>

<form action="/clientShowSumServlet">
    <input type="text" name="clientMinSum" value="${clientMinSum}"/>
    <input type="submit" name="show" value="Показать"/>
</form>
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
