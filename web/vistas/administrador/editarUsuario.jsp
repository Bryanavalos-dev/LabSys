<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.UsuariosDAO"%>
<%@page import="modelo.Usuarios"%>
<%@page import="modeloDAO.RolesDAO"%>
<%@page import="modelo.Roles"%>
<div class="col"> <div>
        <%
                  
                     
                    RolesDAO daor= new RolesDAO();
                    List<Roles>listr=daor.listar();
                    Iterator<Roles>iterr=listr.iterator();
                    Roles perr= null;
                                                   
                     UsuariosDAO dao = new UsuariosDAO();
                     int id=Integer.parseInt((String)request.getAttribute("idper"));
                     Usuarios usus=(Usuarios)dao.list(id);
                                               
                %>      
          <h1>Modificar Usuario Del Registro : <%=usus.getUsuarioID()%></h1>
        <form action="admin?tipo=modificarUsuario" method="post">
            <input class="form-control" type="text" name="txtNombre" placeholder="Ingrese el nombre" required="" value="<%=usus.getNombre()%>"><br>
               
               <input class="form-control" type="text" placeholder="Ingrese el telefono" name="txtTelefono" required="" value="<%=usus.getTelefono()%>"><br>    
               <input class="form-control" type="text" placeholder="Ingrese el correo" name="txtCorreo" required="" value="<%=usus.getCorreo()%>"><br> 
               <input class="form-control" type="text" placeholder="Ingrese la password" name="txtPassword" required="" value="<%=usus.getPassword()%>"><br> 
              <input class="form-control" type="date" placeholder="Ingrese la Nacimiento" name="txtNacimiento" required="" value=""min="1000-01-01" max="2050-05-25" step="1" value="<%=usus.getNacimiento()%>"><br> 
            <select id="sltRol" class="form-control" style="margin-bottom: 20px; " name="sltRol">
                 <option value='' selected disable>Seleccione el rol</option>
                <%   while (iterr.hasNext ()){
                     perr=iterr.next(); 
                            if(perr.getId()== usus.getIdrol()){
                       %>
              
                       <option value='<%= perr.getId() %>' <%= (usus.getIdrol()==perr.getId())?" selected ":"" %> ><%= perr.getNom() %></option>
                 <% }else{%>
                    <option value='<%= perr.getId() %>'  ><%= perr.getNom() %> </option>
                 
                    <%}}%>//fin del while
                   
                </select>
                 
             <input class="form-control" type="text" placeholder="Ingrese el estado" name="txtActivo" required="" value="<%= usus.getActivo()%>"><br>
                <input class="form-control" type="hidden" name="txtId" value="<%= usus.getUsuarioID()%>"><br>
            <input class="btn btn-success" type="submit" name="accion" value="Actualizar Usuario"><br>
        </form>          
        </div>
</div>
                 

                    

<%@include file="footer.jsp" %>
