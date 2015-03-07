<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Service</title>
</head>

<body>
<table width="100%" style="height: 100%; ">
    <thead></thead>
    <tbody>

    <tr style="height: 5%">
        <td colspan="3" width="100%">Hello ${login}</td>
    </tr>
    <tr style="height: 5%">
        <td width="5%"></td>
        <td width="10%">
            <a href="order.jsp">Create Order</a>
        </td>
        <td width="85%"></td>
    </tr>
    <tr style="height: 75%">
        <td width="5%"></td>
        <td width="10%">
            <a href="registerClient.jsp">Register Client</a>
        </td>
        <td width="85%"></td>
    </tr>
    <tr style="height: 5%">
        <td colspan="3" width="100%">© 2015 sergey fedotov</td>
    </tr>
    </tbody>
</table>

</body>
</html>
