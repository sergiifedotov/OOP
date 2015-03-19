<%--
  Created by IntelliJ IDEA.
  User: tsv
  Date: 15.03.15
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="../js/loginCheck.js"></script>
    <meta http-equiv="content-type" content="text/html;" />
</head>
<body  onload="document.testForm.content.value = theElement.innerHTML;">
<script>
    <!--
    var theElement = document.getElementById("div");
    //-->
</script>
<div>
    <form action="/test" method="post" onsubmit="return loginCheck()">
        <input type="text" value="" name="login" id="login"><p id="loginInfo" style="color: #ff0000"></p></br>
        <input type="text" value="" name="passwd" id="passwd"><p id="passwordInfo" style="text-decoration-color: #ff0000"></p></br>
        <input type="submit" value="send">
    </form>
</div>

</body>
</html>
