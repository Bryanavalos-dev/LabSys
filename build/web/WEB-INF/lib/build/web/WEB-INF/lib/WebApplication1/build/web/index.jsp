<%-- 
    Document   : index
    Created on : 07-31-2020, 08:59:13 AM
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
        <%! int estado = 0;  %>
        <%-- Mi primera vez --%>
        <h1>Hello World!</h1>
        <br>
        Usuario: <%= (request.getParameter("txtUsuario") == null)?"Sin asignar":request.getParameter("txtUsuario") %>
        <br>
        Password: <%= request.getParameter("txtClave") %>
        <br>
        Enviar: <%= request.getParameter("btnEnviar") %>
        
        <%
        
          if(request.getParameter("btnEnviar") != null){
                String elUsuario = request.getParameter("txtUsuario");
                String laClave = request.getParameter("txtClave");
                
                if(elUsuario.equals("PROG4") && laClave.equals("SECC02")){
                    out.print("Bienvenido al sistema");
                    estado = 1;
                }
                else{
                    out.print("Error, usuario y/o clave incorrecto");
                }
            }                        
        %>
        
        <% if(estado == 0 ) { %>
            <form action="index.jsp" method="post">
                <br>
                <table>
                    <tr>
                        <td colspan="2">
                            Ingrese tus datos de acceso al sistema
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Usuario: 
                        </td>
                        <td>
                            <input type="text" name="txtUsuario" placeholder="Ingrese el usuario">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Clave:
                        </td>
                        <td>
                            <input type="password" name="txtClave" placeholder="Ingrese la clave">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" name="btnEnviar" value="Enviar">
                        </td>
                    </tr>
                </table>
            </form>
        <% } else { %> El contenido de la pagina  <% } %>
        
        
        
        
    </body>
</html>
