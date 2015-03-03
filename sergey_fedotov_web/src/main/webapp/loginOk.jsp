<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 05.10.14
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login OK</title>
</head>

<body>
<table width="100%" style="height: 100%; ">
    <thead></thead>
    <tbody>

    <tr style="height: 5%">
        <td colspan="3" width="100%">Login OK</td>
    </tr>
    <tr style="height: 80%">
        <%
            //ArrayList<String> list = (ArrayList) request.getParameter("list").;
            //int kaka = 12;
            out.println(request.getParameter("list"));
            //clear();
        %>
    </tr>
    <tr style="height: 5%">
        <td colspan="3" width="100%">© 2015 sergey fedotov</td>
    </tr>
    </tbody>
</table>

</body>
</html>
