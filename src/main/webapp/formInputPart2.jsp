<%@ page import="bardzimashvili.db.Conn" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.io.PrintWriter" %>
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
            <form action="InputServletPartTwo" method="post">
                <input type="hidden" name="nameApp" value="<%= request.getAttribute("nameApp") %>">
                <input type="hidden" name="category" value="<%= request.getAttribute("category") %>">
                <input type="hidden" name="size" value="<%= request.getAttribute("size") %>">
                <input type="hidden" name="descriptions" value="<%= request.getAttribute("descriptions") %>">
                Name app: <%= request.getAttribute("nameApp") %><br>
                <%
                    Conn conn1 = new Conn();
                    String app1 = "category";
                    String categoryId1 = (String) request.getAttribute("categoryId");
                    String whereName1 = "id";
                    ResultSet resSet1;

                    resSet1 = conn1.readTableWhere(app1, categoryId1, whereName1);
                    while (resSet1.next())
                    {
                        String nameCategory1 = resSet1.getString("name");
                %>
                Category: <%= nameCategory1 %><br>
                <% } %>

                Size: <%= request.getAttribute("size") %><br>
                Descriptions new app: <%= request.getAttribute("size") %><br>

                SubcategoryId:
                <select name="subcategoryId">
                    <%
                        Conn conn = new Conn();
                        String app = "subcategory";
                        String categoryId = (String) request.getAttribute("categoryId");
                        String whereName = "category_id";
                        ResultSet resSet;

                        resSet = conn.readTableWhere(app, categoryId, whereName);

                        while (resSet.next())
                        {
                            int id = resSet.getInt("id");
                            String name = resSet.getString("name");
                    %>
                    <option value="<%= id %>"><%= name %></option>
                    <% } %>
                </select><br>

                Descriptions:<br>
                <%= request.getAttribute("descriptions") %><br>
                <input type='submit' value="Output data">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
