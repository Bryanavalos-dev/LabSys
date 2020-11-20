<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.EstadoDAO"%>
<%@page import="modelo.Estado"%>
<div class="col"> <div>
            <%
                EstadoDAO dao=new EstadoDAO();
                int id=Integer.parseInt((String)request.getAttribute("idper"));
                Estado p=(Estado)dao.list(id);
            %>
        <h1>Modificar Estado Del Registro : <%= p.getId()%></h1>
        <form action="admin?tipo=modificarEstado" method="post">
            <h3>Ingresar Nuevo Nombre de Estado(Nombre Anterior: <%= p.getNom()%>)</h3><br>
            <input class="form-control" type="text" name="txtNombre" required="" value="<%= p.getNom()%>"><br>
            <input class="form-control" type="hidden" name="txtId" value="<%= p.getId()%>"><br>
            <input class="btn btn-success" type="submit" name="accion" value="actualizarEstado"><br>
        </form>          
        </div>
</div>

<%@include file="footer.jsp" %>