<%@include file="header.jsp" %>

<%@page import="java.util.Iterator"%>
<%@page import="modelo.Estado"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.EstadoDAO"%>
<%@page import="modelo.Limpieza"%>
<%@page import="modeloDAO.LimpiezaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col">
            <%
              LimpiezaDAO dao = new LimpiezaDAO();
             int id=Integer.parseInt((String)request.getAttribute("idper"));

              Limpieza l = (Limpieza)dao.list(id);
              
                    EstadoDAO daoes = new EstadoDAO();
                    List<Estado> listes=daoes.listar();
                    Iterator<Estado>iteres = listes.iterator();
                    Estado peres=null;
            %>
               <h1>Modificar Estado de la limpieza : <%= l.getLimpiezaid()%></h1>
        <form action="ordenanza?tipo=modificarLimpieza" method="post">
                        <select id="sltEdificios" class="form-control" style="margin-bottom: 20px; " name="sltEstado">
                 <option value='' selected disable>Seleccione el estado</option>
                <%  while (iteres.hasNext ()){
                        peres=iteres.next();
                        if(l.getLimpiezaid() == peres.getId()){
                %>
                <option value='<%= peres.getId() %>'<%= (l.getLimpiezaid()==peres.getId())?" selected ":"" %> ><%= peres.getNom() %></option>
                <%}else{%>
                <option value='<%= peres.getId() %>'><%= peres.getNom() %></option>
                <% }}%>//fin del while
                    
                 
                 <input class="form-control" type="hidden" name="txtId" value="<%= l.getLimpiezaid()%>"><br>
            <input class="btn btn-success" type="submit" name="accion" value="actualizarLimpieza"><br>
        </form>          
        </div>
 <%@include file="footer.jsp" %>
