/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otros;

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
@WebServlet(name = "ServletProcesar", urlPatterns = {"/ServletProcesar"})
public class ServletProcesar extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletProcesar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletProcesar at " + request.getContextPath() + "</h1>");
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

		int col = Integer.valueOf(request.getParameter("txtCol"));
		int fil = Integer.valueOf(request.getParameter("txtFil"));

		String data = "";
                
                if(col<=0 || fil<=0){
                request.setAttribute("data","Ingrese numeros mayores a 0 en las filas y columnas");
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }



		data += ("<style>.tablaOkAse tr td{ padding-left: 50px; border: solid black 1px;}</style>");
		data += ("<table class='tablaOkAse'>");

         //encabezado
		data += ("<tr>");
		data += ("<td>");
		data += ("");
		data += ("</td>");
		for(int c = col; c>0;c--){
			data += ("<td>");
			data += (""+c);
			data += ("</td>");
          }//fin for encabezado
          data += ("<td>");
          data += ("suma");
          data += ("</td>");
          data += ("</tr>");

         //desarrollo de multiplicaciones
          for(int f=1; f<=fil;f++){
          	data += ("<tr>");

          	data += ("<td>");
          	data += (""+f);
          	data += ("</td>");
          	int suma=0;
          	for(int c = col; c>0;c--){
          		data += ("<td>");
          		data += (""+(c*f));
          		data += ("</td>");
          		suma+=(c*f);
         }//fin for col
         
         data += ("<td>");
         data += (""+suma);
         data += ("</td>");
         
         
         data += ("</tr>");
         
         }//fin for fila
         
         int sumaGlobal=0;
         //Sumatoria abajo
         data += ("<tr>");
         data += ("<td>");
         data += ("Total");
         data += ("</td>");
         for(int c = col; c>0;c--){
         	data += ("<td>");
         	int suma=0;
         	for(int f=1; f<=fil;f++){
         		suma+=(f*c);
         		sumaGlobal+=suma;
         	}
         	data += (""+suma);

         	data += ("</td>");
          }//fin for encabezado
          data += ("<td>");
          data += (""+sumaGlobal);
          data += ("</td>");
          data += ("</tr>");

          data += ("</table>");

            
          request.setAttribute("data",data);
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
