<%@ page import="dreamteam.domain.Client" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<html>
<head>
    <title>Users</title>
</head>
<body>

<%
    ArrayList<Client> listPorciaClient = (ArrayList<Client>) request.getAttribute("clientList");
    if (listPorciaClient != null) {
        out.println("<table border=\"2\" width=\"80%\">");
        out.println("<tr align=\"center\">");
        out.println("<td width=\"25%\" align=\"center\">"+"<h3>First name</h3>"+"</td>");
        out.println("<td width=\"25%\" align=\"center\">"+"<h3>Last name</h3>"+"</td>");
        out.println("<td width=\"25%\" align=\"center\">"+"<h3>Address</h3>"+"</td>");
        out.println("<td width=\"25%\" align=\"center\">"+"<h3>Phone</h3>"+"</td>");
        out.println("</tr>");
        for (int i = 0; i < listPorciaClient.size(); i++) {
            out.println("<tr align=\"center\">");
            out.println("<td width=\"25%\" align=\"center\">"+listPorciaClient.get(i).getName()+"</td>");
            out.println("<td width=\"25%\" align=\"center\">"+listPorciaClient.get(i).getSurname()+"</td>");
            out.println("<td width=\"25%\" align=\"center\">"+listPorciaClient.get(i).getAddress()+"</td>");
            out.println("<td width=\"25%\" align=\"center\">"+listPorciaClient.get(i).getPhone()+"</td>");
            out.println("</tr>");
        }
        out.println("</table>");

    }
%>
<form action="clientShowPortionServlet" method="post">
    <input type="submit" name="action" value="Ok"/>
</form>

</body>
</html>