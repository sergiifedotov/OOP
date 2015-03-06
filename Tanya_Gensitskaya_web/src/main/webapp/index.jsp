
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
</head>

<body>

<form action = "/authenticationServlet" method="POST">
    <p>Логин &nbsp
        <%--<select name = "login">--%>
            <%--<option value = "1"> Sveta </option>--%>
            <%--<option value = "Tanya"> Tanya <option>--%>
        <%--</select>--%>
        <input type = "text" name =  "login"/>
        ${hi}
    </p>
    <p>Пароль
        <input type = "text" name =  "password"/>
    </p>
    <input type = "submit" value =  "Вход"/>
</form>

<p><a href="register.jsp">регистрация оператора</a></p>


<form action = "/servlet1" method="GET">
    <input type = "submit" value =  "Proverka"/>
</form>
<h3>Hello Web</h3>

<figure class="sign">
    <p><img src="1.jpg" width="150" height="190" alt="Снеговик"></p>
    <figcaption>Cнеговичок-боровичок</figcaption>
</figure>


<table border="1" width="30%">
    <tr>
        <th> <a href="bye.jsp">Menu1</a>  </th>
        <th> <a href="bye.jsp">Menu2</a>  </th>
        <th> <a href="bye.jsp">Menu3</a>  </th>
    </tr>
    <tr>
        <td colspan="3"> Реклама </td>
    </tr>
    <tr>
        <td>
            <ol>
                <li>one</li>
                <li>two</li>
                <li>three</li>
            </ol>
        </td>
        <td>
            <ul>
                <li>one</li>
                <li>two</li>
                <li>three</li>
            </ul>
        </td>
        <td> <q>Hello my tab.!!!</q> </td>
    </tr>
    <tr>
        <td colspan="3">Реклама</td>
    </tr>
</table>


<br/>

Текущее время: <%= new java.util.Date() %> <br/>
Имя вашего порта: <%= request.getLocalPort() %>


</body>
</html>
