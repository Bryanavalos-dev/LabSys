/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
@WebServlet(name = "SrvltLogica", urlPatterns = {"/SrvltLogica"})
public class SrvltLogica extends HttpServlet {

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
            out.println("<title>Servlet SrvltLogica</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SrvltLogica at " + request.getContextPath() + "</h1>");
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
        
        String nombre = request.getParameter("txtNombre");
        int horas = Integer.valueOf(request.getParameter("txtHorasTrabajadas"));
        double pagoHora = Double.valueOf(request.getParameter("txtPagoHora"));
        
        String dibujo = "";
        
        int  horasextra;
        double salario,  pagon, pagodoble, pagotriple; 
        int horasNormales, horasDobles, horasTriples;
        
        dibujo += "<table border='1'>";
        
      
            
                if (pagoHora>0 && horas>0)
                {
                                if(horas<=44)
                                {

                                        salario=pagoHora*horas;
                                        horasextra=horas-44;

                                        horasNormales=horas;
                                        horasDobles=0;
                                        horasTriples=0;

                                        pagon=pagoHora*horas;
                                        pagodoble=0;
                                        pagotriple=0;

                                }
                                else if(horas>44 && horas<51)
                                {

                                        salario=(pagoHora*44)+((6*pagoHora)*2);
                                        horasextra=horas-44;

                                        horasDobles=horas-44;
                                        horasNormales=horas-horasDobles;
                                        horasTriples=0;


                                        pagon=pagoHora*44;
                                        pagodoble=((6*pagoHora)*2);
                                        pagotriple=0;

                                }
                                else
                                {

                                        salario=(pagoHora*44)+((6*pagoHora)*2)+(((horas-50)*pagoHora)*3);
                                        horasextra=horas-44;

                                        horasTriples=horas-50;
                                        horasDobles=horas-44-horasTriples;
                                        horasNormales=horas-horasDobles-horasTriples;


                                        pagon=pagoHora*44;
                                        pagodoble=((6*pagoHora)*2);
                                        pagotriple=(((horas-50)*pagoHora)*3);

                                }

                                dibujo += "<br><br>";
                                dibujo += "<table style='display:inline-block;'><tr><td colspan='2'></td></tr>";
                                dibujo += "<tr><td>El empleado:</td><td> " + nombre + " </td></tr>";
                                dibujo += "<tr><td >Horas Trabajadas: </td><td>"+horas + " </td></tr>";


                                dibujo += "<tr><td>Horas normales:</td><td> " + horasNormales + " </td></tr>";
                                dibujo += "<tr><td>Horas dobles: </td><td>" + horasDobles + " </td></tr>";
                                dibujo += "<tr><td>Horas triples: </td><td>" + horasTriples + " </td></tr>";

                                 dibujo += "<tr><td colspan='2'>&nbsp</td></tr>";
                                dibujo += "</table><table style='display:inline-block;'><tr><td colspan='2'>Pagos</td></tr>";
                                dibujo += "<tr><td>Pago por horas Normales: </td><td>"+pagon + " </td></tr>";
                                dibujo += "<tr><td>Pago por horas Dobles: </td><td>"+pagodoble + " </td></tr>";
                                dibujo += "<tr><td>Pago por horas Triples: </td><td>"+pagotriple+ " </td></tr>";
                                dibujo += "<tr><td>Pago Neto: </td><td>"+salario + " </td></tr></table>";



                        }
                        else
                        {
                             dibujo += "<br><br>";
                               dibujo += "ES RECOMENDADO QUE INGRESE VALORES MAYORES A CERO";
                        }
                
        
            
        dibujo += "</table>";
        
        request.setAttribute("dibujo",dibujo);
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
