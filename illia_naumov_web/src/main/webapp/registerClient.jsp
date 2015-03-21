<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10.03.2015
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация клиента</title>
</head>
<body>
<form action="/authorization" method="POST">
    <p id = "answer"></p>
    <input id="login" type="text" name="login"/> Логин<br/>
    <input id="id" type="text" name="id"/> ID<br/>
    <input id="password" type="password" name="password"/> Пароль<br/>
    <input id="confirm" type="password" name="confirmPassword"/> Подтверждение пароля<br/>
    <input type = "submot" value = "Register Client"/>
    <%--<input type = "submit" value = "Register"/>--%>
</form>
</body>
</html>
