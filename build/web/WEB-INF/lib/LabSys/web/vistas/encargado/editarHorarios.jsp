


<%@page import="modelo.Horario"%>
<%@page import="modeloDAO.HorarioDAO"%>
<%@page import="modelo.Laboratorios"%>
<%@page import="modeloDAO.LaboratoriosDAO"%>
<%@page import="modelo.Periodo"%>
<%@page import="modeloDAO.PeriodoDAO"%>
<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.UsuariosDAO"%>
<%@page import="modelo.Usuarios"%>
<%@page import="modeloDAO.RolesDAO"%>
<%@page import="modelo.Roles"%>
<div class="col"> <div>
        <%
                  
                       
                      PeriodoDAO daor= new PeriodoDAO();
                    List<Periodo>listr=daor.listar();
                    Iterator<Periodo>iterr=listr.iterator();
                    Periodo perr=null;
                       
                    LaboratoriosDAO dao= new LaboratoriosDAO();
                    List<Laboratorios>list=dao.listar();
                    Iterator<Laboratorios>iter=list.iterator();
                    Laboratorios per=null;
                    
                     HorarioDAO daoh = new HorarioDAO();
                     int id=Integer.parseInt((String)request.getAttribute("idper"));
                     Horario perh=(Horario)daoh.list(id);
                    

                                 
                %>      
          <h1>Modificar Usuario Del Registro : <%=perh.getCodigo()%></h1>
        <form action="encargado?tipo=modificarHorario" method="post">
            <div class="check">
                <% if(perh.getLunes()==1){%>
                       <input class="form-control" type="checkbox" checked name="chkLunes" value="1">Lunes
                <%}else{%>
                 <input class="form-control" type="checkbox" name="chkLunes" value="1">Lunes
                <% }%>
                
                <% if(perh.getMartes()==1){%>
                        <input class="form-control" type="checkbox" checked name="chkMartes" value="1">Martes
                <%}else{%>
                  <input class="form-control" type="checkbox" name="chkMartes" value="1">Martes
                 
                <% }%>
                
                 <% if(perh.getMiercoles()==1){%>
                 <input class="form-control" type="checkbox" checked="" name="chkMiercoles" value="1">Miercoles
                <%}else{%>
                  <input class="form-control" type="checkbox" name="chkMartes" value="1">Martes
                 
                <% }%>
                
                <% if(perh.getJueves()==1){%>
                <input class="form-control" type="checkbox" checked="" name="chkJueves" value="1">Jueves
                <%}else{%>
                  <input class="form-control" type="checkbox" name="chkJueves" value="1">Jueves
                 
                <% }%>
       
                 <% if(perh.getViernes()==1){%>
                 <input class="form-control" type="checkbox" checked="" name="chkViernes" value="1">Viernes
                <%}else{%>
                  <input class="form-control" type="checkbox" name="chkViernes" value="1">Viernes
                 
                <% }%>
                
                 
       
                 <% if(perh.getSabado()==1){%>
                 <input class="form-control" type="checkbox" checked="" name="chkSabado" value="1">Sabado
                <%}else{%>
                   <input class="form-control" type="checkbox" name="chkSabado" value="1">Sabado
                 
                <% }%>
        
                
                 <% if(perh.getDomingo()==1){%>
                 <input class="form-control" type="checkbox" checked="" name="chkDomingo" value="1">Domingo
                <%}else{%>
                    <input class="form-control" type="checkbox" name="chkDomingo" value="1">Domingo
                 
                <% }%>
        
         </div>
         
        
       
        
       
       
        <input class="form-control" type="time" name="txtHorainicio" min="00:00" max="24:00" step="60" value="<%=perh.getHorainicio()%>" /><br>
       
        <input class="form-control" type="time" name="txtHorafin" min="00:00" max="24:00" step="60" value="<%=perh.getHorafin()%>"/><br>
  
        <select class="form-control" required="" name="sltLab">
            <option value='' selected disable>Seleccione el laboratorio</option>
             <%   while (iter.hasNext ()){
                     per=iter.next(); 
                      if(per.getCodigo()== perh.getIdlab()){
                       %>
              
                   <option value='<%= per.getCodigo() %>' <%= (perh.getIdlab()==per.getCodigo())?" selected ":"" %> ><%= per.getNombre() %></option>
                 <% }else{%>
                    <option value='<%= per.getCodigo() %>'  ><%= per.getNombre() %> </option>
                 
                    <%}}%>//fin del while
                            </select><br>
      
              <select class="form-control" required="" name="sltPeriodo">
            <option value='' selected disable>Seleccione el periodo</option>
             <%   while (iterr.hasNext ()){
                     perr=iterr.next(); 
                           if(perr.getId()== perh.getIdper()){
                       %>
              
                       <option value='<%= perr.getId() %>' <%= (perh.getIdper()==perr.getId())?" selected ":"" %> ><%= perr.getNom() %></option>
                 <% }else{%>
                    <option value='<%= perr.getId() %>'  ><%= perr.getNom() %> </option>
                 
                    <%}}%>//fin del while
              </select><br>
              <input class="form-control" type="date" required value="<%=perh.getCreado()%>" name="txtFecha" min="2018-03-25" max="2050-05-25" step="1"  />
            <input class="form-control" type="hidden" name="txtId" value="<%= perh.getCodigo()%>"><br>

           
            <input class="btn btn-success" type="submit" name="accion" value="editarHorario"><br>
        </form>          
        </div>
</div>
                 

                    

<%@include file="footer.jsp" %>
