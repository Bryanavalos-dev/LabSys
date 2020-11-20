<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Roles"%>
<%@page import="ModeloDAO.RolesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control_Limpieza-Roles-Lista</title>
    </head>
    <body>
        <div>
            <h1>Roles Actuales</h1>
            <a href="Controlador?accion=add">Agregar Nuevo</a><br>
            
            <table border="1"><br>
                <thead>
                    <tr>
                        <th> ID </th>
                        <th>NOMBRE ROLES</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    RolesDAO dao= new RolesDAO();
                    List<Roles>list=dao.listar();
                    Iterator<Roles>iter=list.iterator();
                    Roles per=null;
                    while (iter.hasNext ()){
                        per=iter.next();                                   
                %>
                <tbody>
                    <tr>
                        <td><%= per.getId()%></td>
                        <td><%= per.getNom()%></td>
                        <td>
                            <a href="Controlador?accion=editar&id=<%= per.getId()%>">EDITAR</a>
                            <a href="Controlador?accion=eliminar&id=<%= per.getId()%>">REMOVER</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
