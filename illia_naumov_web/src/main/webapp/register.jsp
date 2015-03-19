<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10.03.2015
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Регистрация оператора</title>
    <link rel="stylesheet" type="text/css" href = "css/style.css">
</head>
<body>
        <%
            if(request.getAttribute("answer") != null)
            response.getWriter().print(request.getAttribute("answer"));
        %>
        <script>
//            var ajax = new XMLHttpRequest();
//            ajax.onreadystatechange = funtion(){
//
//            }
            function formValidation(){
                if(checklogin()){
                    if(checkID()){
                        if(checkPassword()) {
                            return true;
                        }
                    }
                }
                return false

            }
            function checklogin(){
                var login = document.getElementById("login").value;
                if(login.length < 4 || login.indexOf(' ') >= 0){
                    alert('Логин должен быть не менее 4 символов, не должен содержать пробелы');
                    return false;
                } else {
                    return true;
                }
            }
            function checkID() {
                var id = document.getElementById("id").value;
                var isnum = /^\d+$/.test(id);
                if(!isnum || id.length < 10){
                    alert('идентификационный номер должен состоять из 10 цифр, не иметь букв и других знаков')
                    return false;
            } else {
                    return true;
                }
            }

            function checkPassword(){
                var password = document.getElementById("password").value;
                var passwordConfirmation = document.getElementById("confirm").value;
                if(password.length < 8 || password != passwordConfirmation || !/[a-z]/.test(password) || !/[A-Z]/.test(password) || !/[0-9]/.test(password)){
                    alert('пароль (должен быть не менее 8 символов,включать большие и маленькие буквы, цифры, должен совпадать с подтверждением');
                    return false;
                }
            }

        </script>
        <h3 id = "form">Форма для регистрации оператора</h3>
        <form action = "/authorization" method = "POST">
        <input id = "login" type = "text" name = "login" /> Логин<br/>
        <input id = "id" type = "text" name = "id" /> ID<br/>
        <input id = "password" type = "password" name = "password" /> Пароль<br/>
        <input id = "confirm" type = "password" name = "confirmPassword" /> Подтверждение пароля<br/>

        </form>
        <button  onclick="return formValidation()" value = "register">OK</button>
</body>
</html>
