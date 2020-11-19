<%-- 
    Document   : verificaSesion
    Created on : 11-14-2020, 09:00:14 AM
    Author     : gerson
--%>
<%@page import="modelo.Usuarios"%>
<%

    try{
            Usuarios logeado = (Usuarios)session.getAttribute("usuario");
            if(logeado==null){ 
                String url = request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/"+"index.jsp";
                // RequestDispatcher mostrar = request.getRequestDispatcher(url);
                 //request.setAttribute("mensaje", "inicie sesion");
                 //mostrar.forward(request, response);
                response.sendRedirect(request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/"+"index.jsp?mensaje=inicie sesion para continuar");
                out.print("No tiene acceso");
                return;                
            }

    }catch(Exception e){
        String url = request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/"+"index.jsp";
        response.sendRedirect(request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/"+"index.jsp?mensaje=inicie sesion para continuar");
    }
%>
