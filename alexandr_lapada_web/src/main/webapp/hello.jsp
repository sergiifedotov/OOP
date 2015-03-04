<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%--
  Created by IntelliJ IDEA.
  User: sanya
  Date: 01.03.2015
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>

<body>
<%
    HashMap<String,String> usersMap = (HashMap<String,String>) request.getAttribute("list");

    Set<Map.Entry<String, String>> set = usersMap.entrySet();

    for (Map.Entry<String, String> map : set) {

        out.print(map.getKey() + ": ");
        out.print(map.getValue()+ "</br>");
    }
%>

</body>
</html>
