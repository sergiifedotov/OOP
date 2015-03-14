<%--
  Created by IntelliJ IDEA.
  User: Chuvychin
  Date: 13.03.2015
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="true" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Dashboard</title>
  <style>
    .fig {
      text-align: center; /* Выравнивание по центру */
      color: aliceblue;
      height: 280px;
    }
    .center {
      text-align: center; /* Выравнивание по центру */
      color: aliceblue;
    }
  </style>
  <link rel="icon" href="img/favicon.ico" type="image/x-icon">
  <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div>
    <%--<form method="get" class="fig">--%>
        <h3>
            <h2>Welcome, ${login}!</h2>
        </h3>
  <%--<br> Ваш идентификационный номер ########## (должен вытягиваться из БД)--%>
  <%--<br> в случае если пользователь пришел со ссылки register.jsp (только что зарегистрировался - написать приветствие о регистрации)--%>
    <%--</form>--%>
        <form method="POST" action="/auth" id="authForm">
            <table id="orders">
                <table style="text-align: left; width: 100%;" border="0" cellpadding="2"
                       cellspacing="2">
                    <tbody>
                    <tr>
                        <td style="vertical-align: top;">orderValOne<br>
                        </td>
                        <td style="vertical-align: top;">orderValTwo</td>
                        <td style="vertical-align: top;">orderValThree</td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">${valOne}<br>
                        </td>
                        <td style="vertical-align: top;">${valTwo}<br>
                        </td>
                        <td style="vertical-align: top;">${valThree}<br>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <form id="logout" method="post" action="/LogOutServlet">
                    <label class="logoutLblPos">
                        <input name="submit2" type="submit" id="submit2" value="log out">
                    </label>
                </form>
                    <p class="center"><a href="index.jsp"> <img src="img/header.jpg"></a></p>


</div>
<br>
<br>

</body>
<%--<footer class = "center"><a href="http://www.facebook.com/chuvendoil">made by Eugen Chyvuchyn © 2015</a></footer>--%>
</html>
