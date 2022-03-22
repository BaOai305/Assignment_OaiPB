/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.category;

import dal.CategoryDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;

/**
 *
 * @author Phamb
 */
public class addCateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addNewCate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cateName = request.getParameter("cateName");
        Category c = new Category();
        c.setCategoryName(cateName);
        CategoryDBContext dbCate = new CategoryDBContext();
        dbCate.addCate(c);
        response.sendRedirect("adminCate");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
