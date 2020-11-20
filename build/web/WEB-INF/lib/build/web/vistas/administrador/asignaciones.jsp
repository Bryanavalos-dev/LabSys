<%@page import="modelo.Asignaciones"%>
<%@page import="modeloDAO.AsignacionesDAO"%>
<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.EdificiosDAO"%>
<%@page import="modelo.Edificios"%>
<div class="col">
	<h1>Asignaciones</h1>
          <a href="admin?tipo=agregarAsignaciones" class="btn btn-xs btn-success">Agregar nuevo</a>
	<table id="edificios" class="table table-hover">
		<thead>
                    <tr>
                        <th> ID </th>
                        <th>Laboratorio</th>
                        <th>Usuario</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                <%
                   AsignacionesDAO daoa= new AsignacionesDAO();
                    List<Asignaciones>lista=daoa.listar();
                    Iterator<Asignaciones>itera=lista.iterator();
                    Asignaciones pera=null;
                    while (itera.hasNext ()){
                        pera=itera.next();                                   
                %>                
                    <tr>
                        <td><%= pera.getAsignacionid()%></td>
                        <td><%= pera.getLaboratorio()%></td>
                        <td><%= pera.getUsuario()%></td>
                        <td>
                            <a href="admin?tipo=modificarAsignacion&id=<%= pera.getAsignacionid()%>" class="btn btn-xs btn-warning"><i class="fa fa-pencil"></i></a>
                             <a href="#"  class="btn btn-xs btn-danger pl-<%= pera.getAsignacionid()%>" onclick="$('.pl-<%= pera.getAsignacionid()%>').toggle()"><i class="fa fa-close"></i></a>
                            <a  style="display:none;" href="admin?tipo=eliminarAsignacion&id=<%= pera.getAsignacionid()%>"  class="btn btn-xs btn-danger pl-<%= pera.getAsignacionid()%>" >Seguro?</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
	</table>

<script>
	$('#edificios').DataTable({language:{
      "sProcessing":     "Procesando...",
      "sLengthMenu":     "Mostrar _MENU_ registros",
      "sZeroRecords":    "No se encontraron resultados",
      "sEmptyTable":     "NingÃºn dato disponible en esta tabla",
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
        "sLast":     "Ãšltimo",
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