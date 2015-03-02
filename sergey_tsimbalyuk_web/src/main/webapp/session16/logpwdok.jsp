<%--
  Created by IntelliJ IDEA.
  User: tsv
  Date: 01.03.15
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page import="java.util.Map" %>--%>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logins / passwords list</title>
</head>
<body>
<%!
    HashMap<String, String> list = new HashMap<>();
%>
<%
    if (request.getAttribute("list") != null) {
        list = (HashMap<String, String>) request.getAttribute("list");
    }
%>
<table border="1">
    <tr>
        <%
            for (String s : list.keySet()) {
                out.println("<tr><td>" + s + "</td><td>" + list.get(s) + "</td></tr>");
            }
        %>
    </tr>
</table>
</br>
<button onclick="goBack()">Go Back</button>
<script>
    function goBack() {
        window.history.back()
    }
</script>
</body>
</html>
