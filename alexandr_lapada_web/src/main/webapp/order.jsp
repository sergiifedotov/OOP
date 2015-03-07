<%@ page import="hw8.taxi.domain.Client" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: sanya
  Date: 04.03.2015
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>

<table  width="100%">
    <tr height="150px" align="center">
        <td colspan="4"><img src="http://www.nywaterway.com/UserFiles/Images/taxi_sign.gif" align="center" width="500px" height="150px"/></td>
    </tr>
    <tr>
        <td align="center"><h3>Меню оформления заказа</h3></td>
    </tr>
    <tr>
        <td align="center">
            <table border="1">
                <form action="hw8Order" method="post">
                <tr>
                    <td>Date</td>
                    <td><input type="date" name="dateOrder"></td>
                </tr>
                <tr>
                    <td>Client</td>
                    <td>

                        <input type="text" name="clientOrder"></br>

                        <select name="option">
                            <option value="client1">${client1}</option>
                            <option value="2">${client2}</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="priceOrder"></td>
                </tr>
                <tr>
                    <td>Address client</td>
                    <td><input type="text" name="addressOrder"></td>
                </tr>
                <tr>
                    <td>Where to go</td>
                    <td><input type="text" name="whereToGoOrder"></td>
                </tr>
                <tr>
                    <td><input type="submit" name=" Accept "></td>
                    <td><a href="dashboard.jsp">Cancel</a> </td>
                </tr>
                </form>
            </table>
        </td>
    </tr>

</table>

</body>
</html>
