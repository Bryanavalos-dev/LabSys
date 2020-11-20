<%-- 
    Document   : index
    Created on : oct 19, 2020, 5:41:29 p.m.
    Author     : bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta charset="UTF-8">
        <style>
            body{
                background-color: #5A1533;
                color:white;
                font-size: 40px;
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
        </style>
    </head>
    <body>
         <table style="float: right; font-size: 20px;">
	<tbody>
		<tr>
<td>Jose Alexander Villeda Bernal</td>
<td>2533702018</td>
</tr><tr>
<td>César Fernando Molina Matas  </td>
<td>2514342018</td>
</tr><tr>
<td>Uribe Landaverde Jenniffer Vanessa</td>
<td>1700632010</td>
</tr><tr>
<td>Parada Franco Jorge Alirio</td>
<td>2522432018</td>
</tr><tr>
<td>Gabriela esmeralda Rodríguez Bonilla</td>
<td>2546622017</td>
</tr><tr>
<td>Clímaco Oliva, Fernando Alberto </td>
<td>2507272016</td>
</tr><tr>
<td>Brayan Alexander Valiente Sorto</td>
<td>2533852018</td>
</tr><tr>
<td>Gerson Jonadab Alvarado Portillo</td>
<td>2530992013</td>
</tr><tr>
<td> Guillermo Antonio Torres Morales</td>
<td>25-3135-2018</td>
</tr><tr>
<td>Bryan Steve Avalos Acosta </td>
<td>25-3519-2017</td>
</tr><tr>
<td>Christian Manuel Campos Montes</td>
<td>2552302017</td>
</tr>
	</tbody>
</table>
        <br>
    <center>
        <img src="https://www.utec.edu.sv/assets/img/commons/utec_brand.png" />
    </center>
    <a style='text-decoration:none; color:white;' href="controlador?opcion=estu&peticion=l&carnet=&ciclo=">Listado de estudiantes</a><br>
    <a style='text-decoration:none; color:white;' href="controlador?opcion=mate&peticion=l&carnet=&ciclo=">Listado de materias</a>
       <center>
           <form action="controlador" method="get">
            <table style='border:solid 1px black'>
                
                <tr>
                    <td>Carnet: </td>
                <input type="hidden" autocomplete="off" name="opcion"/>
                    <td> <input type="text" autocomplete="off" name="carnet"/></td>
                 </tr>
                 
                 <tr>
                      <td> Ciclo: </td>
                      <td> <input type="text"  autocomplete="off" name="ciclo"/> </td>
                 </tr>
                 
                 <tr>
                       
                     <td colspan="2"> <input type="submit" value="Consultar" style='width:200px; height:25px' /> </td>
                 </tr>
                
            </table>
            
        </form>
       </center> 
    </body>
</html>
