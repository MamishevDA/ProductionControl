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
@WebServlet(name = "ConfirmPageServlet", urlPatterns = {"/confirmPage"})
public class ConfirmPageServlet extends HttpServlet {

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
        //request.getRequestDispatcher("WEB-INF/confirmPage.jsp").forward(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        if (!request.getParameter("Name").trim().isEmpty() && !request.getParameter("Description").trim().isEmpty()) {
            Recipe recipe = new Recipe();
            recipe.setName(request.getParameter("Name").trim());
            recipe.setDescription(request.getParameter("Description").trim());
            recipe.setMainIngredient(request.getParameter("MainIngredients").trim());
//        String name = request.getParameter("Name").trim();
//        String description = request.getParameter("Description").trim();
//        String mainIngredients = request.getParameter("MainIngredients").trim();

            boolean isInserted = DAO.insertRecipe(recipe);
            String str;
            str = "<table border=\"1\">\n"
                    + "        <thead>\n"
                    + "            <tr>\n"
                    + "                <th>Name</th>\n"
                    + "                <th>Description</th>\n"
                    + "                <th>MainIngredients</th>\n"
                    + "            </tr>\n"
                    + "        </thead>\n"
                    + "        <tbody>\n"
                    + "            <tr>\n"
                    + "                <td>" + recipe.getName() + "</td>\n"
                    + "                <td>" + recipe.getDescription() + "</td>\n"
                    + "                <td>" + recipe.getMainIngredient() + "</td>\n"
                    + "            </tr>\n"
                    + "        </tbody>\n"
                    + "    </table>\n";
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
                    + "<input type=\"submit\" value=\"на начальную страницу\"/> "
                    + "</form>"
                    + "</body>"
                    + "</html>");
        } else {

            response.getWriter().println("<!DOCTYPE HTML>"
                    + "<html>"
                    + "<head><meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"></head>"
                    + "<body><form action=\"recipe\"method=\"POST\">"
                    + "<h3>Данные не введены!</h3>"
                    + "<input type=\"submit\" value=\"на начальную страницу\"/> "
                    + "</form>"
                    + "</body>"
                    + "</html>");
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
