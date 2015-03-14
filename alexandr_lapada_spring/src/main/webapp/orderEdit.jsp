<%@ page import="java.util.ArrayList" %>
<%@ page import="hw9.taxi.domain.Client" %>
<%@ page import="hw9.taxi.domain.Order" %>
<%--
  Created by IntelliJ IDEA.
  User: sanya
  Date: 12.03.2015
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styleOrder.css">
    <title>Order</title>
</head>
<body>
<table width="100%">
    <tr align="center" height="200px">
        <td><img src="img/header.gif"></td>
    </tr>
    <tr align="center" height="50px">
        <td><h1>Edit order</h1></br> </td>
    </tr>
    <tr align="center">
        <td>
            <h3>Choose order for edit</h3>
            <%
                ArrayList<Order> listOrders = (ArrayList<Order>) request.getAttribute("listOrders");
                if (listOrders != null){
                    out.println("<select id=\"select\" name=\"option\">");
                    for (int i = 0; i < listOrders.size(); i++){
                        out.println("<option value=\""+listOrders.get(i).getId()+"\">"+" "+listOrders.get(i).getClient()+" "
                                +listOrders.get(i).getSumma()+" "+listOrders.get(i).getAddressFrom()+" "
                                +listOrders.get(i).getAddressTo()+"</option>");
                    }
                    out.println("</select>");
                }
            %>
        </td>
    </tr>


</table>
</body>
</html>
