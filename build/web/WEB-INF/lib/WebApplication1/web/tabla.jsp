<%-- 
    Document   : tabla
    Created on : 08-17-2020, 09:01:54 AM
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
        <table>
            <tr>
                <td>Gerson Jonadab Alvarado</td>
                <td>25-3099-2013</td>
            </tr>
            <tr>
                <td>Guillermo Antonio Torres Morales</td>
                <td>25-3135-2018</td>
            </tr>
            <tr>
                <td>César Fernando Molina Matas</td>
                <td>25-1434-2018</td>
            </tr>
            
            <tr>
                <td>Fernando Alberto Clímaco Oliva </td>
                <td>25-0727-2016</td>
            </tr>
            
            <tr>
                <td>Jorge Alirio Parada Franco</td>
                <td>25-2243-2018</td>
            </tr>
        </table>
     
    	<%! int numero = 0; %>
    	<%! int inicial = 0; %>
    	<% if(request.getParameter("btnEnviar")!= null){                      
    			%>

    			<% if(request.getParameter("txtNumeroFinal")=="" || request.getParameter("txtNumero")=="" ){%>
    			<tr><td colspan="2">No puede dejar valores en blanco</td></tr>
    			<% return;} %>

    			<%
    			numero =  Integer.parseInt(request.getParameter("txtNumeroFinal"));
    			inicial =  Integer.parseInt(request.getParameter("txtNumero"));
    			%>
                        <% } %>
    	<form action="tabla.jsp" method="post" >
    		<table border="1">
    			<tr>
    				<td colspan="2">Tablas de multiplicar</td>
    			</tr>
    			<tr>
    				<td>
    					Ingresar el numero de tabla inicio
    				</td>
    				<td>
                                    <input type="text" name="txtNumero" placeholder="Ingrese en numero tabla"  />
    				</td>
    			</tr>
    			<tr>
    				<td>
    					Ingresar el numero fin
    				</td>
    				<td>
    					<input type="text" name="txtNumeroFinal" placeholder="Ingrese en numero tabla" />
    				</td>
    			</tr>
    			<tr>
    				<td>
    					<button name="btnEnviar" type="submit">Vertical</button>
    				</td>
    				<td>
    					<button name="btnHorizontal" type="submit">Horizontal</button>
    				</td>
    			</tr>
                </table>
    			
            <% if(request.getParameter("btnHorizontal")!= null){                      
    			%>
                       <table border="1">
                     
    			<% if(inicial>numero){%>
    			<tr><td colspan="2"> El valor de inicial <%= inicial %> es mayor que <%= numero %>, ingrese de forma correcta</td></tr>
    			<% return;} %>
                        
                        <% 
                            int contador=Integer.parseInt(request.getParameter("txtNumero"));
                        numero =  Integer.parseInt(request.getParameter("txtNumeroFinal"));
                        %>
                        
                        <tr>
                        <% for (int i = contador; i <= numero; i++) {%>
                        <td>Tabla del: <%= i  %></td>
                        <%if(i != numero){%><td>&nbsp;&nbsp;</td><% } %>     
                        <% } %>     
                        
                        </tr>
                        
                        <% for (int j = 1; j <= 10; j++) {%>
                        <tr>
                            <% for (int i = contador; i <= numero; i++) {%>
                                <td><%=i%> * <%=j%> = <%= i*j %></td>
                                <%if(i != numero){%><td>&nbsp;&nbsp;</td><% } %> 
                            <% } %> 
                            
                        </tr>
                        <% } %>                                           
                        
                        
                        
                        
                        <% }//fin del if horizontal %>
    			


    			<% if(request.getParameter("btnEnviar")!= null){                      
    			%>
                        <table border="1">
                        <tr>
                            <td colspan="2">
    					&nbsp; 
    				</td>
                        </tr>
    			<% if(inicial>numero){%>
    			<tr><td colspan="2"> El valor de inicial <%= inicial %> es mayor que <%= numero %>, ingrese de forma correcta</td></tr>
    			<% return;} %>

    			<%
    			int contador=Integer.parseInt(request.getParameter("txtNumero"));
    			while(contador<=numero){%>
    			<tr>
    				<th>
    					Numero de la tabla:
    				</th>
                                <th>
                                    
                                    <%= contador %>
                                    
                                </th>
    			</tr>
    		
    			<%
    			for (int i = 1; i <= 10; i++) {%>
    			<tr>
    				<td colspan="2">
    					<%= contador %> x <%= i %> = <%= contador*i %>
    				</td>
    			</tr>
    			<% }
    			%>

<tr>
    				<td colspan="2">
    					&nbsp; 
    				</td>
    			</tr>

    			<% 
    			contador++;}  %>

            </table>

    			<% } %>


    		
    	</form>

    </body>
    </html>
