
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
<!-- comment -->
<%-- JSP comment--%>
<%!
    private String secret;
    private void clear() {

    }
%>

<%
    request.getParameter("list");
    int kaka = 12;
    out.println(kaka);
    out.println(++kaka);
    clear();
%>

<%= kaka + " плохой!"%>

<form action="/form">
    <table>
        <tr>
            <td>Въведете горния логин</td>
            <td>
                <select name="login">
                    <option value="Kaka">Kaka</option>
                    <option value="Sheva">Sheva</option>
                    <option selected="selected" value="family">Женский</option>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login"/></td>
        </tr>
    </table>
</form>
    <h3>Hello Web</h3>
    <p>Parag</p>
    text<br/>
    <center><a href="bye.jsp">Link</a></center>
    <img src=""/>
    <q>Quote</q>
    <ul>
        <li>one</li>
        <li>two</li>
        <li>three</li>
    </ul>

    <ol>
        <li>one</li>
        <li>two</li>
        <li>three</li>
    </ol>

    <table border="1" width="100%">
        <thead>
            <tr>
                <th>1</th>
                <th>2</th>
                <th>3</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td width="33%">11</td>
                <td>12</td>
                <td>13</td>
            </tr>
            <tr>
                <td colspan="3">21</td>
            </tr>
        </tbody>
    </table>
</body>
</html>
