<%--
  Created by IntelliJ IDEA.
  User: Chuvychin
  Date: 13.03.2015
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>CommandProject</title>
  <style>
    .fig {
      text-align: center; /* Выравнивание по центру */
    }
    .footer {
      text-align: center;
      color: aliceblue;
    }
  </style>
  <link rel="icon" href="img/favicon.ico" type="image/x-icon">
  <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div>
  <h3>
    <h2>Welcome, ${login}!</h2>
  </h3>

  <form action="/getUsersList" method="post">
    <table border=0>
      <tr>
        <td>LIST</td>
      </tr>
      <tr>
        <td>
          ${list}
        </td>
      </tr>
    </table>
  </form>

  <table border="0">
    <thead>
    <tr>
      <th>Users List</th>
      <%--<th>CatTwo</th>--%>
      <%--<th>CatThree</th>--%>
      <%--<th>CatFour</th>--%>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${list}">
      <tr>
        ${list}
        <%--<td><c:out value="${list.one}"  /></td>--%>
        <%--<td><c:out value="${list.two}" /></td>--%>
        <%--<td><c:out value="${list.three}" /></td>--%>
        <%--<td><c:out value="${list.four}"  /></td>--%>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<form id="logout" method="post" action="/LogOutServlet">
  <label class="logoutLblPos">
    <input name="submit2" type="submit" id="submit2" value="log out">
  </label>
</form>
<p class="center"><a href="index.jsp"> <img src="img/header.jpg"></a></p>
<footer class = "footer">made by command 2 © 2015</footer>
</body>
</html>
