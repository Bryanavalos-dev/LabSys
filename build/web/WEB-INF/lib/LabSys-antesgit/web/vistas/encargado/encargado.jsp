<%-- 
    Document   : encargado
    Created on : 11-14-2020, 10:19:33 AM
    Author     : gerson
    --%>
    <%@include file="header.jsp" %>
    <div class="col">
    	<h1>Bienvenido <%= u.getNombre() %></h1>

    	<div class="starter-template">

    		<p class="lead">Se encuentra en la secci�n de encargado</p>
    		<div class="row">
    			<a href="encargado?tipo=programar">
    			<div class="col-sm-2">
    				<div style="color:white; border: solid #0080ff 1px; cursor: pointer; text-align: center;background-color: #00b0ff; border-radius: 25px; padding: 15px;">
    					<i class="fa fa-calendar fa-5x" style="color:white;"></i>
    					<br>
    					<br>
    						<b style="font-size: 20px; padding-top: 10px; ">Programar horarios</b>
    					
    				</div>    				
    			</div>
    		</a>


    		</div>
    	</div>
    </div>

    <%@include file="footer.jsp" %>