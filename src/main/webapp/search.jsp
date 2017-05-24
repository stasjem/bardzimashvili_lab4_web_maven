<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="80%" align="center">
    <tr>
        <jsp:include page="menu.jsp"/>
        <td>
            <form action='SearchServlet' method="post">
                Search by name and by category<br>
                <input type='text' size='80' name="nameApp"><br>
                <input type='submit' value="Search">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
