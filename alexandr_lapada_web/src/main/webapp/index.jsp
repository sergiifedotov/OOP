
<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authenticate</title>
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
            <table border="1">
                <tr>
                    <td colspan="2"><input type = "text" name = "login"/></br> </td>
                </tr>
                <tr>
                    <td colspan="2"><input type = "password" name = "password"/></br> </td>
                </tr>
                <tr>
                    <td height="20%"><input type = "submit" value="login"/></td>
                    <td height="80%"><a href="register.jsp">Register</a></td>
                </tr>
            </table>
            </form>




          </td>
    </tr>

    <tr>
        <td>

        </td>
    </tr>


</table>

</body>
</html>
