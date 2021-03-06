<%@ page import="hw9.taxi.domain.Client" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="hw9.taxi.domain.Order" %>
<%--
  Created by IntelliJ IDEA.
  User: sanya
  Date: 10.03.2015
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="css/styleDashboard.css">
    <title>dashboard</title>
</head>

<body>

<table width="100%">
    <tr align="center" height="200px">
        <td colspan="2"><img src="img/header.gif"></td>
    </tr>
    <tr height="100px" align="center">
        <td colspan="2"><p>${login}</p>${successful}</br><h2>Menu</h2></td>
    </tr>
    </table>
    <table align="center" width="100%" border="1">
    <tr align="center" height="50px">
        <td width="30%">
            <form action="/ShowPortionClient" method="post">
                <input class="buttonMenu" type="submit" value="View all clients by portion 10" name="action"/>
            </form>
        </td>
        <td width="70%" rowspan="8">
            <%
                ArrayList<Client> listPorciaClient = (ArrayList<Client>) request.getAttribute("viewAllClientsByPorcia");
                if (listPorciaClient != null) {
                    out.println("<table border=\"2\" width=\"80%\">");
                    out.println("<tr align=\"center\">");
                    out.println("<td width=\"25%\" align=\"center\">"+"<h3>First name</h3>"+"</td>");
                    out.println("<td width=\"25%\" align=\"center\">"+"<h3>Last name</h3>"+"</td>");
                    out.println("<td width=\"25%\" align=\"center\">"+"<h3>Address</h3>"+"</td>");
                    out.println("<td width=\"25%\" align=\"center\">"+"<h3>Phone</h3>"+"</td>");
                    out.println("</tr>");
                    for (int i = 0; i < listPorciaClient.size(); i++) {
                        out.println("<tr align=\"center\">");
                        out.println("<td width=\"25%\" align=\"center\">"+listPorciaClient.get(i).getFirstName()+"</td>");
                        out.println("<td width=\"25%\" align=\"center\">"+listPorciaClient.get(i).getLastName()+"</td>");
                        out.println("<td width=\"25%\" align=\"center\">"+listPorciaClient.get(i).getAddress()+"</td>");
                        out.println("<td width=\"25%\" align=\"center\">"+listPorciaClient.get(i).getPhone()+"</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    out.println("<form action=/ShowPortionClient method=post>");
                    out.println("<input class=\"buttonIn\" type=\"submit\" value=\"left\" name=\"action\"/>");
                    out.println("<input class=\"buttonIn\" type=\"submit\" value=\"right\" name=\"action\"/>");
                    out.println("</form>");
                }

                String fieldEnterSumm = (String) request.getAttribute("fieldEnterSumm");
                if (fieldEnterSumm != null){
                    if (fieldEnterSumm.equals("summa") ) {
                        out.println("<form action=\"ClientShowGTSumm\" method=\"post\">");
                        out.println("<input id=\"textField\" type=\"text\" name=\"summa\" value=\"\" </br> <input class=\"buttonIn\" type=\"submit\" value=\"Confirm\" name=\"action\"/>");
                        out.println("<form/>");
                    }
                }

                ArrayList<Client> listCliensGTSumma = (ArrayList<Client>) request.getAttribute("listClientsGTSumma");
                if (listCliensGTSumma != null) {
                    out.println("<table border=\"2\" width=\"80%\">");
                    out.println("<tr align=\"center\">");
                    out.println("<td width=\"20%\" align=\"center\">" + "<h3>First name</h3>" + "</td>");
                    out.println("<td width=\"20%\" align=\"center\">" + "<h3>Last name</h3>" + "</td>");
                    out.println("<td width=\"20%\" align=\"center\">" + "<h3>Address</h3>" + "</td>");
                    out.println("<td width=\"20%\" align=\"center\">" + "<h3>Phone</h3>" + "</td>");
                    out.println("<td width=\"20%\" align=\"center\">" + "<h3>Summa</h3>" + "</td>");
                    out.println("</tr>");
                    for (int i = 0; i < listCliensGTSumma.size(); i++) {
                        out.println("<tr align=\"center\">");
                        out.println("<td width=\"20%\" align=\"center\">" + listCliensGTSumma.get(i).getFirstName() + "</td>");
                        out.println("<td width=\"20%\" align=\"center\">" + listCliensGTSumma.get(i).getLastName() + "</td>");
                        out.println("<td width=\"20%\" align=\"center\">" + listCliensGTSumma.get(i).getAddress() + "</td>");
                        out.println("<td width=\"20%\" align=\"center\">" + listCliensGTSumma.get(i).getPhone() + "</td>");
                        out.println("<td width=\"20%\" align=\"center\">" + listCliensGTSumma.get(i).getSumma() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                ArrayList<Client> listCliensByMonth = (ArrayList<Client>) request.getAttribute("listClientByMonth");
                if (listCliensByMonth != null) {
                    out.println("<table border=\"2\" width=\"80%\">");
                    out.println("<tr align=\"center\">");
                    out.println("<td width=\"16%\" align=\"center\">" + "First name" + "</td>");
                    out.println("<td width=\"16%\" align=\"center\">" + "Last name" + "</td>");
                    out.println("<td width=\"16%\" align=\"center\">" + "Address" + "</td>");
                    out.println("<td width=\"16%\" align=\"center\">" + "Phone" + "</td>");
                    out.println("<td width=\"16%\" align=\"center\">" + "Summa" + "</td>");
                    out.println("<td width=\"16%\" align=\"center\">" + "DateLastOrder" + "</td>");
                    out.println("</tr>");
                    for (int i = 0; i < listCliensByMonth.size(); i++) {
                        out.println("<tr width=\"80%\" align=\"center\">");
                        out.println("<td width=\"16%\" align=\"center\">" + listCliensByMonth.get(i).getFirstName() + "</td>");
                        out.println("<td width=\"16%\" align=\"center\">" + listCliensByMonth.get(i).getLastName() + "</td>");
                        out.println("<td width=\"16%\" align=\"center\">" + listCliensByMonth.get(i).getAddress() + "</td>");
                        out.println("<td width=\"16%\" align=\"center\">" + listCliensByMonth.get(i).getPhone() + "</td>");
                        out.println("<td width=\"16%\" align=\"center\">" + listCliensByMonth.get(i).getSumma() + "</td>");
                        out.println("<td width=\"16%\" align=\"center\">" + dateFormat.format(listCliensByMonth.get(i).getDateLastOrder()) + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }

                ArrayList<Order> listPorciaOrder = (ArrayList<Order>) request.getAttribute("viewAllOrdersByPorcia");
                if (listPorciaOrder != null) {
                    out.println("<table border=\"2\" width=\"80%\">");
                    out.println("<tr align=\"center\">");
                    out.println("<td width=\"20%\" align=\"center\">"+"<h3>Date</h3>"+"</td>");
                    out.println("<td width=\"20%\" align=\"center\">"+"<h3>Client ID</h3>"+"</td>");
                    out.println("<td width=\"20%\" align=\"center\">"+"<h3>Address from</h3>"+"</td>");
                    out.println("<td width=\"20%\" align=\"center\">"+"<h3>Adress to</h3>"+"</td>");
                    out.println("<td width=\"20%\" align=\"center\">"+"<h3>Summa</h3>"+"</td>");
                    out.println("</tr>");
                    for (int i = 0; i < listPorciaOrder.size(); i++) {
                        out.println("<tr align=\"center\">");
                        out.println("<td width=\"20%\" align=\"center\">"+listPorciaOrder.get(i).getDateOrder()+"</td>");
                        out.println("<td width=\"20%\" align=\"center\">"+listPorciaOrder.get(i).getClient().getId()+"</td>");
                        out.println("<td width=\"20%\" align=\"center\">"+listPorciaOrder.get(i).getAddressFrom()+"</td>");
                        out.println("<td width=\"20%\" align=\"center\">"+listPorciaOrder.get(i).getAddressTo()+"</td>");
                        out.println("<td width=\"20%\" align=\"center\">"+listPorciaOrder.get(i).getSumma()+"</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    out.println("<form action=/ShowPortionOrder method=post>");
                    out.println("<input class=\"buttonIn\" type=\"submit\" value=\"left\" name=\"action\"/>");
                    out.println("<input class=\"buttonIn\" type=\"submit\" value=\"right\" name=\"action\"/>");
                    out.println("</form>");
                }
            %>
            ${WrongTypeSumm}
            ${EnterData}
        </td>
    </tr>
    <tr align="center" height="67px">
        <td width="30%">
            <form action="ClientShowGTSumm" method="post">
                <input class="buttonMenu" type="submit" value="Show all clients great than summa" name="action"/>
            </form>
        </td>
    </tr>
    <tr align="center" height="67px">
        <td width="30%">
            <form action="ShowClientsByMonth" method="post">
                <input class="buttonMenu" type="submit" value="Show all clients last month" name="action"/>
            </form>
        </td>
    </tr>
    <tr align="center" height="67px">
        <td width="30%">
            <form action="RegisterClient" method="post">
                <input class="buttonMenu" type="submit" value="Register client" name="action"/>
            </form>
        </td>
    </tr>
        <tr align="center" height="67px">
            <td width="30%">
                <form action="CreateOrder" method="post">
                    <input class="buttonMenu" type="submit" value="Create order" name="action"/>
                </form>
            </td>
        </tr>
        <tr align="center" height="67px">
            <td width="30%">
                <form action="EditOrder" method="post">
                    <input class="buttonMenu" type="submit" value="Edit order" name="action"/>
                </form>
            </td>
        </tr>
        <tr align="center" height="67px">
            <td width="30%">
                <form action="" method="post">
                    <input class="buttonMenu" type="submit" value="Show all orders by summa" name="action"/>
                </form>
            </td>
        </tr>
        <tr align="center" height="67px">
            <td width="30%">
                <form action="/ShowPortionOrder" method="post">
                    <input class="buttonMenu" type="submit" value="Show all orders by porcia" name="action"/>
                </form>
            </td>
        </tr>
</table>



</body>
</html>
