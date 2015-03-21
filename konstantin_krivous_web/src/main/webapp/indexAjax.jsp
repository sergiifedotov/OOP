<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 15.03.2015
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <style>
        div {
            margin-top: 23%;
        }
    </style>
</head>
<body>

    <script>
        function start() {
            var ajax = new XMLHttpRequest()
            ajax.open('GET000', '/ajax', true);
            ajax.send();


            ajax.onreadystatechange = function() {
                if (ajax.readyState == 4 && ajax.status == 200) {
                    var mes = document.getElementById("finMessage");
                    mes.innerHTML = ajax.responseText;
                }
            };
        }
    </script>

    <div  align="center">
         <input type="button" value="Я здесь!" onclick='start()'/>
         <span id="finMessage" style="color: #ff0000"></span>
    </div>

</body>
</html>
