<%--
  Created by IntelliJ IDEA.
  User: tsv
  Date: 14.03.15
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<script language="JavaScript">

var array = new Array(1,2,3,4,5,6)
first = array[0].length
line = ""
for (var i = 1;i< array.length;i++){
    if(first <= array[i].length){
        line= line + array[i]
    }
}
write(line)
</script>
</body>
</html>















//    function revers(revers){
//        var vector=[1,2,5,8,12,7];
//        vector = new Array(revers.length);
//        document.write(revers.length);
//        for(i=0;i<vector.length;i++){
//            document.write(vector[vector.length-i]);
//            vector[revers.length- (revers.length-i)] =   vector2[vector.length-i];
//        }
//        return vector;
//    };