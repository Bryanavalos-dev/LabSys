<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sistema de control de limpieza</title>
</head>
<body>
	<form action="controlador" method="post" accept-charset="utf-8">
		<table>
			<tr>
				<td colspan="2"><h3>Ingresar credenciales</h3></td>
			</tr>
			<tr>
				<td>correo: </td>
				<td><input type="mail" name="correo" id="correo" value="" placeholder="Ingrese su correo"></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password" id="password" value="" placeholder="Ingrese su password"></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">Ingresar</button></td>
			</tr>
		</table>
		<input type="hidden" name="accion" id="accion" value="login">
                
                <h2><%= (request.getAttribute("mensaje") != null)?request.getAttribute("mensaje"):"" %></h2>
                <h2><%= (request.getParameter("mensaje") != null)?request.getParameter("mensaje"):"" %></h2>
	</form>
</body>
</html>
