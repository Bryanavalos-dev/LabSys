<%-- 
    Document   : ordenanza
    Created on : 11-14-2020, 10:19:42 AM
    Author     : gerson
--%>

<%@include file="header.jsp" %>
    <div class="col">
    	<h1>Bienvenido <%= u.getNombre() %></h1>

    	<div class="starter-template">

    		<p class="lead">Se encuentra en la sección de ordenanza</p>
    		<div class="column">
    			<a href="ordenanza?tipo=programar">
    			<div class="col-sm-2">
    				<div style="color:white; border: solid black 1px; cursor: pointer; text-align: center;background-color: #F6511D; border-radius: 25px; padding: 15px;">
    					<i class="fa fa-calendar fa-5x" style="color:white;"></i>
    					<br>
    					<br>
    						<b style="font-size: 20px; padding-top: 10px; ">Consultar horarios</b>
    					
    				</div>    				
    			</div>
    		</a>


    		</div>
                
    		<div class="column">
    			<a href="encargado?tipo=programar">
    			<div class="col-sm-2">
    				<div style="color:white; border: solid black 1px; cursor: pointer; text-align: center;background-color: #7FB800; border-radius: 25px; padding: 15px;">
    					<i class="fa fa-flag fa-5x" style="color:white;"></i>
    					<br>
    					<br>
    						<b style="font-size: 20px; padding-top: 10px; ">Consultar limpieza</b>
    					
    				</div>    				
    			</div>
    		</a>


    		</div>
    	</div>
    </div>

    <%@include file="footer.jsp" %>
