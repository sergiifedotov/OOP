<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styleRegister.css">
    <title>register</title>
</head>
<body>
<table width="100%">
    <tr align="center" height="200px">
        <td colspan="4"><img src="img/header.gif"></td>
    </tr>
    <tr height="100px" align="center">
        <td colspan="4"><p>Registration form</p></td>
    </tr>
    <form action="/Register" method="post">
        <tr height="50px" align="center">
            <td rowspan="5" width="40%"></td>
            <td width="10%"><div class="divStr">Login - </div></td>
            <td width="10%"><input type="text" name="newLogin" value=""/></td>
            <td width="40%" align="left">${wrongLogin}</td>
        </tr>
        <tr height="50px" align="center">
            <td width="10%"><div class="divStr">New password - </div></td>
            <td width="10%"><input type="password" name="newPassword" value=""/></td>
            <td width="40%" align="left">${wrongPass}</td>
        </tr>
        <tr height="50px" align="center">
            <td width="10%"><div class="divStr">Confirm password - </div></td>
            <td width="10%"><input type="password" name="confPassword" value=""/></td>
            <td width="40%" align="left">${wrongEqPass}</td>
        </tr>
        <tr height="50px" align="center">
            <td width="10%"><div class="divStr">Identification number - </div></td>
            <td width="10%"><input type="text" name="identNumber" value=""/></td>
            <td width="40%" align="left">${wrongId}</td>
        </tr>
        <tr height="60px" align="center">
            <td width="10%" align="right"><input class="button" type="submit" value="Ok"/></td>
            <td width="10%" align="left"><button class="button" value="Cancel" name="actionButton"><a href="index.jsp">Cancel</a></button></td>
            <td width="40%" align="left"></td>
        </tr>
    </form>


</table>
</body>
</html>
