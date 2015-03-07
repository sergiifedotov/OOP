<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 02.03.2015
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<style>
    div {
        margin-top: 23%;
    }
</style>

<body>
    <div  align="center">
        <form action="/register" method="post">
            <table>
                <tr>
                    <td> <input type="text"  name="login" value="login"></td>
                </tr>
                <tr>
                    <td> <input type="text"  name="id" value="id"></td>
                </tr>
                <tr>
                    <td> <input type="text"  name="password" value="password"></td>
                </tr>
                <tr>
                    <td> <input type="text"  name="repeatPassword" value="repeat password"></td>
                </tr>
                <tr>
                    <td> <input type="submit" name="enter" value="Зарегестрироваться" style="width:100%"></td>
                </tr>

            </table>
        </form>
    </div>
</body>
</html>
