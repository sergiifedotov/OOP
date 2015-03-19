<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax Authorization</title>
    <script>
      ajax = new XMLHttpRequest();
    </script>
</head>
<body>
<script>
    var request = new XMLHttpRequest();
    function fun() {
        request.onreadystatechange = function () {
            if (request.readyState == 4 && request.status == 200) {
                document.getElementById("result").value = request.responseText;
            }
        }
        var login = document.getElementById("login").value;
        var password = document.getElementById("password").value;
        request.open("GET", "/hello?login=" + login + "&password=" + password, true)
        request.send();
    }
    ;
</script>
<div>
    <form action="/hello" method="GET">
        <input id='login' type="text" name="login">
        <input id='password' type="text" name="password">
        </br>
        <input id='result' type="text" name="password">
    </form>
    <button onclick="fun()">Send</button>
</div>
<table>
    <tr>
        <td>

        </td>
    </tr>
</table>
</body>
</html>