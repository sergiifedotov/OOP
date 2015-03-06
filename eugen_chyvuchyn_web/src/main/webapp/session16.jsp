<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: Chuvychin
  Date: 01.03.2015
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session16</title>
</head>
<body>
  <%!

    Map<String, String> list1 = new HashMap<>();
  %>
    <%
    if(request.getAttribute("list") !=null){
              list1 = (HashMap<String,String>) request.getAttribute("list");
            }
      for (String str: list1.keySet()){
       out.println(str + " "+ list1.get(str));
        out.println("</br>");
      }
  %>
</body>
</html>
