<%@ page import="java.util.Map" %>
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
  <script src="dashboardAdmin.js" type="text/javascript"></script>
</head>

<body>

<h2>Меню администратора:</h2>

<button onclick="addOperator()">добавить оператора</button>
<button onclick="showAllOperator()">посмотреть всех операторов</button>
<button onclick="updateOperator()">редактировать оператора</button>
<button onclick="exit()">выход</button>


</body>
</html>
