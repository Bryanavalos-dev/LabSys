<%-- 
    Document   : admin
    Created on : 11-14-2020, 10:19:25 AM
    Author     : gerson
--%>
<%@page import="modelo.Usuarios"%>
<%
 Usuarios u =  (Usuarios)session.getAttribute("usuario");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin <%= u.getNombre() %></h1>
        <h1><a href="Controlador_Roles?accion=listar">Listar Roles</a></h1>
    </body>
</html>
