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
		<th>Nombre Materia</th>
		<th>Ciclo</th>
		<th>Nota 1</th>
		<th>Nota 2</th>
		<th>Nota 3</th>
		<th>Promedio</th>
		<th>Estado</th>
	</tr>
        
        <%
        EstudiantesDAO daoEstudiantes = new EstudiantesDAO();
                    
                    ArrayList<Estudiantes> listadoEstudiantes = daoEstudiantes.getListadoEstudiantesQuery("select carnet, e.nombre nombreestu, m.nombremateria nombremateria, ciclo, nota1, nota2, nota3 from estudiantes e inner join notas n on e.idestudiante = n.estudiante inner join materias m on m.idmateria = n.materia where carnet like '%"+carnet+"%' and ciclo like '%"+ciclo+"%'");
                    
                    //Estudiantes e = new Estudiantes("216-45464", "Vegeta sss", "Sajajin for dumies", "Ciclo 1", 5.2, 6.2, 3, 4.5, "asdsad");
                    //listadoEstudiantes.add(e);

        %>
        
        <% if(listadoEstudiantes.size()>0){ 
        for(Estudiantes est : listadoEstudiantes){
        %>
       <tr>
		<td><%= est.getCarnet()%></td>
		<td><%= est.getNombreestu()%></td>
		<td><%= est.getNombremateria()%></td>
		<td><%= est.getCiclo()%></td>
		<td><%= est.getNota1()%></td>
		<td><%= est.getNota2()%></td>
		<td><%= est.getNota3()%></td>
                
                <td><b style="font-size: 25px;"><%= est.getPromedio()%></b></td>
                <td style="background-color: white;opacity: 0.8;"><%= (est.getPromedio()>=6)?"<i style='color:green'>Aprobada</i>":"<i style='color:red'>Reprobada</i>" %></td>
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
