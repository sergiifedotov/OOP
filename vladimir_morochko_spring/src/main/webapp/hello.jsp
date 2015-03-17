<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<p>Hello!</p>

<%
    if (request.getSession(false) == null) {
        request.getRequestDispatcher("index_taxi.jsp").forward(request, response);
    }
%>

</body>
</html>
