<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<html>
<head>
    <title></title>
</head>
<body>
<%request.getSession().invalidate();%>
    <h4>${authenticationResultMessage}</h4>
<table width="100%">

    <tr align="center" height="50px">
        <td></td>
    </tr>
    <tr align="center">
        <td>
            <div>
                <table width="22%">
                    <form method="post" action="/authenticationServlet" id="project">
                        <tr height="50px">
                            <td width="60%" align="left"><p>Login</p></td>
                            <td width="40%"><input id="login" type="text" name="login" value="${defaultLogin}"/><br/></td>
                        </tr>
                        <tr height="50px">
                            <td width="60%" align="left"><p>Password</p></td>
                            <td width="40%"><input type="password" name="pass" value=""/><br/></td>
                        </tr>
                        <tr height="50px" align="center">
                            <td colspan="2"><input class="button" type="submit" value="login"></td>
                        </tr>
                    </form>
                </table>
            </div>
            <table width="20%" height="50px">
                <tr height="50px" align="center">
                    <td width="50%"></td>
                </tr>
            </table>
        </td>
    </tr>
</table>

</body>
</html>
