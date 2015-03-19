<%--
  Created by IntelliJ IDEA.
  User: Chuvychin
  Date: 14.03.2015
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>

</head>
<body>

  <script>
    var vector = new Array(1,2,3,4,5,6)
    for (i=0;i<vector.length;i++){
      if (vector[i]%2==0){
        vector[i]=0
      }
      document.write(vector[i])
    }

  </script>


</body>
</html>