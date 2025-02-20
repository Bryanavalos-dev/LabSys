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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Limpieza;
import modeloDAO.LimpiezaDAO;

/**
 *
 * @author George
 */
@WebServlet(name = "ordenanza", urlPatterns = {"/ordenanza"})
public class ordenanza extends HttpServlet {

    String listar="vistas/ordenanza/limpieza.jsp";
    String add="vistas/ordenanza/agregarLimpieza.jsp";
    String edit="vistas/ordenanza/editarLimpieza.jsp";
    Limpieza l = new Limpieza();
    LimpiezaDAO lDAO = new LimpiezaDAO();
    int id;
    
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
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ordenanza</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ordenanza at " + request.getContextPath() + "</h1>");
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
            case "limpieza":
                mostrar = request.getRequestDispatcher("vistas/ordenanza/limpieza.jsp");
                mostrar.forward(request, response);
                break;
            case "agregarLimpieza":
                mostrar = request.getRequestDispatcher("vistas/ordenanza/agregarLimpieza.jsp");
                mostrar.forward(request, response);
                break;
            case "editarLimpieza":
                    request.setAttribute("idper",request.getParameter("id"));
                    mostrar = request.getRequestDispatcher("vistas/ordenanza/editarLimpieza.jsp");
                    mostrar.forward(request, response);
                default:
                    mostrar = request.getRequestDispatcher("vistas/ordenanza/ordenanza.jsp");
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
        int lab, periodo,id,horario,user,state;
        
          Limpieza li = new Limpieza();
        LimpiezaDAO lid = new LimpiezaDAO();
         switch(accion){
         case "modificarLimpieza":
                    request.setAttribute("idper",request.getParameter("id"));
                    li = new Limpieza();
                    id=Integer.parseInt(request.getParameter("txtId"));
                    li.setLimpiezaid(id);
                    
                   state = Integer.parseInt(request.getParameter("sltEstado"));                    
                    li.setEstado(state);
                    
                   
                   
                  
               
                    
                    lid.edita(li) ;                 
                    
                    response.sendRedirect("ordenanza?tipo=limpieza");
                   
                    
                  break;
                                       
             default:
                    mostrar = request.getRequestDispatcher("vistas/ordenanza/ordenanza.jsp");
                    mostrar.forward(request, response);
                 break;
    }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
