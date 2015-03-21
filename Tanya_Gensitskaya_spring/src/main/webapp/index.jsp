<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<div class="board">
    <form method="get" action="/hello" id="project">
        <input id="login" class="board" type="text" name="log" value="" size="50"/><br/>
        <input type="password" name="pass" value="" size="50"/><br/>
        <input id="button1" type="submit" value="Send Numbers" size="40"><br/>
    </form>
</div>

<script>
    console.log("Hello script");
    </script>
</body>
</html>
