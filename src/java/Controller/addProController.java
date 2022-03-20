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
import model.Category;
import model.Product;

/**
 *
 * @author Phamb
 */
public class addProController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDBContext dbCate = new CategoryDBContext();
        ArrayList<Category> cateList = dbCate.getCategorys();
        request.setAttribute("cateList", cateList);
        request.getRequestDispatcher("addNewProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String categoryID = request.getParameter("cate");
        String usingDate = request.getParameter("usingDate");

        Product product = new Product();
        product.setProductName(name);
        product.setImage(img);
        product.setPrice(Float.parseFloat(price));
        product.setQuantity(Integer.parseInt(quantity));
        product.setCategoryID(Integer.parseInt(categoryID));
        product.setImportDate(java.time.LocalDate.now().toString());
        product.setUsingDate(usingDate);
        product.setStatus(1);
        product.setUser_post(Integer.parseInt(request.getSession().getAttribute("currentUserID").toString()));

        ProductDBContext dbPro = new ProductDBContext();
        dbPro.addProduct(product);
        response.sendRedirect("seller");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
