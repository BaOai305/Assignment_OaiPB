/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.CategoryDBContext;
import dal.ProductDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Admin;
import model.Category;
import model.Product;

/**
 *
 * @author Phamb
 */
public class editProController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int proId = Integer.parseInt(request.getParameter("proId"));

        ProductDBContext dbPro = new ProductDBContext();
        Product product = dbPro.getProductByID(proId);
        request.setAttribute("product", product);

        CategoryDBContext dbCate = new CategoryDBContext();
        ArrayList<Category> cateList = dbCate.getCategorys();
        request.setAttribute("cateList", cateList);

        request.getRequestDispatcher("editProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int proId = Integer.parseInt(request.getParameter("proId"));
        String proName = request.getParameter("proName");
        String proImg = request.getParameter("proImg");
        String proPrice = request.getParameter("proPrice");
        String proQuantity = request.getParameter("proQuantity");
        String proCate = request.getParameter("proCate");
        String proUsing = request.getParameter("proUsing");

        Product product = new Product();
        product.setProductID(proId);
        product.setProductName(proName);
        product.setImage(proImg);
        product.setPrice(Float.parseFloat(proPrice));
        product.setQuantity(Integer.parseInt(proQuantity));
        product.setCategoryID(Integer.parseInt(proCate));
        product.setImportDate(java.time.LocalDate.now().toString());
        product.setUsingDate(proUsing);

        ProductDBContext dbPro = new ProductDBContext();
        dbPro.updateProduct(product);

        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if (admin != null) {
            response.sendRedirect("admin");
        } else {
            response.sendRedirect("seller");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
