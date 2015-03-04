
<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>

<body>

<table width="100%" height="100%">

    <thead> </thead>
    <tr width="500">
        <td width="500px" height="150px" align="center">
            <img src="http://www.nywaterway.com/UserFiles/Images/taxi_sign.gif" align="center" width="500px" height="150px"/>
        </td>
    </tr>

    <tr>

        <td align="center">
            <h1>Войдите в свой кабинет.</h1></br>
            <form action = /hw8Auth method="post"/>
            ${wrongUser} </br>
            <input type = "text" name = "login"/></br>
            <input type = "password" name = "password"/></br>
            <input type = "submit" value="login"/>
            </form>

            <a href="register.jsp"><button>Register</button></a>

          </td>
    </tr>

    <tr>
        <td>

        </td>
    </tr>


</table>

</body>
</html>
