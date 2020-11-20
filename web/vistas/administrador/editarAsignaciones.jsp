<%@page import="modeloDAO.AsignacionesDAO"%>
<%@page import="modelo.Asignaciones"%>
<%@page import="modeloDAO.UsuariosDAO"%>
<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.EdificiosDAO"%>
<%@page import="modelo.Edificios"%>
<%@page import="modeloDAO.LaboratoriosDAO"%>
<%@page import="modelo.Laboratorios"%>
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
                   
                AsignacionesDAO daoa=new AsignacionesDAO();
                int id=Integer.parseInt((String)request.getAttribute("idper"));
                Asignaciones asi=(Asignaciones)daoa.list(id);
                                               
                %>      
        <h1>Modificar asignacion Del Registro : <%= asi.getAsignacionid()%></h1>
        <form action="admin?tipo=modificarAsignacion" method="post">
                        <select id="sltEdificios" class="form-control" style="margin-bottom: 20px; " name="sltLab">
                 <option value='' selected disable>Seleccione el laboratorio</option>
                <%  while (iterl.hasNext ()){
                        perl=iterl.next();
                        if(perl.getCodigo() == asi.getLaboratorioid()){
                %>
                <option value='<%= perl.getCodigo() %>'<%= (perl.getCodigo()==asi.getLaboratorioid())?" selected ":"" %> ><%= perl.getNombre() %></option>
                <%}else{%>
                <option value='<%= perl.getCodigo() %>'><%= perl.getNombre() %></option>
                <% }}%>//fin del while
                    
                   
                </select>
                  <select id="sltEdificios" class="form-control" style="margin-bottom: 20px; " name="sltUser">
                 <option value='' selected disable>Seleccione el Usuario</option>
                <%  while (iteru.hasNext ()){
                        peru=iteru.next();
                        if(peru.getIdrol()==2){
                            if(peru.getUsuarioID()== asi.getUsuarioid()){
                        
                %>
                <option value='<%= peru.getUsuarioID() %>'<%= (peru.getUsuarioID()==asi.getUsuarioid())?" selected ":"" %> ><%= peru.getNombre() %></option>
                <%}else{%>
                <option value='<%= peru.getUsuarioID() %>'><%= peru.getNombre() %></option>
                 <% }}}%>//fin del while
                    
                   
                </select>
                 <input class="form-control" type="hidden" name="txtId" value="<%= asi.getAsignacionid()%>"><br>
            <input class="btn btn-success" type="submit" name="accion" value="actualizarAsignacion"><br>
        </form>          
        </div>
</div>
                 

                    

<%@include file="footer.jsp" %>
