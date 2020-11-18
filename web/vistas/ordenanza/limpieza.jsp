<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Limpieza"%>
<%@page import="modeloDAO.LimpiezaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Limpieza</h1>
            <a href="Controlador?accion=add" class="btn btn-xs btn-success">Agregar nuevo</a><br><br>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID LIMPIEZA</th>
                        <th>USUARIO</th>
                        <th>ID HORARIO</th>
                        <th>L</th>
                        <th>M</th>
                        <th>M</th>
                        <th>J</th>
                        <th>V</th>
                        <th>S</th>
                        <th>D</th>
                        <th>FECHA INICIO</th>
                        <th>FECHA FIN</th>
                        <th>HORA INICIO</th>
                        <th>HORA FIN</th>
                        <th>PERIODO</th>
                        <th>LABORATORIO</th>
                        <th>ACCIONES</th>
                        
                    </tr>
                </thead>
                <%
                    LimpiezaDAO dao = new LimpiezaDAO();
                    List<Limpieza>list = dao.listar();
                    Iterator<Limpieza>iter = list.iterator();
                    Limpieza limp = null;
                    while(iter.hasNext()){
                        limp=iter.next();           
                %>
                <tbody>
                    <tr>
                        <td><%= limp.getLimpiezaid()%></td>
                        <td><%= limp.getNombre()%></td>
                        <td><%= limp.getHorarioid()%></td>
                        <td><%= limp.getLunes()%></td>
                        <td><%= limp.getMartes()%></td>
                        <td><%= limp.getMiercoles()%></td>
                        <td><%= limp.getJueves()%></td>
                        <td><%= limp.getViernes()%></td>
                        <td><%= limp.getSabado()%></td>
                        <td><%= limp.getDomingo()%></td>
                        <td><%= limp.getFecha_inicio() %></td>
                        <td><%= limp.getFecha_final()%></td>
                        <td><%= limp.getHoraInicio() %></td>
                        <td><%= limp.getHoraFin()%></td>
                        <td><%= limp.getPerdiodo()%></td>
                        <td><%= limp.getLaboratorio()%></td>
                        <td>
                            <a href="Controlador?accion=editar&limpiezaid=<%= limp.getLimpiezaid()%>">editar</a>
                            <a href="Controlador?accion=eliminar&limpiezaid=<%= limp.getLimpiezaid()%>">eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
