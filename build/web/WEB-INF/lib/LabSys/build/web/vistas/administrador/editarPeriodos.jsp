<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.PeriodoDAO"%>
<%@page import="modelo.Periodo"%>
<div class="col"> <div>
            <%
                PeriodoDAO dao=new PeriodoDAO();
                int id=Integer.parseInt((String)request.getAttribute("idper"));
                Periodo p=(Periodo)dao.list(id);
            %>
        <h1>Modificar Periodo Del Registro : <%= p.getId()%></h1>
        <form action="admin?tipo=modificarPeriodo" method="post">
            <h3>Ingresar Nuevo Nombre de Periodo(Nombre Anterior: <%= p.getNom()%>)</h3><br>
            <input class="form-control" type="text" name="txtNombre" required="" value="<%= p.getNom()%>"><br>
            <input class="form-control" type="hidden" name="txtId" value="<%= p.getId()%>"><br>
            <input class="btn btn-success" type="submit" name="accion" value="actualizarPeriodo"><br>
        </form>          
        </div>
</div>

<%@include file="footer.jsp" %>