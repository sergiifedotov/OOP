
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Order</title>
</head>

<body>

<form action="/OrderServlet" method="POST"/>
<table width="100%" style="height: 100%; ">
    <thead></thead>

    <tbody>
    <tr style="height: 5%">
        <td colspan="3" width="100%">Create Order</td>
    </tr>
    <tr style="height: 5%">
        <td colspan="3" width="100%">

            "date=" + date +
            ", client=" + client +
            ", sum=" + sum +
            ", addressFrom='" + addressFrom + '\'' +
            ", addressTo='" + addressTo + '\'' +

        <table width="100%" style="height: 5%;" >
            <thead></thead>
            <tbody>
            <tr>
                <td width="5%">date</td>
                <td width="10%">
                    <input type="date" name="date"/>
                </td>
                <td width="85%"></td>
            </tr>
            <tr>
                <td width="5%">client</td>
                <td width="10%">
                    <input type="client" name="client"/>
                </td>
                <td width="85%"></td>
            </tr>
            <tr>
                <td width="5%">sum</td>
                <td width="10%">
                    <input type="number" name="sum"/>
                </td>
                <td width="85%"></td>
            </tr>
            <tr>
                <td width="5%">addressFrom</td>
                <td width="10%">
                    <input type="text" name="addressFrom"/>
                </td>
                <td width="85%"></td>
            </tr>
            <tr>
                <td width="5%">addressTo</td>
                <td width="10%">
                    <input type="text" name="addressTo"/>
                </td>
                <td width="85%"></td>
            </tr>
            <tr>
                <td width="5%"></td>
                <td width="10%">
                    <input type="submit" value="create order"/>
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
