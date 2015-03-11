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
        <td><h2>Login to your cabinet or register</h2></br> </td>
    </tr>
    <tr align="center" height="400px">
        <td>
        <div>
            <form method="post" action="/Authentication" id="project">
                <%
                    if (request.getAttribute("wrongAuth") != null){
                        out.println("<h5>"+request.getAttribute("wrongAuth")+"</h5>");
                    }else {
                        out.println("</br></br></br>");
                    }
                %>
                <input id="login" type="text" name="login" value=""/><br/>
                <input type="password" name="pass" value=""/><br/>
                <input class="button" type="submit" value="login" size="40">
                <button><a href="register.jsp">Register</a></button>
                </form>
        </div>
        </td>
    </tr>
    <tr align="center" height="300px">
        <td></td>
    </tr>
    <tr align="center" height="100px">
        <td>Kiev 2015</td>
    </tr>
</table>


</body>
</html>
