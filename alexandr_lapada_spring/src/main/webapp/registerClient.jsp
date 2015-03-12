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
<table border="1" width="100%">
    <tr height="200px" align="center">
        <td colspan="2"><img src="img/header.gif"></td>
    </tr>
    <tr height="200px" align="center">
        <td colspan="2"><h2>Register client</h2></td>
    </tr>
    <form action="RegisterClient" method="post">
        <tr height="50px" align="center">
            <td width="50%"><div>First name</div></td>
            <td width="50%"><input class="textField" type="text" value="" name="firstName"/></td>
        </tr>
        <tr height="50px" align="center">
            <td width="50%"><div class="divStr">Last name</div></td>
            <td width="50%"><input class="textField" type="text" value="" name="lastName"/></td>
        </tr>
        <tr height="50px" align="center">
            <td width="50%"><div>Phone</div></td>
            <td width="50%"><input class="textField" type="text" value="" name="phone"/></td>
        </tr>
        <tr height="50px" align="center">
            <td width="50%"><div>Address</div></td>
            <td width="50%"><input class="textField" type="text" value="" name="address"/></td>
        </tr>
        <tr height="50px" align="center">
            <td width="50%"><input class="button" type="submit" value="Ok" name="action"/></td>
            <td width="50%"><input class="button" type="submit" value="Cancel" name="action"/></td>
        </tr>
    </form>

</table>

</body>
</html>
