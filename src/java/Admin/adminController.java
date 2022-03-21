/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import dal.AdminDBContext;
import dal.ProductDBContext2;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Admin;
import model.Product2;

/**
 *
 * @author Phamb
 */
public class adminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        request.setAttribute("admin", admin);
        ProductDBContext2 dbPro2 = new ProductDBContext2();
        ArrayList<Product2> proList = dbPro2.getProducts();
        request.setAttribute("proList", proList);

        request.getRequestDispatcher("adminPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
