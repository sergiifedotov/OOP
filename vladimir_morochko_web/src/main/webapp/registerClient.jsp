<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 03.03.2015
  форма создания клиента
  Функции:
 - зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>зарегистрировать клиента</title>
</head>
<body>
<h>${registerResultMessage}</h>
<form action="/RegisterServlet"/>
<p>Имя клиента:</p>
<input type="text" name="name" value=""/>

<p>Фамилия клиента:</p><br>
<input type="text" name="surname" value=""/>

<p>Телефон:</p><br>
<input type="text" name="phone" value=""/>

<p>Адрес:</p><br>
<input type="text" name="address" value=""/><br>

<input type="submit" name="register" value="Зарегистрировать!"/>
</form>

</body>
</html>
