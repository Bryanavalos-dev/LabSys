<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.EdificiosDAO"%>
<%@page import="modelo.Edificios"%>
<div class="col"> <div>

        <%
                    EdificiosDAO dao= new EdificiosDAO();
                    List<Edificios>list=dao.listar();
                    Iterator<Edificios>iter=list.iterator();
                     Edificios per=null;
                                               
                %>      
        <h1>Agregar Laboratorios</h1>
        <form action="admin?tipo=agregarLaboratorio" method="post">
            <input class="form-control" type="text" name="txtNombre" placeholder="Ingrese el nombre" required="" value=""><br>
            <select id="sltEdificios" class="form-control" style="margin-bottom: 20px; " name="sltEdificio">
                 <option value='' selected disable>Seleccione el edifico</option>
                <%  while (iter.hasNext ()){
                        per=iter.next();
                %>
                <option value='<%= per.getId() %>'><%= per.getNombre() %></option>
                 <% }%>//fin del while
                    
                   
                </select>
                 <input class="form-control" type="text"  placeholder="Edififico Seleccionado" name="txtEdificio" id='txtEdificio'  value=""><br>
               <input class="form-control" type="text" placeholder="Ingrese el nivel" name="txtNivel" required="" value=""><br>    
               <input class="form-control" type="text" placeholder="Ingrese el Aula" name="txtAula" required="" value=""><br> 
               <input class="form-control" type="text" placeholder="Ingrese la direccion" name="txtDireccion" required="" value=""><br> 
               <input class="form-control" type="text" placeholder="Ingrese el telefono" name="txtTelefono" required="" value=""><br> 
            <input class="btn btn-success" type="submit" name="accion" value="agregarLaboratorio"><br>
        </form>          
        </div>
</div>
                 

                    

<%@include file="footer.jsp" %>
