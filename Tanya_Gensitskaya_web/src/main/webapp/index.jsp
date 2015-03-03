
<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>

<body>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
     <form action = "/serv" method="GET">

<input type = "submit" value =  "send"/>


<select name = "login">
    <option value = "1"> one </option>
    <option value = "Tanya"> Tanya <option>
    </select>
         <input type = "text" name =  "password"/>
            ${hi}




     </form>

</body>
</html>
