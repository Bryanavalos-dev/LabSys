/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TodosServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gerson
 */
@WebServlet(name = "SvrlTablas", urlPatterns = {"/SvrlTablas"})
public class SvrlTablas extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvrlTablas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvrlTablas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        PrintWriter out = response.getWriter();
        
        int tablaInicio = Integer.valueOf(request.getParameter("txtTablaInicio"));
        int tablaFin = Integer.valueOf(request.getParameter("txtTablaFin"));
        
        out.print("<table border='1'>");
        while(tablaInicio<=tablaFin){
            int contador=1;
            while(contador<=10){
                out.print("<tr><td>"+tablaInicio+" x "+contador+" =  "+(tablaInicio*contador)+"</td></tr>");
                contador++;
            }        
        tablaInicio++;
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
        PrintWriter out = response.getWriter();
        
        String dibujo ="";
        
        int tablaInicio = Integer.valueOf(request.getParameter("txtTablaInicio"));
        int tablaFin = Integer.valueOf(request.getParameter("txtTablaFin"));
        
        /*out.print("<table border='1'>");
        while(tablaInicio<=tablaFin){
            int contador=1;
            while(contador<=10){
                out.print("<tr><td>"+tablaInicio+" x "+contador+" =  "+(tablaInicio*contador)+"</td></tr>");
                contador++;
            }        
        tablaInicio++;
        }*/
        
        dibujo += ("<table border='1'>");
        while(tablaInicio<=tablaFin){
            int contador=1;
            while(contador<=10){
                dibujo += ("<tr><td>"+tablaInicio+" x "+contador+" =  "+(tablaInicio*contador)+"</td></tr>");
                contador++;
            }        
        tablaInicio++;
        }
         dibujo += ("</table>");
         request.setAttribute("dibujo", dibujo);
         this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
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
