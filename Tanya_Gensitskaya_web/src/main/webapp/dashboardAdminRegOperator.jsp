<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Страница администратора</title>
  <script src="dashboardAdmin.js" type="text/javascript"></script>
</head>

<body>

<h1>Регистрация оператора</h1>

<p>Логин*</br>
  <input id="login" type="text" name="login"/></p>
<p> Идентификационный номер*</br>
  <input id="idNumber" type="text" name="idNumber"/> </p>
<p> Пароль*</br>
  <input id="password" type="password" name="password"/></p>
<p> Подтверждение пароля*</br>
  <input id="confirmPassword" type="password" name="confirmPassword"/></p>
<p>
  <input type="submit" value="Регистрация" onclick="registrOperator()"/></p>
<p>Result of registration:</p>
<p  id="registrOutput"></p>
<p>
<input type="submit" value="вернуться к главному меню" onclick="backToMainMenu()"/></p>



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