<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <div>
        <form method="get" action="/login.html" class="login">
            <p>
                <label for="login">Логин:</label>
                <input type="text" name="login" id="login" value="">
            </p>

            <p>
                <label for="password">Пароль:</label>
                <input type="password" name="password" id="password" value="">
            </p>

            <p >
                <button type="submit" class="login-button">Войти</button>
            </p>

            <p><a href="index.jsp">Забыл пароль?</a></p>
            <p><a href="index.jsp">Регистрация</a></p>
        </form>
    </div>

    <footer><a href="http://www.facebook.com/chuvendoil">made by Eugen Chyvuchyn © 2015</a></footer>
    </body>
</html>
