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
import modelo.Horario;
import modeloDAO.HorarioDAO;

/**
 *
 * @author bryan
 */
@WebServlet(name = "encargado", urlPatterns = {"/encargado"})
public class encargado extends HttpServlet {

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
        HttpSession session= request.getSession(true);
        RequestDispatcher mostrar;
        String accion = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"";
         
         switch(accion){
               case "horarios":
                    mostrar = request.getRequestDispatcher("vistas/encargado/horarios.jsp");
                    mostrar.forward(request, response);
                 break;
                    case "agregarHorarios":
                    mostrar = request.getRequestDispatcher("vistas/encargado/agregarHorarios.jsp");
                    mostrar.forward(request, response);
                 break;
                   case "eliminarHorario":
                   request.setAttribute("idper",request.getParameter("id"));
                    HorarioDAO edi = new HorarioDAO();
                    int ide=Integer.parseInt(request.getParameter("id"));
                    edi.eliminar(ide);
                    
                     response.sendRedirect("encargado?tipo=horarios");
                 break;
                  case "editarHorario":
                    request.setAttribute("idper",request.getParameter("id"));
                    mostrar = request.getRequestDispatcher("vistas/encargado/editarHorarios.jsp");
                    mostrar.forward(request, response);
                  break;
            
             default:
                    mostrar = request.getRequestDispatcher("vistas/encargado/encargado.jsp");
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
        int lab, periodo,id;
        String l,m,mi,j,v,s,d;
        Horario h = new Horario();
        HorarioDAO hd = new HorarioDAO();
        switch(accion){
             case "agregarHorario":
                    lab = Integer.parseInt(request.getParameter("sltLab"));
                    periodo = Integer.parseInt(request.getParameter("sltPeriodo"));                    
                    h.setIdlab(lab);
                    h.setHorainicio(request.getParameter("txtHorainicio"));
                    h.setHorafin(request.getParameter("txtHorafin"));
                    l=request.getParameter("chkLunes");
                    m=request.getParameter("chkMartes");
                    mi=request.getParameter("chkMiercoles");
                    j=request.getParameter("chkJueves");
                    v=request.getParameter("chkViernes");
                    s=request.getParameter("chkSabado");
                    d=request.getParameter("chkDomingo");
                    
                    if(l != null){
                        h.setLunes(1);
                    }else{
                        h.setLunes(0);
                    }
                    if(m != null){
                        h.setMartes(1);
                    }else{
                        h.setMartes(0);
                    }
                    if(mi != null){
                        h.setMiercoles(1);
                    }else{
                        h.setMiercoles(0);
                    }
                    if(j != null){
                        h.setJueves(1);
                    }else{
                        h.setJueves(0);
                    }
                     if(v != null){
                        h.setViernes(1);
                    }else{
                        h.setViernes(0);
                    }
                      if(s != null){
                        h.setSabado(1);
                    }else{
                        h.setSabado(0);
                    }
                    if(d != null){
                        h.setDomingo(1);
                    }else{
                        h.setDomingo(0);
                    } 
                    h.setIdper(periodo);
                    h.setCreado(request.getParameter("txtFecha"));
                    
                    hd.add(h);
                    
                    response.sendRedirect("encargado?tipo=horarios");
                    //mostrar = request.getRequestDispatcher("vistas/administrador/editarRoles.jsp");
                    
                    //mostrar.forward(request, response);
                    
                  break;
                  case "modificarHorario":
                    request.setAttribute("idper",request.getParameter("id"));
                    h = new Horario();
                    id=Integer.parseInt(request.getParameter("txtId"));
                    h.setCodigo(id);
                    lab = Integer.parseInt(request.getParameter("sltLab"));
                    periodo = Integer.parseInt(request.getParameter("sltPeriodo"));                    
                    h.setIdlab(lab);
                    h.setHorainicio(request.getParameter("txtHorainicio"));
                    h.setHorafin(request.getParameter("txtHorafin"));
                    l=request.getParameter("chkLunes");
                    m=request.getParameter("chkMartes");
                    mi=request.getParameter("chkMiercoles");
                    j=request.getParameter("chkJueves");
                    v=request.getParameter("chkViernes");
                    s=request.getParameter("chkSabado");
                    d=request.getParameter("chkDomingo");
                    
                    if(l != null){
                        h.setLunes(1);
                    }else{
                        h.setLunes(0);
                    }
                    if(m != null){
                        h.setMartes(1);
                    }else{
                        h.setMartes(0);
                    }
                    if(mi != null){
                        h.setMiercoles(1);
                    }else{
                        h.setMiercoles(0);
                    }
                    if(j != null){
                        h.setJueves(1);
                    }else{
                        h.setJueves(0);
                    }
                     if(v != null){
                        h.setViernes(1);
                    }else{
                        h.setViernes(0);
                    }
                      if(s != null){
                        h.setSabado(1);
                    }else{
                        h.setSabado(0);
                    }
                    if(d != null){
                        h.setDomingo(1);
                    }else{
                        h.setDomingo(0);
                    } 
                    h.setIdper(periodo);
                    h.setCreado(request.getParameter("txtFecha"));
                    
                    hd.edit(h);                  
                    
                    response.sendRedirect("encargado?tipo=horarios");
                   
                    
                  break;
                           
             default:
                    mostrar = request.getRequestDispatcher("vistas/encargado/encargado.jsp");
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
