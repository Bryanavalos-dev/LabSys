/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelo.Limpieza;
import modeloDAO.LimpiezaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author George
 */
public class Controlador_Limpieza extends HttpServlet {

    String listar="Vistas/limpieza.jsp";
    String add="Vistas/Agregar_Limpieza.jsp";
    String edit="Vistas/Editar_Limpieza.jsp";
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
            throws ServletException, IOException {
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
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
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if(action.equalsIgnoreCase("add")){
            acceso = add;
        } else if(action.equalsIgnoreCase("Agregar")){
            int idHorario = Integer.parseInt(request.getParameter("txtHorarioId"));
            int idUsuario = Integer.parseInt(request.getParameter("txtUsuarioId"));
            String fechIni = request.getParameter("txtFechaIni");
            String fechFin = request.getParameter("txtFechaFin");
            int idEstado = Integer.parseInt(request.getParameter("txtEstado"));
            l.setHorarioid(idHorario);
            l.setUsuarioid(idUsuario);
            l.setFecha_inicio(fechIni);
            l.setFecha_final(fechFin);
            l.setEstado(idEstado);
            lDAO.add(l);
            acceso = listar;
        }
        else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idlimp", request.getParameter("limpiezaid"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")){
            id = Integer.parseInt(request.getParameter("txtId")); 
            int idHorario = Integer.parseInt(request.getParameter("txtHorarioId"));
            int idUsuario = Integer.parseInt(request.getParameter("txtUsuarioId"));
            String fechIni = request.getParameter("txtFechaIni");
            String fechFin = request.getParameter("txtFechaFin");
            int idEstado = Integer.parseInt(request.getParameter("txtEstado"));
            l.setLimpiezaid(id);
            l.setHorarioid(idHorario);
            l.setUsuarioid(idUsuario);
            l.setFecha_inicio(fechIni);
            l.setFecha_final(fechFin);
            l.setEstado(idEstado); 
            lDAO.edit(l);
            acceso = listar;
        } else if(action.equalsIgnoreCase("eliminar")){
            id= Integer.parseInt(request.getParameter("limpiezaid"));
            l.setLimpiezaid(id);
            lDAO.eliminar(id);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request,response);
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
