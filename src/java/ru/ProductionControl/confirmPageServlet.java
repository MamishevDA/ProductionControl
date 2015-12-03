/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ProductionControl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dmitriy.mamishev
 */
@WebServlet(name = "confirmPageServlet", urlPatterns = {"/confirmPage"})
public class confirmPageServlet extends HttpServlet {

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
         request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet confirmPageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet confirmPageServlet at " + request.getContextPath() + "</h1>");
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
        //request.getRequestDispatcher("WEB-INF/confirmPage.jsp").forward(request, response);

        
        boolean isInserted = DAO.insertRecipe(request.getParameter("Name"), request.getParameter("Description"));
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String str;
    str =   "<table border=\"1\">\n" +
"        <thead>\n" +
"            <tr>\n" +
"                <th>Name</th>\n" +
"                <th>Description</th>\n" +
"                <th>MainIngredients</th>\n" +
"            </tr>\n" +
"        </thead>\n" +
"        <tbody>\n" +
"            <tr>\n" +
"                <td>"+ request.getParameter("Name")+"</td>\n" +
"                <td>"+ request.getParameter("Description")+"</td>\n" +
"                <td>"+ request.getParameter("MainIngredients")+"</td>\n" +
"            </tr>\n" +
"        </tbody>\n" +
"    </table>\n";
         //accept-charset="UTF-8"
 response.getWriter().println("<!DOCTYPE HTML>"
         + "<html>"
         + "<head><meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"></head>"
         + "<body><form action=\"recipe\"method=\"POST\">"
         + "<h3>Ваши данные:</h3>"
         + "<p>" + str + "</p>"
         + "<p>добавлены? "
         + isInserted
         + "</p>"
         +"<input type=\"submit\" value=\"на начальную страницу\"/> "
         + "</form>"
         + "</body>"
         + "</html>");
 
    

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
        //request.getRequestDispatcher("WEB-INF/confirmPage.jsp").forward(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        doGet(request, response);
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
