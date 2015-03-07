
<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My First Page</title>

</head>
<table width="100%">
    <thead>

    <tr>
        <td width="33%"> <a href="bye.jsp">Раздел1</a> </td>
        <td width="33%"> <a href="bye.jsp">Раздел2</a> </td>
        <td width="33%"> <a href="bye.jsp">Раздел3</a> </td>
    </tr>
    <tr>
        <td colspan="3"><center><img src="http://tomcat.apache.org/images/tomcat.png"/></center></td>
    </tr>
    <tr>
        <td width="33%">
            <ol>
                <li>
                    ${ключ}

                </li>
                <li>
                </li>
                <li>

                    <form action = "/form" method = "GET"/>

                    <input type = "text" name ="login" value= "login"/></br>


                    <input type = "password" name ="pass" value= "password"/></br>

                    <input type="submit" value ="login"/>
                    </form>

                </li>
                <li>

                </li>
            </ol>
        </td>
        <td colspan="2" width="66%">
            <form action = "/form" method = "GET"/>
            <select name="login">
                    <option value ="Имя1">Имя1</option>
                    <option value ="Имя2">Имя2</option>
                    <option value ="Имя3">Имя3</option>
                    <option value ="Имя4">Имя4</option>


            </select>
            <input type="submit" value ="login"/>
            </form>
        </td>
    </tr>
    <tr>
        <td colspan="3">
           <center> design by Eugen Chyvuchyn 2015</center>
        </td>
    </tr>
    </thead>


</table>

</html>
