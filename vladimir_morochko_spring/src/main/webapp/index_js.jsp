<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<html>
<head>
    <title>Zen Taxi iss da best</title>
</head>
<body>
<%request.getSession().invalidate();%>
<div class="board" align="center">
    <img src="img/header.jpg" height="100" width="100">
    <h3 >Zen Taxi</h3>
    <h4>${authenticationResultMessage}</h4>
    <!--<form method="post" action="/authenticationServlet" id="project" onsubmit="return check();">-->
    <form method="post" action="" id="project">
        <input id="login" type="text" name="login" value="${defaultLogin}"/><br/>
        <input id="password" type="password" name="password" value=""/><br/>

    <%--<input id="button" type="submit" value="Войти">--%>
        <p class='silvertext'> или <a href="registerOperator.jsp">зарегистрироваться</a></p>
    </form>
    <button id="button" value="Войти" onclick="sendAjax()">Залогиниться</button>
</div>
<p class='silvertext' align="center">На самом деле нет никакого такси (c)</p>
<p id="result"></p>

<script>
    // Задание 1
    // Заменить все четные элементы массива на 0
    var array = [1, 2, 3, 4, 5, 6];
    console.log(array);
    //var array = new Array(1, 2, 3, 4, 5, 6);
    for (i = 0; i < array.size; i++) {
        if (array[i] % 2 == 0) {
            array[i] = 0;
        }
    }
    console.log(array);
</script>

<%--<script>--%>
    <%--function check() {--%>
        <%--var login = document.getElementById('login').value;--%>
        <%--console.log(login);--%>
        <%--var password = document.getElementById('password').value;--%>
        <%--console.log(password);--%>
        <%--if (login == '' || login == password) {--%>
            <%--alert('Так нельзя!');--%>
            <%--return false;--%>
        <%--}--%>
        <%--return true;--%>
    <%--}--%>
<%--</script>--%>

<script>
    var ajax = new XMLHttpRequest();
    ajax.onreadystatechange = receiver;

    function receiver() {
//        console.log(ajax);
        if (ajax.readyState == 4 && ajax.status == 200) {
            document.getElementById('result').innerHTML = ajax.responseText;
        }
    }

    function sendAjax() {
        sendString = '?login=' + document.getElementById('login').value +
                '&password=' + document.getElementById('password').value;
        ajax.open('GET', '/authenticationServlet' + sendString, true);
        ajax.send();
    }

</script>

</body>
</html>
