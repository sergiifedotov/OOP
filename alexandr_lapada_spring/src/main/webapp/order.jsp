<%@ page import="java.util.ArrayList" %>
<%@ page import="hw9.taxi.domain.Client" %>
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
    <title>Order</title>
</head>
<body>
<table width="100%">
    <tr align="center" height="200px">
        <td><img src="img/header.gif"></td>
    </tr>
    <tr align="center" height="50px">
        <td><h1>Create order</h1></br> </td>
    </tr>
    <tr align="center">
        <td>
            <table width="80%" border="1">
                <tr height="100px">
                    <td width="20%">Date</td>
                    <td width="20%">Client</td>
                    <td width="20%">Summa</td>
                    <td width="20%">Address from</td>
                    <td width="20%">Address to</td>
                </tr>
                <form action="CreateOrder" method="post">
                <tr height="100px">
                    <td width="20%"><input type="date" value="" name="dateOrder"/></td>
                    <td width="20%">
                        <%
                            ArrayList<Client> listClients = (ArrayList<Client>) request.getAttribute("listClients");
                            if (listClients != null){
                                out.println("<select name=\"option\">");
                                for (int i = 0; i < listClients.size(); i++){
                                    out.println("<option value=\""+listClients.get(i).getId()+"\">"+listClients.get(i).getFirstName()+" "
                                            +listClients.get(i).getLastName()+" "+listClients.get(i).getPhone()+" "
                                            +listClients.get(i).getAddress()+"</option>");
                                }
                                out.println("</select>");
                            }
                        %>
                    </td>
                    <td width="20%"><input type="text" value="" name="summaOrder"/> ${wrongSumma}</td>
                    <td width="20%"><input type="text" value="" name="addressFrom"/></td>
                    <td width="20%"><input type="text" value="" name="addressTo"/></td>
                </tr>
                <tr align="center" height="50px">
                    <td colspan="5">
                        <input type="submit" name="action" value="Ok"/>
                        <input type="submit" name="action" value="Cancel"/>
                    </td>
                </tr>
                </form>
            </table>
        </td>
    </tr>

</table>
</body>
</html>
