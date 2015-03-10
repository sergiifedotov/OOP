<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>

<body>

<form action="/auth" method="POST"/>
<table width="100%" style="height: 100%; ">
    <thead></thead>

    <tbody>
    <tr style="height: 5%">
        <td colspan="3" width="100%">Registration</td>
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
