<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>

<%--
<body>
<table width="90%" border="1" align="center">
    <tr>
        <td width="30%" align="center"><a href="index_example.jsp">Раздел 1</a></td>
        <td width="30%" align="center"><a href="index_example.jsp">Раздел 2</a></td>
        <td width="30%" align="center"><a href="index_example.jsp">Раздел 3</a></td>
    </tr>
    <tr>
        <td colspan="3" align="center">Здесь могла быть ваша реклама</td>
    </tr>

    <tr>
        <td width="25%">Меню 1</td>
        <td rowspan="3" colspan="2" width="65%">
            <form action="/serv" method="GET"/>
            <select name="name">
                <option value="Vasya">Vasya</option>
                <option value="Petya">Petya</option>
                <option value="Kolya">Kolya</option>
            </select>
            <input type="submit" name="login" value="send"/>
            </form>
        </td>
    </tr>

    <tr>
        <td width="25%">Меню 2</td>
    </tr>

    <tr>
        <td width="25%">Меню 3</td>
    </tr>

    <tr>
        <td colspan="3" align="center">Здесь будет копирайт</td>
    </tr>


</table>
--%>

<form action="/serv" method="GET"/>
<select name="name">
    <option value="Vasya">Vasya</option>
    <option value="Petya">Petya</option>
    <option value="Kolya">Kolya</option>
</select>
<input type="password" name="password" value=""/>
<input type="submit" name="login" value="send"/>
</form>


</body>
</html>
