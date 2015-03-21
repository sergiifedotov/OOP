<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <%--<link rel="stylesheet" href="css/style.css">--%>
    <style type="text/css">
        div, p {
            border: 1px solid black;
            border-radius: 20px 0px 20px 0px;
        }
        p.wertu+p {
            background-color: #aaaaaa;
        }
        [href=eee] {
            font-size: xx-large;
        }
        div>form {
            background-color: aqua;
            height:200px;
            width: 400px;
            position: absolute;
            display: none;
        }
    </style>
</head>
<body>
<span onclick="print('Click')">Text</span>
    <script>
        var xmlhttp = new XMLHttpRequest();

        function send() {
            xmlhttp.onreadystatechange=function() {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)  {
                    document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
                    var body = document.getElementsByTagName("body")[0];
                    var table = document.createElement("table");
                    var row = document.createElement("tr");
                    var td1 = document.createElement("td");
                    td1.appendChild(document.createTextNode("column 1"));
                    var td2 = document.createElement("TD");
                    td2.appendChild (document.createTextNode("column 2"));
                    row.appendChild(td1);
                    row.appendChild(td2);
//                    var htmlElement = document.createElement("tr");
//                    var td = document.createElement("td");
//                    td.appendChild(document.createTextNode('dfdf'))
                    table.appendChild(row);
//                    body.appendChild(row);
                    body.appendChild(table);
                }
            }

            xmlhttp.open("GET","/ajax?name=value",true);
            xmlhttp.send();
            return false;
        }
    </script>


<div id="myDiv"></div>
<div>
    <span>
            <input id="login" class="board" type="text" name="log" value="" size="50"/><br/>
            <input type="password" name="pass" value="" size="50"/><br/>
            <button onclick="send()">Login</button>
    </span>
</div>

</body>
</html>
