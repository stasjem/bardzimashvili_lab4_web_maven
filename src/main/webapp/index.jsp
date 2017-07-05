
<%@ page import="bardzimashvili.db.DirAndFiles" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="bardzimashvili.ejb.UsersHome" %>
<%@ page import="javax.rmi.PortableRemoteObject" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% new DirAndFiles(); %>
<%
    /*private DepartmentsTree lookupBean
    ()
    {*/
        try
        {
            InitialContext ctx = new InitialContext();
            Object remote = ctx.lookup("java:bardzimashvili/ejb/UsersEJB");
            UsersHome home = (UsersHome) PortableRemoteObject.narrow(remote, UsersHome.class);
            UsersHome bean = home.createUser();

        }
        catch (NamingException e)
        {
            //ругаемся и падаем
        }
   /* }*/
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="80%" align="center">
    <tr>
        <td>
        </td>
    </tr>
</table>


</body>
</html>