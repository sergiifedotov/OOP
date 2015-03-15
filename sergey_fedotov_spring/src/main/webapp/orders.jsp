<%@ page import="java.util.List" %>
<%@ page import="hw9.taxi.domain.Order" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>

<body>
<table width="100%" style="height: 100%; ">
    <thead></thead>
    <tbody>

    <tr style="height: 5%">
        <td colspan="3" width="100%">Login OK</td>
    </tr>
    <tr style="height: 80%">
        <%
            List<Order> list = (List<Order>) session.getAttribute("list");
            out.println(list);
        %>
    </tr>
    <tr style="height: 5%">
        <td colspan="3" width="100%">© 2015 sergey fedotov</td>
    </tr>
    </tbody>
</table>

</body>
</html>
