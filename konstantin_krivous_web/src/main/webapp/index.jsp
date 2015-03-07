
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>

<style>
    div {
        margin-top: 23%;
    }
</style>

<body>
    <div  align="center">
        <form action="/authentication" method="post">
            <table>
                <tr>
                    <td> <input type="text"  name="login" value="login"></td>
                    <td> <a href="register.jsp"><input type="button" value="Регистрация" style="width:100%"></a></td>
                </tr>
                <tr>
                    <td> <input type="password" name="password" value="значение"></td>
                    <td> <input type="submit" name="enter" value="Войти" style="width:100%"></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>
