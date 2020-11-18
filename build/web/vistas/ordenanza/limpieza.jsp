<%@include file="header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Limpieza"%>
<%@page import="modeloDAO.LimpiezaDAO"%>
<div class="col">
    <h1>Limpieza</h1>
    <a href="ordenanza?tipo=agregarLimpieza" class="btn btn-xs btn-success">Agregar nuevo</a><br><br>
    <table id="limpieza" class="table table-hover">
        <thead>
            <tr>
                <th>ID LIMPIEZA</th>
                <th>USUARIO</th>
                <th>ID HORARIO</th>
                <th>L</th>
                <th>M</th>
                <th>M</th>
                <th>J</th>
                <th>V</th>
                <th>S</th>
                <th>D</th>
                <th>FECHA INICIO</th>
                <th>FECHA FIN</th>
                <th>HORA INICIO</th>
                <th>HORA FIN</th>
                <th>PERIODO</th>
                <th>LABORATORIO</th>
                <th>ACCIONES</th>  
            </tr>
        </thead>
        <%
            LimpiezaDAO dao = new LimpiezaDAO();
            List<Limpieza>list = dao.listar();
            Iterator<Limpieza>iter = list.iterator();
            Limpieza limp = null;
            while(iter.hasNext()){
            limp=iter.next();           
        %>
        <tbody>
            <tr>
                <td><%= limp.getLimpiezaid()%></td>
                <td><%= limp.getNombre()%></td>
                <td><%= limp.getHorarioid()%></td>
                <td><%= limp.getLunes()%></td>
                <td><%= limp.getMartes()%></td>
                <td><%= limp.getMiercoles()%></td>
                <td><%= limp.getJueves()%></td>
                <td><%= limp.getViernes()%></td>
                <td><%= limp.getSabado()%></td>
                <td><%= limp.getDomingo()%></td>
                <td><%= limp.getFecha_inicio() %></td>
                <td><%= limp.getFecha_final()%></td>
                <td><%= limp.getHoraInicio() %></td>
                <td><%= limp.getHoraFin()%></td>
                <td><%= limp.getPerdiodo()%></td>
                <td><%= limp.getLaboratorio()%></td>
                <td>
                    <a href="ordenanza?tipo=editarLimpieza&limpiezaid=<%= limp.getLimpiezaid()%>" class="btn btn-xs btn-warning"><i class="fa fa-pencil"></i></a>
                    <a href="#"  class="btn btn-xs btn-danger pl-<%= limp.getLimpiezaid()%>" onclick="$('.pl-<%= limp.getLimpiezaid()%>').toggle()"><i class="fa fa-close"></i></a>
                    <a style="display:none;" href="Controlador?accion=eliminar&limpiezaid=<%= limp.getLimpiezaid()%>"  class="btn btn-xs btn-danger pl-<%=limp.getLimpiezaid()%>" >Seguro?</a>
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
    </body>
</html>
