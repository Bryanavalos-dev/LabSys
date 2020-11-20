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
import modelo.Usuarios;
import modeloDAO.LoginDao;

/**
 *
 * @author gerson
 */
public class controlador extends HttpServlet {
    

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
            throws ServletException, IOException {
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
        HttpSession session= request.getSession(true);
        processRequest(request, response);
         String accion = request.getParameter("accion");
         
         switch(accion){
             case "login":
                 String c= request.getParameter("correo");
                 String p = request.getParameter("password");;
                 LoginDao l = new LoginDao(c, p);
                 
                 if(l.login()){
                     Usuarios u = new Usuarios();
                     u = l.getUsuario();
                     session.setAttribute("logged", true);
                     session.setAttribute("usuario", u);
                     if(u.getIdrol()==1){
                         RequestDispatcher mostrar = request.getRequestDispatcher("vistas/administrador/admin.jsp");
                         request.setAttribute("mensaje","Bienvenido administrador");
                         mostrar.forward(request, response);
                     }else{
                        RequestDispatcher mostrar = request.getRequestDispatcher("index.jsp");
                        request.setAttribute("mensaje","Usuario o password incorrecto");
                        mostrar.forward(request, response);
                     }
                  
                 }else{
                      RequestDispatcher mostrar = request.getRequestDispatcher("index.jsp");
                    request.setAttribute("mensaje","Usuario o password incorrecto");
                    mostrar.forward(request, response);
                 }
                   
             break;
             default:
             try (PrintWriter out = response.getWriter()) {
                          out.print("Opción no existente");
                      }
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
