<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<html>
<head>
    <title></title>
</head>
<body>
<%request.getSession().invalidate();%>
<p> Перейти на <a href="index_taxi.jsp">index_taxi.jsp</a></p>
<p> или на <a href="index_js.jsp">index_js.jsp</a></p>

</body>
</html>
