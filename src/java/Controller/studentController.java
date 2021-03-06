/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.ProductDBContext2;
import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product2;
import model.User;

/**
 *
 * @author Phamb
 */
public class studentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userId = (int) request.getSession().getAttribute("currentUserID");
        UserDBContext dbUser = new UserDBContext();
        User user = dbUser.getUserByID(userId);
        request.setAttribute("currentUser", user);
        
        ProductDBContext2 dbPro2 = new ProductDBContext2();
        ArrayList<Product2> proList = dbPro2.getProducts();

        // nhớ thêm chọn sản phẩm bằng category
        request.setAttribute("proList", proList);
        request.getRequestDispatcher("student.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
