<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi</title>
</head>

<body>

<form action="/login" method="POST"/>
<table width="100%" style="height: 100%; ">
    <thead></thead>

    <tbody>
    <tr style="height: 5%">
        <td colspan="3" width="100%">TAXI</td>
    </tr>
    <tr style="height: 5%">
        <td colspan="3" width="100%">

        <table width="100%" style="height: 5%;" >
            <thead></thead>
            <tbody>
            <tr>
                <td width="5%">login</td>
                <td width="10%">
                    <input type="text" name="login"/>
                </td>
                <td width="85%">
                    <input type="submit" value="Login"/>
                </td>
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
            </tbody>
        </table>
        </td>
    </tr>
    <tr style="height: 85%">
        <td colspan="3" width="100%">
    </tr>
    <tr style="height: 5%">
        <td colspan="3" width="100%">© 2015 sergey fedotov</td>
    </tr>
    </tbody>

</table>

</form>

</body>
</html>
