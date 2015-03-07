<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 3/8/13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
     <h2>
         <c:out value="Hello ${name}"/>
         <c:forEach var="nout" items="${list}">
             <c:out value="${nout.name}"/>
         </c:forEach>
     </h2>
</body>
</html>