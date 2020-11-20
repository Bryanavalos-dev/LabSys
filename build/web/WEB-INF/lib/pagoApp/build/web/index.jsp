<%-- 
    Document   : index
    Created on : 09-18-2020, 01:43:07 PM
    Author     : gerson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAGADURIA UTEC</title>
    </head>
    <body>
        <h1>PAGADURIA UTEC</h1>
        <form method="post" action="PagoServlet">
            <table>
        	<tbody>
        		<tr>
        			<td>Nombre del empleado:</td>
        			<td><input type="text" name="txtNombre" value="" placeholder="Escriba su nombre"></td>
        		</tr>
                        <tr>
        			<td>Pago por hora:</td>
        			<td><input type="text" name="txtPago" value="" placeholder="¿Cuanto le pagan por hora?"></td>
        		</tr>
        		<tr>
        			<td>Cantidad de horas trabajadas:</td>
        			<td><input type="text" name="txtHoras" value="" placeholder="¿Cuántas horas trabajo?"></td>
        		</tr>
                        <tr>
                            <td colspan="2">
                                <button type="submit"> calcular</button>
                            </td>
                        </tr>
        	</tbody>
        </table>
        </form>
        
        
        
        
    </body>
</html>
