/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelo.Edificios;
import modeloDAO.EdificiosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author bryan
 */

public class Controlador_Edificios extends HttpServlet {
     String listar="vistas/administrador/listar.jsp";
    String add="vistas/administrador/add.jsp";
    String edit="vistas/administrador/edit.jsp";
    Edificios p=new Edificios();
    EdificiosDAO dao=new EdificiosDAO();
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
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_Edificios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_Edificios at " + request.getContextPath() + "</h1>");
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
        String acceso="";
        String action=request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")){
            acceso=listar;
        }
        else if (action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if (action.equalsIgnoreCase("Agregar")){
            String nom=request.getParameter("txtNombre");
            p.setNombre(nom);
            dao.add(p);
            acceso=listar;
        }    
        else if (action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=edit;
        }
        else if (action.equalsIgnoreCase("Actualizar")){
            int Id=Integer.parseInt(request.getParameter("txtId"));
            String Nombre=request.getParameter("txtNombre");
            p.setId(Id);
            p.setNombre(Nombre);
            dao.edit(p);
            acceso=listar;
            
        }
        else if (action.equalsIgnoreCase("eliminar")){
            int Id=Integer.parseInt(request.getParameter("id"));
            p.setId(Id);
            dao.eliminar(Id);
            acceso=listar;
            
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
        
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
