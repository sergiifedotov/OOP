<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10.03.2015
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Регистрация оператора</title>
    <link rel="stylesheet" type="text/css" href = "css/style.css">
</head>
<body>
        <%
            if(request.getAttribute("answer") != null)
            response.getWriter().print(request.getAttribute("answer"));
        %>
        <h3>Форма для регистрации оператора</h3>
        <form action = "/authorization" method = "POST"/>
        <input type = "text" name = "login" /> Логин<br/>
        <input type = "text" name = "id" /> ID<br/>
        <input type = "password" name = "password" /> Пароль<br/>
        <input type = "password" name = "confirmPassword" /> Подтверждение пароля<br/>
        <input type = "submit" value = "send"/> </form>
</body>
</html>
