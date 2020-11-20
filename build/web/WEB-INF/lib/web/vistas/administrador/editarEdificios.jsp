<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.EdificiosDAO"%>
<%@page import="modelo.Edificios"%>
<div class="col"> <div>
            <%
                EdificiosDAO dao=new EdificiosDAO();
                int id=Integer.parseInt((String)request.getAttribute("idper"));
                Edificios p=(Edificios)dao.list(id);
            %>
        <h1>Modificar Periodo Del Registro : <%= p.getId()%></h1>
        <form action="admin?tipo=modificarEdificio" method="post">
            <h3>Ingresar Nuevo Nombre de Edificio (Nombre Anterior: <%= p.getNombre()%>)</h3><br>
            <input class="form-control" type="text" name="txtNombre" required="" value="<%= p.getNombre()%>"><br>
            <input class="form-control" type="hidden" name="txtId" value="<%= p.getId()%>"><br>
            <input class="btn btn-success" type="submit" name="accion" value="actualizarEdificio"><br>
        </form>          
        </div>
</div>

<%@include file="footer.jsp" %>