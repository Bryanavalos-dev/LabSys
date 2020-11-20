<%-- 
    Document   : reporte
    Created on : oct 19, 2020, 6:21:48 p.m.
    Author     : bryan
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Estudiantes"%>
<%@page import="modelo.EstudiantesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <style>
            body{
                background-color: #5A1533;
                color:white;
                font-size: 20px;
            }
            input[type=text]{width: 200px;
            height: 40px;
            margin: 8px;}
            input[type=submit]{
                width: 100% !important;
                font-size: 20px;
                height: 40px !important;
                background-color:white;
                color:#5A1533;
            }
            table tr td{
                padding: 20px;
                text-align: center;
            }
        </style>
    <body>
         <center>
        <img src="https://www.utec.edu.sv/assets/img/commons/utec_brand.png" />
    </center>
        <h1>Listado de estudiantes</h1>
         <%
        if(request.getAttribute("peticion") == "res")
                {
                    
String carnet = request.getAttribute("carnet").toString();
String ciclo = request.getAttribute("ciclo").toString();
                    %>
                   
<table >
	<tr>
		<th>Carnet</th>
		<th>Nombre estudiante</th>
		<th>Ciclo</th>

	</tr>
        
        <%
        EstudiantesDAO daoEstudiantes = new EstudiantesDAO();
                    
                    ArrayList<Estudiantes> listadoEstudiantes = daoEstudiantes.getListadoEstudiantesQuery("select  carnet, e.nombre nombreestu, m.nombremateria nombremateria, ciclo, 0 nota1, 0 nota2, 0 nota3 from estudiantes e inner join notas n on e.idestudiante = n.estudiante inner join materias m on m.idmateria = n.materia  group by carnet order by nombre");
                    
                    //Estudiantes e = new Estudiantes("216-45464", "Vegeta sss", "Sajajin for dumies", "Ciclo 1", 5.2, 6.2, 3, 4.5, "asdsad");
                    //listadoEstudiantes.add(e);

        %>
        
        <% if(listadoEstudiantes.size()>0){ 
        for(Estudiantes est : listadoEstudiantes){
        %>
       <tr>
		<td><%= est.getCarnet()%></td>
		<td><%= est.getNombreestu()%></td>
		
		<td><%= est.getCiclo()%></td>	
	</tr>
        <% }//fin del for
            }else{ %>
        <tr>
            <td colspan="9" style="text-align: center">NO EXISTEN DATOS</td>
        </tr>
        <% } %>
        
</table>

                    <% }%>
        
    </body>
</html>
