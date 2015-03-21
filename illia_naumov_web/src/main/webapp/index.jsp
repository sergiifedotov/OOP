<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>vigilant8 taxi</title>
</head>
<body>
<%
    String authMessage = (String) request.getAttribute("authAnswer");
    if(authMessage != null) {
        response.getWriter().print(authMessage);
    }
%>
    <form action = "/authenticator" method = "POST"/>
    <input id="login" type="text" name="login" value="${defaultLogin}" size="30"/><br/>
    <input id="password" type="password" name="password" value="" size="30"/><br/>
    <input id="button" type="submit" value="Войти" size="40">
</body>
</html>
