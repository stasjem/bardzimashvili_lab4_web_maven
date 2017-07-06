<%@ page import="bardzimashvili.db.DirAndFiles" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.rmi.PortableRemoteObject" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    try
    {
        new DirAndFiles();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }

%>
<%--<%
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
%>--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>


<div id="body">
    <div id="login_form">
        <form action="main.jsp" method="post">
            login<br>
            <input type="text" name="UserName" size="24" maxlength="256">
            password<br>
            <input type="password" name="Password" size="24" maxlength="256">
            <br>
            <input type="submit" value="Войти">
            <input type="reset" value="Сбросить">

        </form>
    </div>
</div>


</body>
</html>