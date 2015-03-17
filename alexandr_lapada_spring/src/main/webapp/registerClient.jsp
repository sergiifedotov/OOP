<%--
  Created by IntelliJ IDEA.
  User: sanya
  Date: 12.03.2015
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styleRegisterClient.css">
    <title>RegisterClient</title>
</head>
<body>
<table width="100%">
    <tr height="200px" align="center">
        <td colspan="4"><img src="img/header.gif"></td>
    </tr>
    <tr height="200px" align="center">
        <td colspan="4"><h2>Register client</h2></td>
    </tr>
    <form action="RegisterClient" method="post">
        <tr height="50px" align="center">
            <td width="45%" rowspan="5"></td>
            <td width="5%"><div>First name</div></td>
            <td width="5%"><input class="textField" type="text" value="" name="firstName"/></td>
            <td width="45%"></td>
        </tr>
        <tr height="50px" align="center">
            <td width="5%"><div class="divStr">Last name</div></td>
            <td width="5%"><input class="textField" type="text" value="" name="lastName"/></td>
            <td width="45%"></td>
        </tr>
        <tr height="50px" align="center">
            <td width="5%"><div>Phone</div></td>
            <td width="5%"><input class="textField" type="text" value="" name="phone"/></td>
            <td width="45%"></td>
        </tr>
        <tr height="50px" align="center">
            <td width="5%"><div>Address</div></td>
            <td width="5%"><input class="textField" type="text" value="" name="address"/></td>
            <td width="45%"></td>
        </tr>
        <tr height="50px" align="center">
            <td width="5%" align="right"><input class="button" type="submit" value="Ok" name="action"/></td>
            <td width="5%" align="left"><input class="button" type="submit" value="Cancel" name="action"/></td>
            <td width="45%"></td>
        </tr>
    </form>

</table>

</body>
</html>
