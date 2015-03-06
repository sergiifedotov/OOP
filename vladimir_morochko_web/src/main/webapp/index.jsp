<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 03.03.2015
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h>${authenticationResultMessage}</h>
<form action="/AuthenticationServlet" method="post">
    <p>Логин:</p>
    <input type="text" name="login" value="${defaultLogin}"/>
    <p>Пароль:</p>
    <input type="text" name="password" value=""/>
    <br><br>
    <input type="submit" name="register" value="Войти"/>
</form>
<p><a href="registerOperator.jsp">Зарегистрироваться</a></p>
</body>
</html>
