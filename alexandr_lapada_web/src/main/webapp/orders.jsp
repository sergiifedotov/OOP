<%@ page import="hw8.taxi.domain.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: sanya
  Date: 03.03.2015
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cabinet</title>
</head>

<body>


<table border="1" width="100%">
    <tr height="150px" align="center">
        <td colspan="4">
            <img src="http://www.nywaterway.com/UserFiles/Images/taxi_sign.gif" align="center" width="500px" height="150px"/>
        </td>
    </tr>
    <tr height="100px" align="center">
        <td colspan="4">
            <h2>Welcome ${welcomeLogin}</h2>
            ${changePass} </br>
        </td>
    </tr>
    <tr height="300px">
        <td width="250px">
            <table border="1" width="100%">
                <tr height="60px" align="center">
                    <td><h3>Меню</h3></td>
                </tr>
                <tr height="60px" align="center">
                    <td>
                        <form action="/hw8Order" method="post">
                            </br>
                            <input type="submit" name="releaseOrder" value="Оформить заказ" style="height: 40"></br>
                        </form>
                    </td>
                </tr>
                <tr height="60px">
                    <td>Редактировать заказ</br> </td>
                </tr>
                <tr height="60px" align="center">
                    <td>
                        <form action="/hw8Order" method="get">
                            </br>
                            <input type="submit" name="listOrderByPrice" value="Вывести список заказов на указанную сумму" style="height: 40"></br>
                        </form>
                    </td>
                </tr>
                <tr height="60px">
                    <td>
                        <form action="/hw8Order" method="get">
                            </br>
                            <input type="submit" name="listOrderByPorcia" value="Вывести список всех заказов по 5 штук" style="height: 40"></br>
                        </form>
                    </td>
                </tr>
                <tr height="60px">
                    <td>Зарегестрировать клиента</td>
                </tr>
                <tr height="60px">
                    <td>Вывести всех клиентов порциями по 10</td>
                </tr>
                <tr height="60px">
                    <td>Вывести клиентов наездивших на сумму больше указаной </td>
                </tr>
                <tr height="60px">
                    <td>Вывести клиентов делавших заказы в последний месяц </td>
                </tr>
            </table>

        </td>
        <td>
            <%
                List<Client> listPorcia = (ArrayList<Client>)request.getAttribute("listPorcia");
                if (listPorcia != null){
                    for (int i = 0; i < listPorcia.size(); i++){
                        out.println(listPorcia.get(i).getFirstName()+" "+listPorcia.get(i).getLastName()+"</br>");
                    }
                    listPorcia = null;
                }
            %>
            <form action="/hw8Order" method="get">
                <input type="submit" name="left" value="<<<">
                <input type="submit" name="right" value=">>>">
            </form>

        </td>

    </tr>
    <tr  height="450px">
        <td colspan="4">

        </td>
    </tr>

</table>


</body>
</html>