<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.EdificiosDAO"%>
<%@page import="modelo.Edificios"%>
<div class="col">
	<h1>Edificios</h1>
          <a href="admin?tipo=agregarEdificios" class="btn btn-xs btn-success">Agregar nuevo</a>
	<table id="edificios" class="table table-hover">
		<thead>
                    <tr>
                        <th> ID </th>
                        <th>NOMBRE EDIFICIOS</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    EdificiosDAO dao= new EdificiosDAO();
                    List<Edificios>list=dao.listar();
                    Iterator<Edificios>iter=list.iterator();
                    Edificios per=null;
                    while (iter.hasNext ()){
                        per=iter.next();                                   
                %>                
                    <tr>
                        <td><%= per.getId()%></td>
                        <td><%= per.getNombre()%></td>
                        <td>
                            <a href="admin?tipo=modificarEdificios&id=<%= per.getId()%>" class="btn btn-xs btn-warning"><i class="fa fa-pencil"></i></a>
                             <a href="#"  class="btn btn-xs btn-danger pl-<%= per.getId()%>" onclick="$('.pl-<%= per.getId()%>').toggle()"><i class="fa fa-close"></i></a>
                            <a  style="display:none;" href="admin?tipo=eliminarEdificio&id=<%= per.getId()%>"  class="btn btn-xs btn-danger pl-<%= per.getId()%>" >Seguro?</a>
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