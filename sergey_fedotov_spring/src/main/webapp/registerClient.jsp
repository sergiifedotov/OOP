
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Client</title>
</head>

<body>

<form action="/clientCreate" method="get"/>
<table width="100%" style="height: 100%; ">
    <thead></thead>

    <tbody>
    <tr style="height: 5%">
        <td colspan="3" width="100%">Create Client</td>
    </tr>
    <tr style="height: 5%">
        <td colspan="3" width="100%">
        <table width="100%" style="height: 5%;" >
            <thead></thead>
            <tbody>
            <tr>
                <td width="5%">name</td>
                <td width="10%">
                    <input type="text" name="name"/>
                </td>
                <td width="85%"></td>
            </tr>
            <tr>
                <td width="5%">surname</td>
                <td width="10%">
                    <input type="text" name="surname"/>
                </td>
                <td width="85%"></td>
            </tr>
            <tr>
                <td width="5%">phone</td>
                <td width="10%">
                    <input type="text" name="phone"/>
                </td>
                <td width="85%"></td>
            </tr>
            <tr>
                <td width="5%">address</td>
                <td width="10%">
                    <input type="text" name="address"/>
                </td>
                <td width="85%"></td>
            </tr>
            <tr>
                <td width="5%"></td>
                <td width="10%">
                    <input type="submit" value="create client"/>
                </td>
                <td width="85%"></td>
            </tr>
            <tr>
                <td width="5%"></td>
                <td width="10%">
                    ${rezult}
                </td>
                <td width="85%"></td>
            </tr>
            </tbody>
        </table>
        </td>
    </tr>
    <tr style="height: 85%">
        <td colspan="3" width="100%">
    </tr>
    <tr style="height: 5%">
        <td colspan="3" width="100%">© 2015 sergey fedotov</td>
    </tr>
    </tbody>

</table>

</form>

</body>
</html>
