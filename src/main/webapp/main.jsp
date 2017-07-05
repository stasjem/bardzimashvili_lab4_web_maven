<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="bardzimashvili.db.DirAndFiles" %>
<%@ page import="javax.naming.InitialContext" %>
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
            Current time
            <br>
            <% response.setIntHeader("Refresh", 1); %>
            <%= new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new Date()) %>
        </td>
    </tr>
</table>

</body>
</html>
