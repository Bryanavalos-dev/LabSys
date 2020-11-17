<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.EdificiosDAO"%>
<%@page import="modelo.Edificios"%>
<%@page import="modeloDAO.LaboratoriosDAO"%>
<%@page import="modelo.Laboratorios"%>
<div class="col"> <div>
      
        <%
                    EdificiosDAO dao= new EdificiosDAO();
                    List<Edificios>list=dao.listar();
                    Iterator<Edificios>iter=list.iterator();
                     Edificios per=null;
                   
                LaboratoriosDAO daol=new LaboratoriosDAO();
                int id=Integer.parseInt((String)request.getAttribute("idper"));
                Laboratorios lab=(Laboratorios)daol.list(id);
                                               
                %>      
        <h1>Modificar Laboratorio Del Registro : <%= lab.getCodigo()%></h1>
        <form action="admin?tipo=modificarLaboratorio" method="post">
            <input class="form-control" type="text" name="txtNombre"required="" value="<%=lab.getNombre()%>"><br>
            <select required="" id="sltEdificios" class="form-control" style="margin-bottom: 20px; " name="sltEdificio">
                 <option value='' disable>Seleccione el edifico</option>
                <%  while (iter.hasNext ()){
                        per=iter.next();
                       if(per.getId()==lab.getEdificios()){
                       %>
              
                       <option value='<%= per.getId() %>' <%= (lab.getEdificios()==per.getId())?" selected ":"" %> ><%= per.getNombre() %></option>
                 <% }else{%>
                    <option value='<%= per.getId() %>'  ><%= per.getNombre() %> </option>
                 
                    <%}}%>//fin del while
                    
                   
                </select>
                
               <input class="form-control" type="text" name="txtNivel" required="" value="<%=lab.getNivel()%>"><br>    
               <input class="form-control" type="text"  name="txtAula" required="" value="<%=lab.getAula()%>"><br> 
               <input class="form-control" type="text"  name="txtDireccion" required="" value="<%=lab.getDireccion()%>"><br> 
               <input class="form-control" type="text"  name="txtTelefono" required="" value="<%=lab.getTelefono()%>"><br> 
                <input class="form-control" type="hidden" name="txtId" value="<%= lab.getCodigo()%>"><br>
            <input class="btn btn-success" type="submit" name="accion" value="actualizarLaboratorio"><br>
        </form>          
        </div>
</div>
                 

                    

<%@include file="footer.jsp" %>
