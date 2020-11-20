/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Todo;

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
@WebServlet(name = "PagoServlet", urlPatterns = {"/PagoServlet"})
public class PagoServlet extends HttpServlet {

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
        String nombre = request.getParameter("txtNombre");
        double pago = Double.valueOf(request.getParameter("txtPago"));
        int horas = Integer.valueOf(request.getParameter("txtHoras"));
        
        int horasNormal = 0;
        int horasDobles = 0;
        int horasTriples = 0;
        
        double pagoNormal = 0;
        double pagoDoble = 0;
        double pagoTriple = 0;
        
        if(horas<=44){     
            horasNormal=horas;
            pagoNormal = horas*pago;
        }else if(horas<=50){
            horasNormal=44;
            horasDobles = horas-horasNormal;  
            
            pagoNormal = horasNormal*pago;
            pagoDoble = horasDobles*(pago*2);            
        }else{
            horasNormal=44;
            horasDobles = 6;
            horasTriples = horas-50;
            
            pagoNormal = horasNormal*pago;
            pagoDoble = horasDobles*(pago*2);
            pagoTriple = horasTriples*(pago*3);
        }
        
        
        
        
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<br>Pago por hora: $"+pago);
            out.println("<br>Cantidad de horas trabajadas:"+horas);
            out.println("<br>Cantidad de horas trabajadas normales:"+horasNormal);
            out.println("<br>Cantidad de horas trabajadas dobles:"+horasDobles);
            out.println("<br>Cantidad de horas trabajadas triples:"+horasTriples);
            out.println("<br>Pago de horas normales $:"+pagoNormal);
            out.println("<br>Pago de horas dobles $:"+pagoDoble);
            out.println("<br>Pago de horas triples $:"+pagoTriple);
            out.println("<br>Pago neto $:"+(pagoNormal+pagoDoble+pagoTriple));
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

