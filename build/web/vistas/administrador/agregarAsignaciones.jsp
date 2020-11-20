<%@page import="modelo.Laboratorios"%>
<%@page import="modeloDAO.LaboratoriosDAO"%>
<%@page import="modeloDAO.UsuariosDAO"%>
<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.EdificiosDAO"%>
<%@page import="modelo.Edificios"%>
<div class="col"> <div>

        <%
             UsuariosDAO daou= new UsuariosDAO();
                    List<Usuarios>listu=daou.listar();
                    Iterator<Usuarios>iteru=listu.iterator();
                    Usuarios peru=null;
                    
                     LaboratoriosDAO daol= new LaboratoriosDAO();
                    List<Laboratorios>listl=daol.listar();
                    Iterator<Laboratorios>iterl=listl.iterator();
                    Laboratorios perl=null;
                                               
                %>      
        <h1>Agregar Asignaciones</h1>
        <form action="admin?tipo=agregarAsignacion" method="post">
           
            <select id="sltEdificios" class="form-control" style="margin-bottom: 20px; " name="sltLab">
                 <option value='' selected disable>Seleccione el laboratorio</option>
                <%  while (iterl.hasNext ()){
                        perl=iterl.next();
                %>
                <option value='<%= perl.getCodigo() %>'><%= perl.getNombre() %></option>
                 <% }%>//fin del while
                    
                   
                </select>
                  <select id="sltEdificios" class="form-control" style="margin-bottom: 20px; " name="sltUser">
                 <option value='' selected disable>Seleccione el Usuario</option>
                <%  while (iteru.hasNext ()){
                        peru=iteru.next();
                        if(peru.getIdrol()==2){
                %>
                <option value='<%= peru.getUsuarioID() %>'><%= peru.getNombre() %></option>
                 <% }}%>//fin del while
                    
                   
                </select>
                 
            <input class="btn btn-success" type="submit" name="accion" value="agregarLaboratorio"><br>
        </form>          
        </div>
</div>
                 

                    

<%@include file="footer.jsp" %>
