<%@ page import="bardzimashvili.db.Conn" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="80%" align="center" valign="top">
    <tr>
        <jsp:include page="menu.jsp"/>
        <td valign="top">
            All apps<br><br>
            <table border="1" align="left" valign="top">
                <%
                    ResultSet resSet;
                    Conn conn = new Conn();

                    resSet = conn.readTableAll();

                    while (resSet.next())
                    {
                        int id = resSet.getInt("id");
                        String name = resSet.getString("nameApp");
                        String descriptions = resSet.getString("descriptions");
                        String size = resSet.getString("size");
                        String category = resSet.getString("subcategory");
                        String category_id = resSet.getString("category_id");
                %>
                <tr>
                    <td>
                        <a href="EditServlet?id=<%= id %>"><%= name %>
                        </a>
                        <br>
                        Subcategory: <%= category %><br>
                        Category: <%= category_id %><br>
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


