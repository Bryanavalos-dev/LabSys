<%-- 
    Document   : admin
    Created on : 11-14-2020, 10:19:25 AM
    Author     : gerson
    --%>
    <%@ include file="../verificaSesion.jsp" %>
    <%@page import="modelo.Usuarios"%>
    <%
    Usuarios u =  (Usuarios)session.getAttribute("usuario");
    
    if((long)u.getIdrol()!=1){ 
    String url = request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/"+"index.jsp";
                 response.sendRedirect(request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/"+"index.jsp?mensaje=inicie sesion para continuar");
                 out.print("No tiene acceso");
                 return;                
               }

               %>
               <%@page contentType="text/html" pageEncoding="UTF-8"%>
               <!DOCTYPE html>
               <html>
               <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Administrador</title>
                <%@ include file="../../bs.jsp" %>
              </head>
              <body>

                <nav class="navbar navbar-inverse navbar-fixed-top">
                  <div class="container">
                    <div class="navbar-header">
                      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                      </button>
                      <a class="navbar-brand" href="admin">SCL - Admin</a>
                    </div>
                    <div id="navbar" class="collapse navbar-collapse">
                      <ul class="nav navbar-nav">
                        
                        <li class="active"><a href="admin?tipo=roles">Roles</a></li>
                         <li class="active"><a href="admin?tipo=edificios">Edificios</a></li>
                         <li class="active"><a href="admin?tipo=estados">Estados</a></li>
                          <li class="active"><a href="admin?tipo=periodos">Periodos</a></li>
                          <li class="active"><a href="admin?tipo=laboratorios">Laboratorios</a></li>
                          <li class="active"><a href="admin?tipo=usuarios">Usuarios</a></li>
                          <li class="active"><a href="admin?tipo=asignaciones">Asignaciones</a></li>
                   
                        <li><a href="cerrrar.jsp">Salir</a></li>
                      </ul>
                    </div><!--/.nav-collapse -->
                  </div>
                </nav>

                <div class="container" style="margin-top: 60px;">
                  <div class="row">
                    