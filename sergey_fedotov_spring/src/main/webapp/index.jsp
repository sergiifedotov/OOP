<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <title>Taxi</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<script>
    var vector = new Array(1,2,3,4,5,6)
    console.log('Исходный массив')
    for(i=0;i<vector.length;i++){
        console.log(vector[i])
    }
    for(i=0;i<vector.length;i++){
        if(vector[i]%2===0){
            vector[i]=0
        }
    }
    console.log('Новый массив')
    for(i=0;i<vector.length;i++){
        console.log(vector[i])
    }

    function check(){
        var login = document.getElementById('login').valueOf();
        var pass = document.getElementById('pass').valueOf();

        if(login===pass){
            alert('error login=pass')
            return false
        }

        return true
    }

</script>

<div class="wrapper">

    <h3>
        TAXI
    </h3>

    <div class="header">
        <img src="img/header.jpg"/>
    </div>
    <form onsubmit='return check();' action="/auth" method="POST"/>
    <table width="100%" style="height: 5%;" >
        <thead></thead>
        <tbody>
        <tr>
            <td width="5%">login</td>
            <td width="10%">
                <input id="login" type="text" name="login"/>
            </td>
            <td width="85%"></td>
        </tr>
        <tr>
            <td width="5%">pass</td>
            <td width="10%">
                <input id="pass" type="password" name="pass"/>
            </td>
            <td width="85%">
                ${errLogin}
            </td>
        </tr>
        <tr>
            <td width="5%"></td>
            <td width="10%">
                <input type="submit" value="Login"/>
            </td>
            <td width="85%"></td>
        </tr>
        <tr>
            <td width="5%"></td>
            <td width="10%">
                <a href="register.jsp">registration</a>
            </td>
            <td width="85%"></td>
        </tr>
        </tbody>
    </table>
    </form>
    <div class="content">
        Компания «TAXI» предлагает жителям и гостям столицы качественное обслуживание! Слова «дешевое такси» применимы лишь к стоимости проезда, а уровень комфорта всегда остается высоким.</br>

        Мы не раз доказывали, что наши услуги в некоторых ситуациях могут оказаться бесценными. С нашей компанией сделать заказ такси в Киеве очень просто, удобно и доступно каждому, так как существует короткий номер 111 с мобильного (callback). Также вы можете осуществить заказ круглосуточно по короткому номеру 1111 или же, сделать заказ такси online на нашем сайте.</br>

        Как показывает практика, для наших клиентов Киев становится городом без суеты и лишних волнений. Тут нет никакого секрета и волшебства, все просто – пользуясь услугами нашей информационной службы такси, Вы будете оказываться в нужном месте в точно обозначенный срок.</br>

        Компания серьезно подходит к подбору сотрудников. Водители нашей службы – профессионалы, имеющие серьезный стаж столичной езды, они всегда вежливы и корректны, превосходно знают всю систему хитросплетений киевских улиц и способны доставить Вас точно в срок, минуя киевские пробки.</br>

        Также вы можете оставлять свои пожелания и комментарии к нашей работе, для нас это очень важно. Будьте уверены, все это не зря и будет отражаться на работе компании. Информационная служба такси в Киеве «TAXI» ценит своих клиентов и с каждым годом улучшает качество обслуживания, расширяя список услуг.</br>

        Мы гордимся нашей командой профессионалов, наши операторы никогда не оставят Ваш заказ без внимания, а водители доставят Вас по нужному адресу в четко установленные сроки.</br>
    </div>
</div>

<div class="footer">
    © 2015 sergey fedotov
</div>

</body>
</html>
