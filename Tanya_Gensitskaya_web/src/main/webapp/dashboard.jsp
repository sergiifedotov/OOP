<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Good Reguards</title>
</head>

<body>

<br/>

<%
    Map<String, String []> map = request.getParameterMap();
        String login = map.get("login")[0];
    out.println(login + ", приветствуем Вас на нашем сайте !!!\n");
%>
</br>
</br>







</body>
</html>
