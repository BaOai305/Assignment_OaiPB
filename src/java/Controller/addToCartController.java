/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.OrderDBContext;
import dal.OrderDetailDBContext;
import dal.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.OrderDetail;
import model.Product;

/**
 *
 * @author Phamb
 */
public class addToCartController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        int productID = Integer.parseInt(request.getParameter("productID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductDBContext dbPro = new ProductDBContext();
        Product p = dbPro.getProductByID(productID);
        HttpSession session = request.getSession();
        int currentUserID = 0;
        try {
            currentUserID = Integer.parseInt(session.getAttribute("currentUserID").toString());
        } catch (NumberFormatException e) {
        }
        OrderDBContext dbOrder = new OrderDBContext();
        int cartID = dbOrder.getOrderIDByUserID(currentUserID);
        if (cartID == 0) {
            dbOrder.addNewOrder(currentUserID);
            cartID = dbOrder.getOrderIDByUserID(currentUserID);
        }
        OrderDetail detail = new OrderDetail();
        detail.setOrderID(cartID);
        detail.setPrice(p.getPrice());
        detail.setProductID(productID);
        detail.setQuantity(quantity);

        OrderDetailDBContext dbOrderDetail = new OrderDetailDBContext();
        dbOrderDetail.addOrderDetail(detail);

        response.sendRedirect("cart");
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
