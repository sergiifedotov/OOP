<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/Style.css">
</head>
<body>

<script>
    function func(arg) {
        console.log(arg.innerHTML);
    }
    ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200) {
            console.log('ajax=' + ajax.responseText);
            document.getElementById('log').value = ajax.responseText;
        }
    };

    function clickFirstButton() {
        var login = document.getElementById('login').value;
        if (login == '') {
           alert('Error');
           return false;
       }
    }
    function sendAjax() {
        ajax.open('GET', '/ajax' + '?log=' + document.getElementById('log').value, true);
        ajax.send();
    }
//    var res = func();
    var vector = ['aa', 'bb', 'abc', 'cdef'];
    for (var i = 1; i < vector.length; i++) {
        if (vector[i].length >= vector[0].length) {
            console.log(vector[i]);
        }
    }
</script>

<h2 id="auth" onclick="func(this)">Registration</h2>  <br/>

<input id="log" class="board" type="text" name="login" value="" size="50"/>
<button onclick="sendAjax()">SEND</button>         <br/>

<%--<a href="form.jsp">Form</a>--%>
<div class="board">
    <form method="get" action="/ajax" id="project" onsubmit="return clickFirstButton()">
        <input id="login" class="board" type="text" name="login" value="" size="50"/><br/>
        <input type="password" name="pass" value="" size="50"/><br/>
        <%--<input id="button1" type="submit" value="Send Numbers" size="40"><br/>--%>

    </form>
</div>

<div onclick="clickFirstButton()" id="content">
   <%-- boreder element--%>
</div>

<%--<div style="float: left">
    <p>text1</p>
</div>
<div style="float: right">
    <p>text2</p>
</div>
<div style="float: left">
    <p>text3</p>
</div>--%>

<%--<a href="/serv">serv</a>
<a href="/form.jsp">Login</a>--%>

</body>
</html>
