<%@ page import="com.sun.org.apache.bcel.internal.generic.LSTORE" %>
<%@ page import="hw8.taxi.domain.Client" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.03.2015
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
        <form action = "/clientsByPortions" method = "POST"/>
        <input type = "text" name = "portionSize" /> Введите объем порции клиентов<br/>
        <input type = "submit" value = "send"/> </form>
        <p style = "display:block"><%
            if( request.getAttribute("clientsportion") != null){
                List<Client> clients = (List<Client>) request.getAttribute("clientsportion");
                for(Client i: clients){
                    response.getWriter().println(i.getFirstName() + " " + i.getLastName());
                }
        }
        %></p>
</body>
</html>
