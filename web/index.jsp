<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sistema de Control de limpieza.</title>
	<%@include file="bs.jsp"  %>
</head>
<body style="background-image: url('https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.uc.edu.mx%2Flaboratorios-de-computo%2F&psig=AOvVaw3r_-kBVdyolMBhu5OElIvE&ust=1605967276996000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJi29rykke0CFQAAAAAdAAAAABAD'); background-size: cover">
	<form action="controlador" method="post" accept-charset="utf-8" clas="form" style="width: 50%; margin:  0 auto;">
		<table class="table" style='background-color: white; opacity: 0.9; margin-top: 50px;'>
			<tr>
				<td colspan="2" style="text-align: center"><h3>Sistema de control de laboratorios</h3></td>
			</tr>
			<tr>
				<td>correo: </td>
				<td><input required="" class="form-control" type="mail" name="correo" id="correo" value="" placeholder="Ingrese su correo"></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input required="" class="form-control" type="password" name="password" id="password" value="" placeholder="Ingrese su password"></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit" class="btn btn-success btn-block">Ingresar</button></td>
			</tr>
		</table>
		<input type="hidden" name="accion" id="accion" value="login">
		<% if((request.getAttribute("mensaje") != null) || (request.getParameter("mensaje") != null)){%>
		<div class="alert alert-warning text-center">
			<%= (request.getAttribute("mensaje") != null)?request.getAttribute("mensaje"):"" %>
			<%= (request.getParameter("mensaje") != null)?request.getParameter("mensaje"):"" %>                    
		</div>
		<% } %>

	</form> 
</body>
</html>
