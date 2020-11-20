<%-- 
    Document   : verificaSesion
    Created on : 11-14-2020, 09:00:14 AM
    Author     : gerson
--%>
<%@page session="true"%>
<%
if(session.getAttribute("logged")==null){ 
    String url = request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/"+"index.jsp";
    // RequestDispatcher mostrar = request.getRequestDispatcher(url);
     //request.setAttribute("mensaje", "inicie sesion");
     //mostrar.forward(request, response);
    response.sendRedirect(request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/"+"index.jsp?mensaje=inicie sesion para continuar");
}
%>
