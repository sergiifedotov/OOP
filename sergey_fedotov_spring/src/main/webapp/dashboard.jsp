
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
    <form action="/clientShowPortion" method="GET"/>
    <tr style="height: 75%">
        <td width="5%"></td>
        <td width="10%">
            <input type="submit" value="showClientsByPortion"/>
        </td>
        <td width="85%"></td>
    </tr>
    </form>
    <form action="/clientShowSumServlet" method="GET"/>
    <tr style="height: 75%">
        <td width="5%"></td>
        <td width="10%">
            <input type="submit" value="showClientsGtSum"/>
        </td>
        <td width="85%"></td>
    </tr>
    </form>
    <form action="/clientShowMonthServlet" method="GET"/>
    <tr style="height: 75%">
        <td width="5%"></td>
        <td width="10%">
            <input type="submit" value="showClientsLastMonth"/>
        </td>
        <td width="85%"></td>
    </tr>
    </form>
    <tr style="height: 5%">
        <td colspan="3" width="100%">© 2015 sergey fedotov</td>
    </tr>
    </tbody>
</table>

</body>
</html>
