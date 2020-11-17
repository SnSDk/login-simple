package com.codoacodo.sergiojuarez.controler;

import com.codoacodo.sergiojuarez.models.Persona;
import com.codoacodo.sergiojuarez.models.PersonaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controler extends HttpServlet {
    PersonaDAO dao=new PersonaDAO();
    Persona p= new Persona();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion=request.getParameter("accion");
        if(accion.equals("Ingresar")){
            String user=request.getParameter("user");
            String pass=request.getParameter("pass");
            p.setUser(user);
            p.setPass(pass);
            r=dao.validar(p);
            if(r==1){
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("pass", pass);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }else if(accion.equals("Salir")){
            request.getRequestDispatcher("user.html").forward(request, response);
        }else{
            request.getRequestDispatcher("user.html").forward(request, response);
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
