package controladores;

import modelo.Roles;
import modeloDAO.RolesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador_Roles extends HttpServlet {
    String listar="vistas/administrador/listar.jsp";
    String add="vistas/administrador/add.jsp";
    String edit="vistas/administrador/edit.jsp";
    Roles p=new Roles();
    RolesDAO dao=new RolesDAO();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {/*
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. *//*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_Roles</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_Roles at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    */}

    
    
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
            p.setNom(nom);
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
            p.setNom(Nombre);
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
        
        /*
        else if (action.equalsIgnoreCase("edit")){
            request.setAttribute("periodoid",request.getParameter("id"));
            acceso=edit;
        }
        else if (action.equalsIgnoreCase("Actualizar")){
           int Id=Integer.parseInt(request.getParameter("txtID"));
            String Nombre=request.getParameter("txtNombre");
            p.setId(Id);
            p.setNombre(Nombre);
            dao.edit(p);
            acceso=listar;
            
        }*/
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
