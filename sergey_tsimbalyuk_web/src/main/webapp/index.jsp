<%--<%@ taglib prefix="context" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="context" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: tsv
  Date: 02.03.15
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<context:property-placeholder location="classpath:/conf.properties"/> --%>
<html>
<head>
    <title>TAXI</title>
    <!--STYLESHEETS-->
    <link href="login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrapper">
    <form name="login-form" class="login-form" action="/auth" method="post">
        <div class="header" align="center">
            <h1>Login</h1>
            <span>${wrong}</span>
        </div>
        <div class="content" align="center">
            <input name="username" type="text" class="input username" value="Username" onfocus="this.value=''" />
            <input name="password" type="password" class="input password" value="Password" onfocus="this.value=''" />
        </div>
        <div class="footer">
            <input type="submit" name="submit" value="Login" class="button" />
            <input type="submit" name="submit" value="Register" class="register" />
        </div>
        <span><a href="register.jsp">register</a></span>
    </form>
</div>
<%--<form action="/auth" method="GET">--%>
    <%--<context:set var="loginTryCount" value="3"/>--%>

    <%--<h3>${wrong}</h3>--%>
    <%--login: <input type="text" name="login" size="20" maxlength="20"><BR>--%>
    <%--pass: <input type="text" name="pass" size="20" maxlength="20">--%>
    <%--<BR><BR><BR>--%>
    <%--<input type="submit" name="submit" value="enter"><BR>--%>
    <%--<a href="register.jsp"> Registration </a>--%>
<%--</form>--%>
 

</body>
</html>
