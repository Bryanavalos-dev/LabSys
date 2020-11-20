<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.UsuariosDAO"%>
<%@page import="modelo.Usuarios"%>
<div class="col">
	<h1>Usuarios</h1>
         <a href="admin?tipo=agregarUsuarios" class="btn btn-xs btn-success">Agregar nuevo</a>
	<table id="periodos" class="table table-hover">
		<thead>
                    <tr>
                        <th> ID </th>
                        <th>NOMBRE</th>
                        <th>TELEFONO</th>
                        <th>CORREO</th>
                        <th>PASSWORD</th>
                        <th>NACIMIENTO</th>
                        <th>ROL</th>
                        <th>ACTIVO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    UsuariosDAO dao= new UsuariosDAO();
                    List<Usuarios>list=dao.listar();
                    Iterator<Usuarios>iter=list.iterator();
                    Usuarios per=null;
                    while (iter.hasNext ()){
                        per=iter.next();                                   
                %>                
                    <tr>
                        <td><%= per.getUsuarioID()%></td>
                        <td><%= per.getNombre()%></td>
                       
                        <td><%= per.getTelefono()%></td>
                        <td><%= per.getCorreo()%></td>
                        <td><%= per.getPassword()%></td>
                        <td><%= per.getNacimiento()%></td>
                        <td><%= per.getRol()%></td>
                        <td><%= per.getActivo()%></td>
                        
                        <td>
                            <%if(per.getIdrol()!= 1){%>
                            <a href="admin?tipo=modificarUsuario&id=<%= per.getUsuarioID()%>" class="btn btn-xs btn-warning"><i class="fa fa-pencil"></i></a>
                            <a href="#"  class="btn btn-xs btn-danger pl-<%= per.getUsuarioID()%>" onclick="$('.pl-<%= per.getUsuarioID()%>').toggle()"><i class="fa fa-close"></i></a>
                            <a  style="display:none;" href="admin?tipo=eliminarUsuario&id=<%= per.getUsuarioID()%>"  class="btn btn-xs btn-danger pl-<%= per.getUsuarioID()%>" >Seguro?</a>
                            <%}else{%>
                            <label>El administrador es intocable</label>
                            <%}%>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
	</table>

<script>
	$('#periodos').DataTable({language:{
      "sProcessing":     "Procesando...",
      "sLengthMenu":     "Mostrar _MENU_ registros",
      "sZeroRecords":    "No se encontraron resultados",
      "sEmptyTable":     "Ning√∫n dato disponible en esta tabla",
      "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
      "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
      "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
      "sInfoPostFix":    "",
      "sSearch":         "Buscar:",
      "sUrl":            "",
      "sInfoThousands":  ",",
      "sLoadingRecords": "Cargando...",
      "oPaginate": {
        "sFirst":    "Primero",
        "sLast":     "√?ltimo",
        "sNext":     "Siguiente",
        "sPrevious": "Anterior"
      },
      "oAria": {
        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
      }
    },
    "scrollY": "500px",
    "scrollCollapse": true,
    "paging": false,
    "searching": true,
    "info": true
  });
</script>
</div>

<%@include file="footer.jsp" %>