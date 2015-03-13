<%--

--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
<div class="wrapper">
    <h3>
        Registration
    </h3>

    <div class="header">
        <img src="img/header.jpg"/>
    </div>

    <form action="/register" method="POST"/>
    <table width="100%" style="height: 100%; ">
        <thead></thead>

        <tbody>

        <tr>
            <td width="5%">login</td>
            <td width="10%">
                <input type="text" name="login"/>
            </td>
            <td width="85%"></td>
        </tr>
        <tr>
            <td width="5%">identification code</td>
            <td width="10%">
                <input type="text" name="id"/>
            </td>
            <td width="85%"></td>
        </tr>
        <tr>
            <td width="5%">pass</td>
            <td width="10%">
                <input type="password" name="pass"/>
            </td>
            <td width="85%">
                ${errLogin}
            </td>
        </tr>
        <tr>
            <td width="5%">pass confirmation</td>
            <td width="10%">
                <input type="password" name="passConfirmation"/>
            </td>
            <td width="85%">
                ${errLogin}
            </td>
        </tr>
        <tr>
            <td width="5%"></td>
            <td width="10%">
                <input type="submit" value="Register"/>
            </td>
            <td width="85%"></td>
        </tr>


        </tbody>

    </table>

    </form>

</div>

<div class="footer">
    © 2015 sergey fedotov
</div>
</body>
</html>
