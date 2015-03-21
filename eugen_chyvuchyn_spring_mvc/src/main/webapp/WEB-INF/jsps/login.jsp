<%--
  Created by IntelliJ IDEA.
  User: Chuvychin
  Date: 21.03.2015
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Тут должен быть список</title>
</head>
<body>
<c:out value="${list}"/>
<c:forEach var="user" items="${list}">
    <c:out value="${user}"/><br/>
</c:forEach>
</body>
</html>
