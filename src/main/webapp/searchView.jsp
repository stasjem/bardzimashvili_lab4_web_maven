<%@ page import="bardzimashvili.db.Conn" %>
<%@ page import="java.sql.ResultSet" %>
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
            <table border="1" align="left" valign="top">
                <%
                    Conn conn = new Conn();
                    String nameApp = (String) request.getAttribute("nameApp");
                    ResultSet resSet;

                    resSet = conn.searchTableWhere(nameApp);

                    while (resSet.next())
                    {
                        int id = resSet.getInt("id");
                        String name = resSet.getString("nameApp");
                        String descriptions = resSet.getString("descriptions");
                        String size = resSet.getString("size");
                        String category = resSet.getString("subcategory");
                %>
                <tr>
                    <td>
                        <a href="EditServlet?id=<%= id %>"><%= name %>
                        </a>
                        <br>
                        Subcategory: <%= category %><br>
                        Category: <%= category %><br>
                        Size: <%= size %><br>
                        Descriptions: <%= descriptions %><br>
                    </td>
                    <% } %>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
