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

<form action = "/RegisterServlet" method="GET">
    <label>Логин*  ${register} </br>
        <input type = "text" name =  "login"/></br></br>
        </label>
    <label>
    Идентификационный номер*</br>
     <input type = "text" name =  "idNumber"/></br></br>
        </label>
    <label>
    Пароль*</br>
        <input type = "password" name =  "password"/></br></br>
        </label>
    <label>Подтверждение пароля*</br>
    <input type = "password" name =  "confirmPassword"/></br></br>
        </label>
    <input type = "submit" value =  "Регистрация"/>

</form>

<p>
    Рекомендации по регистрации:
</p>
<pre>
- логин (должен быть не менее 4 символов, не должен содержать пробелы)
- идентификационный номер (10 цифр, без букв и других знаков)
- пароль (должен быть не менее 8 символов,
включать большие и маленькие буквы, цифры, должен совпадать с подтверждением)
</pre>



</body>
</html>