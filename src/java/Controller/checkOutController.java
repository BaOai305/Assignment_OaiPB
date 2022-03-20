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
import java.util.ArrayList;
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
public class checkOutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        float totalPrice = Float.parseFloat(request.getParameter("totalPrice"));

        OrderDetailDBContext dbOrderDetail = new OrderDetailDBContext();
        ArrayList<OrderDetail> details = dbOrderDetail.getOrderDetailByOrderID(orderID);

        int quantity = 0;
        boolean check = false;
        for (OrderDetail orderDetail : details) {
            ProductDBContext dbPro = new ProductDBContext();
            Product products = dbPro.getProductByID(orderDetail.getProductID());
            if (orderDetail.getProductID() == products.getProductID()) {
                quantity = products.getQuantity() - orderDetail.getQuantity();
                if (quantity < 0) {
                    check = true;
                    break;
                } else {
                    dbPro.updateQuantityT(orderID, quantity);
                }
            }
        }
        if (check) {
            response.sendRedirect("./cart.jsp");
        } else {
            OrderDBContext dbOrder = new OrderDBContext();
            dbOrder.checkOut(orderID, totalPrice);
            HttpSession session = request.getSession();
            sendmail.SendMail.sendmail(session.getAttribute("email").toString());
            response.sendRedirect("./cart.jsp");
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
