<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<a href="/serv" style="color:Red">serv</a>
<a href="/old/form.jsp">Login</a>
<%--<div class="board">--%>
    <%--<form method="get" action="/test" id="project">--%>
        <%--<input id="login" class="board" type="text" name="login" value="" size="50"/><br/>--%>
        <%--<input type="password" name="pass" value="" size="50"/><br/>--%>
        <%--<input id="button1" type="submit" value="Send Numbers" size="40"><br/>--%>
    <%--</form>--%>
<%--</div>--%>

<div class="board">
    <form method="get" action="/test" id="project">
        <input id="login" class="board" type="text" name="login" value="" size="50"/><br/>
        <input type="password" name="pass" value="" size="50"/><br/>
        <input id="button1" type="submit" value="reg" size="40"><br/>
    </form>
</div>

</body>
</html>
