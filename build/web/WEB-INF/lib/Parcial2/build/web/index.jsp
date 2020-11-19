<%-- 
    Document   : index
    Created on : 09-21-2020, 08:40:55 AM
    Author     : gerson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
    
    <table>
            <tr>
                <td>Gerson Jonadab Alvarado</td>
                <td>25-3099-2013</td>
            </tr>
            <tr>
                <td>César Fernando Molina Matas</td>
                <td>25-1434-2018</td>
            </tr>
            <tr>
                <td>Jorge Alirio Parada Franco</td>
                <td>25-2243-2018</td>
            </tr>
        </table>
    
	<form action="ServletProcesar" method="post">
		<table style="border:solid black 1px; padding:8px;margin-bottom: 15px;">
			<tbody>
				<tr>
					<td style="padding-bottom: 10px;">Ingrese cantidad de columnas: </td>
                                        <td><input type="number" min="1" name="txtCol" value="" placeholder=""  required="required"></td>
				</tr>
				<tr>
					<td  style="padding-bottom: 10px;">Ingrese cantidad de filas: </td>
					<td><input type="number" min="1" name="txtFil" value="" placeholder=""  required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" name="btnEnviar" value="Procesar" style="width: 100%; background-color: white;border:solid black 1px; padding:8px;margin-bottom: 5px;margin-top: 5px;">
					</td>
				</tr>
			</tbody>
		</table>	
	</form>
    
     <%
                if(request.getAttribute("data") != null)
                {
                    out.print(request.getAttribute("data"));
                }

                %>   
</body>
</html>