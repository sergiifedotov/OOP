<%@ page import="hw8.taxi.dao.ClientDaoImpl" %>
<%@ page import="hw8.taxi.domain.Client" %>
<%@ page import="java.util.List" %>
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
    <link rel="stylesheet" type="text/css" href="index.css">
    <script src="index.js" type="text/javascript"></script>



</head>



<figure class="top">
    <p><img id="img_2"
            src="top.jpg"
            alt=""></p>
</figure>


<%--<form action = "/authenticationServlet" method="POST">--%>
    <p>Логин &nbsp
        <input id= "login"
               type = "text"
               name =  "login"/></p>
    <p>Пароль
        <input id= "password"
               type = "text"
               name =  "password"/></p>
    <p> <input id= "enter"
              type = "submit"
              onclick="check_login_password()"
              value =  "Вход"/> </p>
    <%--<input id= "enter"  type = "submit"  value =  "Вход"/> ${hi}--%>
<%--</form>--%>
<p id='mess.YouAreNotLoggedIn'> </p>
</br>

<p><a href="registerOperator.jsp">Регистрация оператора</a></p>


<button onclick="myFunction()">Try it</button>
<button onclick="show_all_client()">show_all_client</button>
<p id='mess.show_all_client'>mess.show_all_client </p>


</body>
</html>
