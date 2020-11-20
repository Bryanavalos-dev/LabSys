<%-- 
    Document   : index
    Created on : 09-14-2020, 08:22:43 AM
    Author     : gerson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="SvrlTablas" method="post">
            <table border="1">
            <tbody>
                <tr>
                    <td>
                        Ingrese la tabla de inicio
                    </td>
                    <td>
                        <input type="text" name="txtTablaInicio" placeholder="Ingrese tabla inicio" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Ingrese la tabla de fin
                    </td>
                    <td>
                        <input type="text" name="txtTablaFin" placeholder="Ingrese tabla fin" />
                    </td>
                </tr>
                
                <tr>                    
                    <td colspan="2">
                        <input type="submit" value="enviar" />
                    </td>
                </tr>
            </tbody>
                
        </table>
        </form>
        
    </body>
</html>
