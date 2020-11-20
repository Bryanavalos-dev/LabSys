<%@page import="modelo.Estado"%>
<%@page import="modeloDAO.EstadoDAO"%>
<%@include file="header.jsp" %>


<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.UsuariosDAO"%>
<%@page import="modelo.Usuarios"%>
<%@page import="modeloDAO.RolesDAO"%>
<%@page import="modelo.Roles"%>
<%@page import="modeloDAO.HorarioDAO"%>
<%@page import="modelo.Horario"%>
<div class="col"> <div>

        <%
                  
                     
                    HorarioDAO daoh= new HorarioDAO();
                    List<Horario>listh=daoh.listar();
                    Iterator<Horario>iterh=listh.iterator();
                    Horario perh=null;
                    
                    UsuariosDAO daou = new UsuariosDAO();
                    List<Usuarios> listu=daou.listar();
                    Iterator<Usuarios>iteru = listu.iterator();
                    Usuarios peru=null;
                    
                    EstadoDAO daoes = new EstadoDAO();
                    List<Estado> listes=daoes.listar();
                    Iterator<Estado>iteres = listes.iterator();
                    Estado peres=null;
                                               
                %>      
        <h1>Asignar horario</h1>
        <form action="encargado?tipo=asignarHorario" method="post">
            
                <select id="sltHorario" class="form-control" style="margin-bottom: 20px; " name="sltHorario">
                 <option value='' selected disable>Seleccione el horario</option>
                    

                <%   while (iterh.hasNext ()){
                            perh=iterh.next();   
                %>
                <option value='<%=perh.getCodigo()%>'><%= perh.getLaboratorio()%> || 
                 <%    if(perh.getLunes()==1){
                       out.print("Lunes ");
                }%>
                <% if(perh.getMartes()==1){
                       out.print("Martes ");
                }%>
                <% if(perh.getMiercoles()==1){
                       out.print("Miercoles ");
                }%>
               <% if(perh.getJueves()==1){
                       out.print("Jueves ");
                }%>
                <% if(perh.getViernes()==1){
                       out.print("Viernes ");
                }%>
                <% if(perh.getSabado()==1){
                       out.print("Sabado ");
                }%>
                <% if(perh.getDomingo()==1){
                       out.print("Domingo ");
                }%>||
                 <%= perh.getHorainicio()%> ||
                <%= perh.getHorafin()%> ||
                <%= perh.getPeriodo()%> ||
                <%= perh.getCreado()%> ||
                </option>
                 <% }%>//fin del while
                                         
                </select>
                <select id="sltUsuario" class="form-control" style="margin-bottom: 20px; " name="sltUsuario">
                 <option value='' selected disable>Seleccione el Usuario</option>  
                  <%   while (iteru.hasNext ()){
                            peru=iteru.next();
                            if(peru.getIdrol()==3){
                %>
                <option value="<%=peru.getUsuarioID()%>"><%=peru.getNombre()%></option>
                <%}%>
             
                <%}%>
                </select>
                <input class="form-control" required type="date" name="txtFechain" min="2018-03-25" max="2050-05-25" step="1" /><br>
                <input class="form-control" required type="date" name="txtFechafin" min="2018-03-25" max="2050-05-25" step="1" ><br>
                
                 <select id="sltState" class="form-control" style="margin-bottom: 20px; " name="sltEstado">
                 <option value='' selected disable>Seleccione el estado</option>  
                  <%   while (iteres.hasNext ()){
                            peres=iteres.next();
                         
                %>
                <option value="<%=peres.getId()%>"><%=peres.getNom()%></option>
               
             
                <%}%>
                </select>

            <input class="btn btn-success" type="submit" name="accion" value="agregarUsuario"><br>
        </form>          
        </div>
</div>
                 

                    

<%@include file="footer.jsp" %>

