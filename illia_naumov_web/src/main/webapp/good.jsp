<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.03.2015
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <p>Hello, dear user!</p>
</body>
</html>
<%
    Map <String,String> map = (Map) request.getAttribute("list");
    for(Map.Entry<String,String>list:map.entrySet()){
        response.getWriter().print(list.getValue() + " ");
    }
%>
