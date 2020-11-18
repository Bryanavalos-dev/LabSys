package org.apache.jsp.vistas.encargado;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Periodo;
import modeloDAO.PeriodoDAO;
import modelo.Laboratorios;
import modeloDAO.LaboratoriosDAO;
import modelo.Usuarios;
import modelo.Usuarios;
import java.util.Iterator;
import java.util.List;
import modeloDAO.UsuariosDAO;
import modelo.Usuarios;
import modeloDAO.RolesDAO;
import modelo.Roles;

public final class agregarHorarios_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/vistas/encargado/header.jsp");
    _jspx_dependants.add("/vistas/encargado/../verificaSesion.jsp");
    _jspx_dependants.add("/vistas/encargado/../../bs.jsp");
    _jspx_dependants.add("/vistas/encargado/footer.jsp");
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
      response.setContentType("text/html");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");
      out.write('\n');
      out.write('\n');


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

      out.write('\n');
      out.write("\n");
      out.write("    \n");
      out.write("    ");

    Usuarios u =  (Usuarios)session.getAttribute("usuario");
    
    if((long)u.getIdrol()!=2){ 
    String url = request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/"+"index.jsp";
                // RequestDispatcher mostrar = request.getRequestDispatcher(url);
                 //request.setAttribute("mensaje", "inicie sesion");
                 //mostrar.forward(request, response);
                 response.sendRedirect(request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/"+"index.jsp?mensaje=inicie sesion para continuar");
                 out.print("No tiene acceso");
                 return;                
               }

               
      out.write("\n");
      out.write("               \n");
      out.write("               <!DOCTYPE html>\n");
      out.write("               <html>\n");
      out.write("               <head>\n");
      out.write("                <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("                <title>Administrador</title>\n");
      out.write("                ");
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
      out.write("              </head>\n");
      out.write("              <body>\n");
      out.write("\n");
      out.write("                <nav class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("                  <div class=\"container\">\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                      <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                      </button>\n");
      out.write("                      <a class=\"navbar-brand\" href=\"#\">SCL - Encargado</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"navbar\" class=\"collapse navbar-collapse\">\n");
      out.write("                      <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li class=\"active\"><a href=\"encargado\">Inicio</a></li>\n");
      out.write("                        <li class=\"active\"><a href=\"encargado?tipo=horarios\">Horarios</a></li>\n");
      out.write("                         \n");
      out.write("                        <li><a href=\"cerrrar.jsp\">Salir</a></li>\n");
      out.write("                      </ul>\n");
      out.write("                    </div><!--/.nav-collapse -->\n");
      out.write("                  </div>\n");
      out.write("                </nav>\n");
      out.write("\n");
      out.write("                <div class=\"container\" style=\"margin-top: 60px;\">\n");
      out.write("                  <div class=\"row\">\n");
      out.write("                    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"col\"> <div>\n");
      out.write("\n");
      out.write("        ");

                  
                     
                      PeriodoDAO daor= new PeriodoDAO();
                    List<Periodo>listr=daor.listar();
                    Iterator<Periodo>iterr=listr.iterator();
                    Periodo perr=null;
                       
                    LaboratoriosDAO dao= new LaboratoriosDAO();
                    List<Laboratorios>list=dao.listar();
                    Iterator<Laboratorios>iter=list.iterator();
                    Laboratorios per=null;
                                               
                
      out.write("      \n");
      out.write("        <h1>Agregar Usuarios</h1>\n");
      out.write("        <form action=\"admin?tipo=agregarUsuario\" method=\"post\">\n");
      out.write("           <h1 class=\"fw-300 centrar-texto  \">Programar horario</h1>\n");
      out.write("        <div class=\"check\">\n");
      out.write("        Seleccione el laboratorio a asignar:\n");
      out.write("         <input class=\"form-control\" type=\"checkbox\" name=\"chkLunes\" value=\"1\">Lunes\n");
      out.write("         <input class=\"form-control\" type=\"checkbox\" name=\"chkMartes\" value=\"1\">Martes\n");
      out.write("         <input class=\"form-control\" type=\"checkbox\" name=\"chkMiercoles\" value=\"1\">Miercoles\n");
      out.write("         <input class=\"form-control\" type=\"checkbox\" name=\"chkJueves\" value=\"1\">Jueves\n");
      out.write("         <input class=\"form-control\" type=\"checkbox\" name=\"chkViernes\" value=\"1\">Viernes\n");
      out.write("         <input class=\"form-control\" type=\"checkbox\" name=\"chkSabado\" value=\"1\">Sabado\n");
      out.write("         <input class=\"form-control\" type=\"checkbox\" name=\"chkDomingo\" value=\"1\">Domingo\n");
      out.write("         </div>\n");
      out.write("         \n");
      out.write("        \n");
      out.write("       \n");
      out.write("        <input class=\"form-control\" type=\"date\" name=\"fecha\" min=\"2018-03-25\" max=\"2050-05-25\" step=\"1\" />\n");
      out.write("       \n");
      out.write("       \n");
      out.write("        <input class=\"form-control\" type=\"time\" name=\"horainicio\" min=\"00:00\" max=\"24:00\" step=\"60\" />\n");
      out.write("       \n");
      out.write("        <input class=\"form-control\" type=\"time\" name=\"horafin\" min=\"00:00\" max=\"24:00\" step=\"60\" />\n");
      out.write("  \n");
      out.write("        <select name=\"lab\">\n");
      out.write("            <option value='' selected disable>Seleccione el laboratorio</option>\n");
      out.write("        ");
   while (iter.hasNext ()){
                            per=iter.next();   
                
      out.write("\n");
      out.write("                <option value='");
      out.print(per.getCodigo());
      out.write('\'');
      out.write('>');
      out.print( per.getNombre());
      out.write("</option>\n");
      out.write("                 ");
 }
      out.write("//fin del while\n");
      out.write("                            </select>\n");
      out.write("      \n");
      out.write("        <select name=\"periodo\">\n");
      out.write("            <option value='' selected disable>Seleccione el periodo</option>\n");
      out.write("        ");
   while (iterr.hasNext ()){
                      perr=iterr.next();   
                
      out.write("\n");
      out.write("                <option value='");
      out.print(perr.getId());
      out.write('\'');
      out.write('>');
      out.print( perr.getNom());
      out.write("</option>\n");
      out.write("                 ");
 }
      out.write("//fin del while\n");
      out.write("                    \n");
      out.write("        </select>\n");
      out.write("            <input class=\"form-control\" type=\"date\" name=\"fecha\" min=\"2018-03-25\" max=\"2050-05-25\" step=\"1\" />\n");
      out.write("         \n");
      out.write("           \n");
      out.write("            <input class=\"btn btn-success\" type=\"submit\" name=\"accion\" value=\"agregarUsuario\"><br>\n");
      out.write("        </form>          \n");
      out.write("        </div>\n");
      out.write("</div>\n");
      out.write("                 \n");
      out.write("\n");
      out.write("                    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div><!-- /.container -->\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
      out.write('\n');
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
