package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/bs.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<title>Sistema de control de limpieza</title>\n");
      out.write("\t");
      out.write("\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js\" integrity=\"sha512-WNLxfP/8cVYL9sj8Jnp6et0BkubLP31jhTG9vhL/F5uEZmg5wEzKoXp1kJslzPQWwPT1eyMiSxlKCgzHLOTOTQ==\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <!-- Latest compiled and minified CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap.min.css\">\n");
      out.write("\n");
      out.write("    <!-- Optional theme -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">\n");
      out.write("    <!-- Latest compiled and minified JavaScript -->\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap.min.js\"></script>");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body style=\"background-image: url('https://lh3.googleusercontent.com/proxy/HXLm0JVtoFN_GzXJxK2Csey41sR-ZfqUxpxlQPuZcJS2QzrdkI6zzS7VzDMzaALSxgzSZ-9mZKi4ZPQPuZYV8Otni0iatO7kmYqg9PNHEL4u72KXTA'); background-size: cover\">\n");
      out.write("\t<form action=\"controlador\" method=\"post\" accept-charset=\"utf-8\" clas=\"form\" style=\"width: 50%; margin:  0 auto;\">\n");
      out.write("\t\t<table class=\"table\" style='background-color: white; opacity: 0.9; margin-top: 50px;'>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td colspan=\"2\" style=\"text-align: center\"><h3>Sistema de control de laboratorios</h3></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>correo: </td>\n");
      out.write("\t\t\t\t<td><input required=\"\" class=\"form-control\" type=\"mail\" name=\"correo\" id=\"correo\" value=\"\" placeholder=\"Ingrese su correo\"></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>Password: </td>\n");
      out.write("\t\t\t\t<td><input required=\"\" class=\"form-control\" type=\"password\" name=\"password\" id=\"password\" value=\"\" placeholder=\"Ingrese su password\"></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td colspan=\"2\"><button type=\"submit\" class=\"btn btn-success btn-block\">Ingresar</button></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t\t<input type=\"hidden\" name=\"accion\" id=\"accion\" value=\"login\">\n");
      out.write("\t\t");
 if((request.getAttribute("mensaje") != null) || (request.getParameter("mensaje") != null)){
      out.write("\n");
      out.write("\t\t<div class=\"alert alert-warning text-center\">\n");
      out.write("\t\t\t");
      out.print( (request.getAttribute("mensaje") != null)?request.getAttribute("mensaje"):"" );
      out.write("\n");
      out.write("\t\t\t");
      out.print( (request.getParameter("mensaje") != null)?request.getParameter("mensaje"):"" );
      out.write("                    \n");
      out.write("\t\t</div>\n");
      out.write("\t\t");
 } 
      out.write("\n");
      out.write("\n");
      out.write("\t</form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
