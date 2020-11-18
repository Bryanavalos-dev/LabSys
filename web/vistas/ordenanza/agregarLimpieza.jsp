
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="conn.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Agregar Limpieza</h1>
            <form action="ordenanza?tipo=agregarLimpieza">
                Horario:<br>
                <select>
                </select>
                <input type="text" name="txtHorarioId"><br>
                Usuario:<br>
                <input type="text" name="txtUsuarioId"><br>
                Fecha inicial:<br>
                <input type="datetime-local" id="datepicker" name="txtFechaIni"><br>
                Fecha Final:<br>
                <input type="datetime-local" name="txtFechaFin"><br>
                Estado:<br>
                <input type="text" name="txtEstado"><br><br>
                <input type="submit" name="accion" value="Agregar"><br><br>
                <a href="Controlador?accion=listar">Regresar</a>
            </form>
        </div>
    </body>
</html>
