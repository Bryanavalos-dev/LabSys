<%-- 
    Document   : pagoHoras
    Created on : 18-sep-2020, 14:36:49
    Author     : cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CALCULO DE PAGOS</title>
        <style>
            body{
                padding: 0;
                margin: 0;
                background-color: #a6bfcc;
                color: black;
                font-family: "helvetica";
                font-size: 20px;
            }
            table{
                background-color: #4b636e;
                color:white;
                border: solid 1px white;
            }
            table tr td{
                padding: 10px;
            }
            input{                         
                width: 80%;
                padding: .375rem .75rem;
                font-size: 1rem;
                line-height: 1.5;
                color: #495057;
                background-color: #fff;
                background-clip: padding-box;
                border: 1px solid #ced4da;
                border-radius: .25rem;
            }
        </style>
    </head>
    <body>
        <div style="background-color: #4b636e;width: 100%;height: 40px;"></div>
        <h2 style="text-align: center; font-size: 40px;">Calcular el Salario conforme a sus horas trabajadas</h2>
      
        <div style="width: 30%; margin: auto; text-align: center;">
            <img style="width: 100%; margin: auto; " src="https://i1.wp.com/enredaccion.com.ar/wp-content/uploads/2018/09/z-dolares-1w.jpg?fit=1000%2C563&ssl=1" />
        </div>
        
        <form action="SrvltLogica" method="POST" style="margin:30px;">
            <table style="width: 60%; margin: auto;">
                <tr>
                    <td>
                        Ingrese su nombre: 
                    </td>
                    <td>
                        <input type="text" name="txtNombre" placeholder="Ingrese su nombre" required="required" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Ingrese el numero de horas trabajadas: 
                    </td>
                    <td>
                        <input type="text" name="txtHorasTrabajadas" placeholder="Ingrese el numero de horas trabajadas" required="required" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Ingrese el pago por hora:
                    </td>
                    <td>
                        <input type="text" name="txtPagoHora" placeholder="Ingrese el pago por hora" required="required" />
                    </td>
                </tr>
                
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <input type="submit" name="btnCalcular" value="Calcular el pago" style="background-color: black; color: white;">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                     <%
                if(request.getAttribute("dibujo") != null)
                {
                    out.print(request.getAttribute("dibujo"));
                }

                %>   
                    </td>
                     
                </tr>   
                
            </table>
          
           
            
        </form>
    </body>
</html>
