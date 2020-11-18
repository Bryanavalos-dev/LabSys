<%@page import="modelo.Periodo"%>
<%@page import="modeloDAO.PeriodoDAO"%>
<%@page import="modelo.Laboratorios"%>
<%@page import="modeloDAO.LaboratoriosDAO"%>
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
                                               
                %>      
        <h1>Agregar Horario</h1>
        <form action="encargado?tipo=agregarHorario" method="post">
        
        <div class="check">
     
         <input class="form-control" type="checkbox" name="chkLunes" value="1">Lunes
         <input class="form-control" type="checkbox" name="chkMartes" value="1">Martes
         <input class="form-control" type="checkbox" name="chkMiercoles" value="1">Miercoles
         <input class="form-control" type="checkbox" name="chkJueves" value="1">Jueves
         <input class="form-control" type="checkbox" name="chkViernes" value="1">Viernes
         <input class="form-control" type="checkbox" name="chkSabado" value="1">Sabado
         <input class="form-control" type="checkbox" name="chkDomingo" value="1">Domingo
         </div>
         
        
       
        
       
       
        <input class="form-control" type="time" name="txtHorainicio" min="00:00" max="24:00" step="60" />
       
        <input class="form-control" type="time" name="txtHorafin" min="00:00" max="24:00" step="60" />
  
        <select class="form-control" required="" name="sltLab">
            <option value='' selected disable>Seleccione el laboratorio</option>
        <%   while (iter.hasNext ()){
                            per=iter.next();   
                %>
                <option value='<%=per.getCodigo()%>'><%= per.getNombre()%></option>
                 <% }%>//fin del while
                            </select>
      
              <select class="form-control" required="" name="sltPeriodo">
            <option value='' selected disable>Seleccione el periodo</option>
        <%   while (iterr.hasNext ()){
                      perr=iterr.next();   
                %>
                <option value='<%=perr.getId()%>'><%= perr.getNom()%></option>
                 <% }%>//fin del while
                    
        </select>
            <input class="form-control" required type="date" name="txtFecha" min="2018-03-25" max="2050-05-25" step="1" />
         
           
            <input class="btn btn-success" type="submit" name="accion" value="agregarHorario"><br>
        </form>          
        </div>
</div>
                 

                    

<%@include file="footer.jsp" %>
