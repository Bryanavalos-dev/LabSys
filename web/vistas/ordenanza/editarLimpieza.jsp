<%-- 
    Document   : Editar
    Created on : 11-13-2020, 05:14:32 PM
    Author     : George
--%>

<%@page import="Modelo.Limpieza"%>
<%@page import="ModeloDAO.LimpiezaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <%
              LimpiezaDAO dao = new LimpiezaDAO();
              int id = Integer.parseInt((String)request.getAttribute("idlimp"));
              Limpieza l = (Limpieza)dao.list(id);
            %>
            <h1>Editar Limpieza</h1>
            <form action="Controlador">
                Horario:<br>
                <input type="text" name="txtHorarioId" value="<%= l.getHorarioid() %>"><br>
                Usuario:<br>
                <input type="text" name="txtUsuarioId" value="<%= l.getUsuarioid() %>"><br>
                Fecha inicial:<br>
                <input type="text" id="datepicker" name="txtFechaIni" value="<%= l.getFecha_inicio() %>"><br>
                Fecha Final:<br>
                <input type="text" name="txtFechaFin" value="<%= l.getFecha_final() %>"><br>
                Estado:<br>
                <input type="text" name="txtEstado" value="<%= l.getEstado() %>"><br><br>
                <input type="hidden" name="txtId" value="<%= l.getLimpiezaid() %>">
                <input type="submit" name="accion" value="Actualizar"><br><br>
                <a href="Controlador?accion=listar">Regresar</a>
            </form>
        </div>
    </body>
</html>
