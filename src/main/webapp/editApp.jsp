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
            <form action='UpdateServlet' method="post">
                <input type='hidden' size='40' name="idDb" value="<%= request.getAttribute("idDb") %>">

                Name app<br>
                <input type='text' size='40' name="nameApp" value="<%= request.getAttribute("nameAppDb") %>"><br>

                Size<br>
                <input type='text' size='40' name="size" value="<%= request.getAttribute("sizeDb") %>"><br>

                Descriptions new app<br>
                <input type='text' size='40' name="descriptions" value="<%= request.getAttribute("descriptionsDb") %>"><br>
                <input type='submit' name="update" value="Update">
            </form>

            <form action='DeleteServlet' method="post">
                <input type='hidden' size='40' name="idDb" value="<%= request.getAttribute("idDb") %>">
                <input type='submit' name="delete" value="Delete">
            </form>
        </td>
    </tr>
</table>
</body>
</html>


