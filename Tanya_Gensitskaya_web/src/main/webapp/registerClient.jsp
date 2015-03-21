<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Регистрация клиента</title>
</head>

<body>

<h1>Регистрация клиента</h1>

<form action = "/ClientServlet" method="GET">
  <p>
    ${client}
  </p>
  имя*  </br>
  <input type = "text" name="name"/></br></br>
  фамилия*</br>
  <input type = "text" name="lastName"/></br></br>
  телефон*</br>
  <input type = "text" name="phone"/></br></br>
  адрес*</br>
  <input type = "text" name="address"/></br></br>
  сумма*</br>
  <input type = "text" name="money"/></br></br>
  дата последнего заказа (dd.mm.yyyy)*</br>
  <input type = "text" name =  "date"/></br></br>
  <input type = "submit" value =  "зарегистрировать"/>
</form>

<form action = "dashboard.jsp" method="get">
  <input type = "submit" value =  "Вернуться к главному меню"/>
</form>



</body>
</html>