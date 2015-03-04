<%--
  Created by IntelliJ IDEA.
  User: sanya
  Date: 03.03.2015
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>

</head>


<table cellpadding="1" width="100%" height = "100%">
    <tr width="500">
        <td colspan="2" width="500px" height="150px" align="center">
            <img src="http://www.nywaterway.com/UserFiles/Images/taxi_sign.gif" align="center" width="500px" height="150px"/></br>
            <h1 align="center">Страница регистрации.</h1></br>
        </td>
    </tr>


        <tr>
            <td align="right" width="50%">
                <form action="hw8Register" method="post"/>
                    Логин - <input type = "text" name = "login">  ${wrongNewLogin} ${loginUsed} </br></br>
                    Пароль - <input type = "password" name = "password"></br></br>
                    Подтверждение пароля - <input type = "password" name = "confirmPassword"></br></br>
                    Идентификационный номер - <input type = "text" name = "ident"> ${identNotInt} </br></br>
                    <input type = "submit" value="Ok">
                </form>
                <a href="index.jsp"><button>Cancel</button></a>
            </td>
            <td>

            </td>

        </tr>
        <tr>
            <td>
                AA
            </td>
        </tr>


</table>


<body>

</body>
</html>
