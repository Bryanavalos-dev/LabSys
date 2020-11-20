/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Roles;
import modeloDAO.RolesDAO;
import modelo.Edificios;
import modeloDAO.EdificiosDAO;
import modelo.Estado;
import modeloDAO.EstadoDAO;
import modelo.Periodo;
import modeloDAO.PeriodoDAO;
/**
 *
 * @author gerson
 */
public class admin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {/*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet admin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet admin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
          
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        HttpSession session= request.getSession(true);
        RequestDispatcher mostrar;
        String accion = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"";
         
         switch(accion){
               case "periodos":
                    mostrar = request.getRequestDispatcher("vistas/administrador/periodos.jsp");
                    mostrar.forward(request, response);
                 break;
                  case "agregarPeriodos":                    
                    mostrar = request.getRequestDispatcher("vistas/administrador/agregarPeriodos.jsp");
                    mostrar.forward(request, response);
                  break;
                  case "eliminarPeriodo":
                    request.setAttribute("idper",request.getParameter("id"));
                    PeriodoDAO ed = new PeriodoDAO();
                    int idd=Integer.parseInt(request.getParameter("id"));
                    ed.eliminar(idd);
                    
                     response.sendRedirect("admin?tipo=periodos");
                  break;
                  case "editarPeriodo":
                    request.setAttribute("idper",request.getParameter("id"));
                    mostrar = request.getRequestDispatcher("vistas/administrador/editarPeriodos.jsp");
                    mostrar.forward(request, response);
                  break;
              case "estados":
                    mostrar = request.getRequestDispatcher("vistas/administrador/estados.jsp");
                    mostrar.forward(request, response);
                 break;
                  case "agregarEstados":                    
                    mostrar = request.getRequestDispatcher("vistas/administrador/agregarEstados.jsp");
                    mostrar.forward(request, response);
                  break;
                  case "eliminarEstado":
                    request.setAttribute("idper",request.getParameter("id"));
                    EstadoDAO edd = new EstadoDAO();
                    int iddd=Integer.parseInt(request.getParameter("id"));
                    edd.eliminar(iddd);
                    
                     response.sendRedirect("admin?tipo=estados");
                  break;
                  case "editarEstado":
                    request.setAttribute("idper",request.getParameter("id"));
                    mostrar = request.getRequestDispatcher("vistas/administrador/editarEstados.jsp");
                    mostrar.forward(request, response);
                  break;
             case "roles":
                    mostrar = request.getRequestDispatcher("vistas/administrador/roles.jsp");
                    mostrar.forward(request, response);
                 break;
                 case "agregarRoles":                    
                    mostrar = request.getRequestDispatcher("vistas/administrador/agregarRoles.jsp");
                    mostrar.forward(request, response);
                  break;
                 case "eliminarRol":
                    request.setAttribute("idper",request.getParameter("id"));
                    RolesDAO rd = new RolesDAO();
                    int id=Integer.parseInt(request.getParameter("id"));
                    rd.eliminar(id);
                    
                     response.sendRedirect("admin?tipo=roles");
                  break;
                  case "modificarRol":
                    request.setAttribute("idper",request.getParameter("id"));
                    mostrar = request.getRequestDispatcher("vistas/administrador/editarRoles.jsp");
                    mostrar.forward(request, response);
                  break;
             case "edificios":
                    mostrar = request.getRequestDispatcher("vistas/administrador/edificios.jsp");
                    mostrar.forward(request, response);
                 break;
                  case "agregarEdificios":                    
                    mostrar = request.getRequestDispatcher("vistas/administrador/agregarEdificios.jsp");
                    mostrar.forward(request, response);
                  break;
                 case "eliminarEdificio":
                    request.setAttribute("idper",request.getParameter("id"));
                    EdificiosDAO edi = new EdificiosDAO();
                    int ide=Integer.parseInt(request.getParameter("id"));
                    edi.eliminar(ide);
                    
                     response.sendRedirect("admin?tipo=edificios");
                  break;
                  case "modificarEdificios":
                    request.setAttribute("idper",request.getParameter("id"));
                    mostrar = request.getRequestDispatcher("vistas/administrador/editarEdificios.jsp");
                    mostrar.forward(request, response);
                  break;
            
             default:
                    mostrar = request.getRequestDispatcher("vistas/administrador/admin.jsp");
                    mostrar.forward(request, response);
                 break;
         
         }
        
         
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           processRequest(request, response);
        HttpSession session= request.getSession(true);
        RequestDispatcher mostrar;
        String accion = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"";
         Roles r = new Roles();
         Edificios ed = new Edificios();
         EdificiosDAO red = new EdificiosDAO();
          RolesDAO rd = new RolesDAO();
           int id;
             Estado es = new Estado();
          EstadoDAO eds = new EstadoDAO();
          
           Periodo pe = new Periodo();
          PeriodoDAO ped = new PeriodoDAO();
         switch(accion){
              case "agregarPeriodo":
                    
                    pe.setNom(request.getParameter("txtNombre"));                    
                    ped.add(pe);
                    
                    response.sendRedirect("admin?tipo=periodos");
                    //mostrar = request.getRequestDispatcher("vistas/administrador/editarRoles.jsp");
                    
                    //mostrar.forward(request, response);
                    
                  break;
                  case "modificarPeriodo":
                    request.setAttribute("idper",request.getParameter("id"));
                     pe = new Periodo();
                    id=Integer.parseInt(request.getParameter("txtId"));
                    pe.setId(id);
                    pe.setNom(request.getParameter("txtNombre"));                    
                    ped.edit(pe);                    
                    response.sendRedirect("admin?tipo=periodos");
                    //mostrar = request.getRequestDispatcher("vistas/administrador/editarRoles.jsp");
                    
                    //mostrar.forward(request, response);
                    
                  break;
              case "agregarEstado":
                    
                    es.setNom(request.getParameter("txtNombre"));                    
                    eds.add(es);
                    
                    response.sendRedirect("admin?tipo=estados");
                    //mostrar = request.getRequestDispatcher("vistas/administrador/editarRoles.jsp");
                    
                    //mostrar.forward(request, response);
                    
                  break;
                  case "modificarEstado":
                    request.setAttribute("idper",request.getParameter("id"));
                     es = new Estado();
                    id=Integer.parseInt(request.getParameter("txtId"));
                    es.setId(id);
                    es.setNom(request.getParameter("txtNombre"));                    
                    eds.edit(es);                    
                    response.sendRedirect("admin?tipo=estados");
                    //mostrar = request.getRequestDispatcher("vistas/administrador/editarRoles.jsp");
                    
                    //mostrar.forward(request, response);
                    
                  break;
             case "agregarRol":
                    
                    r.setNom(request.getParameter("txtNombre"));                    
                    rd.add(r);
                    
                    response.sendRedirect("admin?tipo=roles");
                    //mostrar = request.getRequestDispatcher("vistas/administrador/editarRoles.jsp");
                    
                    //mostrar.forward(request, response);
                    
                  break;
                  case "modificarRol":
                    request.setAttribute("idper",request.getParameter("id"));
                     r = new Roles();
                     id=Integer.parseInt(request.getParameter("txtId"));
                    r.setId(id);
                    r.setNom(request.getParameter("txtNombre"));                    
                    rd.edit(r);                    
                    response.sendRedirect("admin?tipo=roles");
                    //mostrar = request.getRequestDispatcher("vistas/administrador/editarRoles.jsp");
                    
                    //mostrar.forward(request, response);
                    
                  break;
                   case "agregarEdificio":
                    
                    ed.setNombre(request.getParameter("txtNombre"));                    
                    red.add(ed);
                    
                    response.sendRedirect("admin?tipo=edificios");
                    //mostrar = request.getRequestDispatcher("vistas/administrador/editarRoles.jsp");
                    
                    //mostrar.forward(request, response);
                    
                  break;
                  case "modificarEdificio":
                    request.setAttribute("idper",request.getParameter("id"));
                     ed = new Edificios();
                    int ide=Integer.parseInt(request.getParameter("txtId"));
                    ed.setId(ide);
                    ed.setNombre(request.getParameter("txtNombre"));                    
                    red.edit(ed);                    
                    response.sendRedirect("admin?tipo=edificio");
                    //mostrar = request.getRequestDispatcher("vistas/administrador/editarRoles.jsp");
                    
                    //mostrar.forward(request, response);
                    
                  break;
                  
             default:
                    mostrar = request.getRequestDispatcher("vistas/administrador/admin.jsp");
                    mostrar.forward(request, response);
                 break;
    }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
