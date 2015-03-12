<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styleIndex.css">


</head>

<body>

<table width="100%">
    <tr align="center" height="200px">
        <td><img src="img/header.gif"></td>
    </tr>
    <tr align="center" height="50px">
        <td><h1>Login to your cabinet or register</h1></br> </td>
    </tr>
    <tr align="center" height="50px">
        <td>
                <%
                    if (request.getAttribute("wrongAuth") != null){
                        out.println("<h2>"+request.getAttribute("wrongAuth")+"</h2>");
                    }else {
                        out.println("</br></br></br>");
                    }
                %>
        </td>
    </tr>
    <tr align="center">
        <td>
            <div>
            <table width="22%">
                <form method="post" action="/Authentication" id="project">
                    <tr height="50px">
                        <td width="60%" align="left"><p>Login</p></td>
                        <td width="40%"><input id="login" type="text" name="login" value=""/><br/></td>
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
                    <td width="50%"><a href="register.jsp">-Register-</a></td>
                </tr>
            </table>

        </td>
    </tr>
</table>

<table width="100%">
    <tr align="center" height="300px">
        <td></td>
    </tr>
    <tr align="center" height="100px">
        <td>Kiev 2015</td>
    </tr>
</table>


</body>
</html>
