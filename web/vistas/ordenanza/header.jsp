<%-- 
    Document   : admin
    Created on : 11-14-2020, 10:19:25 AM
    Author     : gerson
    --%>
    <%@ include file="../verificaSesion.jsp" %>
    <%@page import="modelo.Usuarios"%>
    <%
    Usuarios u =  (Usuarios)session.getAttribute("usuario");
    
    if((long)u.getIdrol()!=3){ 
    String url = request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/"+"index.jsp";
                // RequestDispatcher mostrar = request.getRequestDispatcher(url);
                 //request.setAttribute("mensaje", "inicie sesion");
                 //mostrar.forward(request, response);
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
                      <a class="navbar-brand" href="#">SCL - Ordenanza</a>
                    </div>
                    <div id="navbar" class="collapse navbar-collapse">
                      <ul class="nav navbar-nav">
                        <li class="active"><a href="encargado">Inicio</a></li>
                        <li class="active"><a href="encargado">Horarios</a></li>
                        <li class="active"><a href="encargado">Limpieza</a></li>
                        <li><a href="cerrrar.jsp">Salir</a></li>
                      </ul>
                    </div><!--/.nav-collapse -->
                  </div>
                </nav>

                <div class="container" style="margin-top: 60px;">
                  <div class="row">
                    