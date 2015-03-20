<%@ page import="java.util.Map" %>
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
    <script src="index.js" type="text/javascript"></script>
</head>

<body>

<br/>
<h1>
<%--<%--%>
    <%--Map<String, String []> map = request.getParameterMap();--%>
        <%--String login = map.get("login")[0];--%>
    <%--out.println(login + ", приветствуем Вас на нашем сайте !!!\n");--%>
<%--%>--%>
    </h1>
</br>
</br>



<h2>Меню оператора:</h2>


<form action = "registerClient.jsp" method="get">
    <input type = "submit" value =  "зарегистрировать клиента"/>
</form>
<form action = "clients.jsp" method="get">
    <input type = "submit" value =  "вывести всех клиентов порциями по 10 человек"/>
</form>
<form action = "registerClient.jsp" method="get">
    <input type = "submit" value =  "вывести всех клиентов наездивших на сумму больше указанной"/>
</form>
<form action = "registerClient.jsp" method="get">
    <input type = "submit" value =  "вывести всех клиентов, делавших заказы за последний месяц"/>
</form>


<button onclick="show_all_client()">show_all_client</button>
<button onclick="show_all_client_name()">show_all_client_name</button>
<p id='mess.show_all_client'>mess.show_all_client </p>



</body>
</html>
