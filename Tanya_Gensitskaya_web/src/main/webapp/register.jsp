<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация оператора</title>
</head>

<body>

<h1>Регистрация оператора</h1>

<form action = "/RegisterServlet" method="POST">
    Логин*  ${register} </br>
        <input type = "text" name =  "login"/></br></br>
    Идентификационный номер*</br>
        <input type = "text" name =  "idNumber"/></br></br>
    Пароль*</br>
        <input type = "text" name =  "password"/></br></br>
    Подтверждение пароля*</br>
    <input type = "text" name =  "confirmPassword"/></br></br>

    <input type = "submit" value =  "Регистрация"/>

</form>

<p>
    Рекомендации по регистрации:
</p>
- логин (должен быть не менее 4 символов, не должен содержать пробелы)</br>
- идентификационный номер (10 цифр, без букв и других знаков)</br>
- пароль (должен быть не менее 8 символов,</br>
включать большие и маленькие буквы, цифры, должен совпадать с подтверждением)</br>
<p>



</body>
</html>