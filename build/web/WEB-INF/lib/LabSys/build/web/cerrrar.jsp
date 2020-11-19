<%-- 
    Document   : cerrrar
    Created on : nov 15, 2020, 3:46:51 p.m.
    Author     : bryan
    --%>
    <%@page session="true"%>
    <%
    session.invalidate();
    response.sendRedirect("index.jsp");
    %>
