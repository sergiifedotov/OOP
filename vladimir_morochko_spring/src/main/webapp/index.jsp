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
    <h3>Zen Taxi</h3>
    <h4>${authenticationResultMessage}</h4>
    <form method="post" action="/authenticationServlet" id="project">
        <input id="login" type="text" name="login" value="${defaultLogin}"/><br/>
        <input id="password" type="password" name="password" value=""/><br/>
        <input id="button" type="submit" value="Войти">
        <p class='silvertext'> или <a href="registerOperator.jsp">зарегистрироваться</a></p>
    </form>
</div>
<p class='silvertext' align="center">На самом деле нет никакого такси (c)</p><br/>

<p align="center"><a href="index_js.jsp">index_js.jsp</a></p>

</body>
</html>
