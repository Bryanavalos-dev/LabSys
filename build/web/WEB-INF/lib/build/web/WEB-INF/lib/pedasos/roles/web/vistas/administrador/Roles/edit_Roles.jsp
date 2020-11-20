<%-- 
    Document   : edit
    Created on : 15-11-2020, 12:05:17 PM
    Author     : VIlleda
--%>

<%@page import="Modelo.Roles"%>
<%@page import="ModeloDAO.RolesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control_Limpieza-Roles-Editar</title>
    </head>
    <body>
        <div>
            <%
                RolesDAO dao=new RolesDAO();
                int id=Integer.parseInt((String)request.getAttribute("idper"));
                Roles p=(Roles)dao.list(id);
            %>
        <h1>Modificar Periodo Del Registro : <%= p.getId()%></h1>
        <form>
            Ingresar Nuevo Nombre de Rol (Nombre Anterior: <%= p.getNom()%>)<br>
            <input type="text" name="txtNombre" value="<%= p.getNom()%>"><br>
            <input type="hidden" name="txtId" value="<%= p.getId()%>"><br>
            <input type="submit" name="accion" value="Actualizar"><br>
        </form>          
        </div>
    </body>
</html>
