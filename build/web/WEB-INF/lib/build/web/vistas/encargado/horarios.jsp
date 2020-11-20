<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.HorarioDAO"%>
<%@page import="modelo.Horario"%>
<div class="col">
	<h1>Horarios</h1>
          <a href="encargado?tipo=agregarHorarios" class="btn btn-xs btn-success">Agregar nuevo</a>
	<table id="horarios" class="table table-hover">
		<thead>
                    <tr>
                       <th>Codigo</th>
                        <th>Dias</th>
                        <th>Hora Inicio</th>
                        <th>Hora fin</th>
                        <th>Creado</th>
                        <th>Laboratorio</th>
                        <th>Periodo</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    HorarioDAO dao= new HorarioDAO();
                    List<Horario>list=dao.listar();
                    Iterator<Horario>iter=list.iterator();
                    Horario per=null;
                    while (iter.hasNext ()){
                        per=iter.next();                                   
                %>                
                    <tr>
                      <td><%= per.getCodigo()%></td>
                      <td><% if(per.getLunes()==1){
                       out.print("Lunes ");
                }%>
                <% if(per.getMartes()==1){
                       out.print("Martes ");
                }%>
                <% if(per.getMiercoles()==1){
                       out.print("Miercoles ");
                }%>
                <% if(per.getJueves()==1){
                       out.print("Jueves ");
                }%>
                <% if(per.getViernes()==1){
                       out.print("Viernes ");
                }%>
                <% if(per.getSabado()==1){
                       out.print("Sabado ");
                }%>
                <% if(per.getDomingo()==1){
                       out.print("Domingo ");
                }%>
                
                
                   </td>
		
		<td><%= per.getHorainicio()%></td>	
                <td><%= per.getHorafin()%></td>
                <td><%= (per.getCreado()!=null)?per.getCreado():" Sin fecha " %></td>	
                <td><%= per.getLaboratorio()%></td>	
                <td><%= per.getPeriodo()%></td>	
                        <td>
                          <a href="encargado?tipo=editarHorario&id=<%= per.getCodigo()%>"  class="btn btn-xs btn-warning"><i class="fa fa-pencil"></i></a>
                             <a href="#"  class="btn btn-xs btn-danger pl-<%= per.getCodigo()%>" onclick="$('.pl-<%= per.getCodigo()%>').toggle()"><i class="fa fa-close"></i></a>
                            <a  style="display:none;" href="encargado?tipo=eliminarHorario&id=<%= per.getCodigo()%>"  class="btn btn-xs btn-danger pl-<%= per.getCodigo()%> " >Seguro?</a>
                       
                        </td>
                    </tr>
                    <%}%>
                </tbody>
	</table>

<script>
	$('#horarios').DataTable({language:{
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