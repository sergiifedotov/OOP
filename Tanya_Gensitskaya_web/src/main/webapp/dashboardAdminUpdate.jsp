<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Редактирование данных</title>
  <script src="dashboardAdminUpdate.js" type="text/javascript"></script>
</head>

<body>

<h1>Редактирование данных оператора</h1>

<p><input id="operator_id" type="text" name="login"/>OPERATOR_ID (для редактирования)</p>
<p><input type="submit" value="Вывести оператора" onclick="readOperator()"/></p>

<p><input id="login" type="text" name="login"/>LOGIN</p>
<p><input id="password" type="text" name="password"/>PASSWORD</p>
<p><input id="conf_password" type="text" name="conf_password"/>CONF_PASSWORD</p>
<p><input id="id_num" type="text" name="id_num"/>ID_NUM</p>
<p><input id="is_blocked" type="text" name="is_blocked"/>IS_DLOCKED</p>
<p><input id="is_administrator" type="text" name="is_administrator"/>IS_ADMINISTRATOR</p>
<p><input type="submit" value="Обновить данные" onclick="updateOperator()"/></p>

<p id="updateOutput">Result of update:</p>

<p><input type="submit" value="вернуться к главному меню" onclick="backToMainMenu()"/></p>



<p>Рекомендации по обновлению данных оператора:</p>
<pre>
- логин (должен быть не менее 4 символов, не должен содержать пробелы)
- идентификационный номер (10 цифр, без букв и других знаков)
- пароль (должен быть не менее 8 символов,
включать большие и маленькие буквы, цифры, должен совпадать с подтверждением)
</pre>



</body>
</html>