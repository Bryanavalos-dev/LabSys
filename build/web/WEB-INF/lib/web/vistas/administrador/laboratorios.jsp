<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.LaboratoriosDAO"%>
<%@page import="modelo.Laboratorios"%>
<div class="col">
	<h1>Laboratorios</h1>
          <a href="admin?tipo=agregarLaboratorios" class="btn btn-xs btn-success">Agregar nuevo</a>
	<table id="laboratorios" class="table table-hover">
		<thead>
                    <tr>
                        <th> ID </th>
                        <th>NOMBRE LABORATORIO</th>
                        <th>NOMBRE EDIFICIO</th>
                        <th>NIVEL</th>
                        <th>AULA</th>
                        <th>DIRECCION</th>
                        <th>TELEFONO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    LaboratoriosDAO dao= new LaboratoriosDAO();
                    List<Laboratorios>list=dao.listar();
                    Iterator<Laboratorios>iter=list.iterator();
                    Laboratorios per=null;
                    while (iter.hasNext ()){
                        per=iter.next();                                   
                %>                
                    <tr>
                        <td><%= per.getCodigo()%></td>
                        <td><%= per.getNombre()%></td>
                        <td><%= per.getEdificio()%></td>
                        <td><%= per.getNivel()%></td>
                        <td><%= per.getAula()%></td>
                        <td><%= per.getDireccion()%></td>
                        <td><%= per.getTelefono()%></td>
                        <td>
                            <a href="admin?tipo=editarLaboratorio&id=<%= per.getCodigo()%>"  class="btn btn-xs btn-warning"><i class="fa fa-pencil"></i></a>
                             <a href="#"  class="btn btn-xs btn-danger pl-<%= per.getCodigo()%>" onclick="$('.pl-<%= per.getCodigo()%>').toggle()"><i class="fa fa-close"></i></a>
                            <a  style="display:none;" href="admin?tipo=eliminarLaboratorio&id=<%= per.getCodigo()%>"  class="btn btn-xs btn-danger pl-<%= per.getCodigo()%> " >Seguro?</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
	</table>

<script>
	$('#laboratorios').DataTable({language:{
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