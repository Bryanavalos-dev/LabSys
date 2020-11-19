<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.EstadoDAO"%>
<%@page import="modelo.Estado"%>
<div class="col">
	<h1>Estados</h1>
         <a href="admin?tipo=agregarEstados" class="btn btn-xs btn-success">Agregar nuevo</a>
	<table id="estados" class="table table-hover">
		<thead>
                    <tr>
                        <th> ID </th>
                        <th>NOMBRE ESTADOS</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    EstadoDAO dao= new EstadoDAO();
                    List<Estado>list=dao.listar();
                    Iterator<Estado>iter=list.iterator();
                    Estado per=null;
                    while (iter.hasNext ()){
                        per=iter.next();                                   
                %>                
                    <tr>
                        <td><%= per.getId()%></td>
                        <td><%= per.getNom()%></td>
                        <td>
                            <a href="admin?tipo=editarEstado&id=<%= per.getId()%>" class="btn btn-xs btn-warning"><i class="fa fa-pencil"></i></a>
                            <a href="#"  class="btn btn-xs btn-danger pl-<%= per.getId()%>" onclick="$('.pl-<%= per.getId()%>').toggle()"><i class="fa fa-close"></i></a>
                            <a  style="display:none;" href="admin?tipo=eliminarEstado&id=<%= per.getId()%>"  class="btn btn-xs btn-danger pl-<%= per.getId()%>" >Seguro?</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
	</table>

<script>
	$('#estados').DataTable({language:{
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