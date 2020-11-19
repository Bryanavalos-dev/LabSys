<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.RolesDAO"%>
<%@page import="modelo.Roles"%>
<div class="col"> <div>
            <%
                RolesDAO dao=new RolesDAO();
                int id=Integer.parseInt((String)request.getAttribute("idper"));
                Roles p=(Roles)dao.list(id);
            %>
        <h1>Modificar Periodo Del Registro : <%= p.getId()%></h1>
        <form action="admin?tipo=modificarRol" method="post">
            <h3>Ingresar Nuevo Nombre de Rol (Nombre Anterior: <%= p.getNom()%>)</h3><br>
            <input class="form-control" type="text" name="txtNombre" required="" value="<%= p.getNom()%>"><br>
            <input class="form-control" type="hidden" name="txtId" value="<%= p.getId()%>"><br>
            <input class="btn btn-success" type="submit" name="accion" value="actualizarRol"><br>
        </form>          
        </div>
</div>

<%@include file="footer.jsp" %>