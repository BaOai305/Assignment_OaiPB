/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.RoleDBContext;
import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Role;
import model.Seller;
import model.User;

/**
 *
 * @author Phamb
 */
public class registerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RoleDBContext dbRole = new RoleDBContext();
        ArrayList<Role> roleList = dbRole.getRoles();
        request.setAttribute("roleList", roleList);
        request.getRequestDispatcher("register.jsp").forward(request, response);
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
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String birthDay = request.getParameter("birthDay");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        String role = request.getParameter("role");
        User u = new User();
        u.setFullName(fullName);
        u.setPassword(password);
        u.setRoleID(Integer.parseInt(role));
        u.setAddress(address);
        u.setBirthday(birthDay);
        u.setPhone(phone);
        u.setMail(mail);
        u.setStatus(1);

        UserDBContext dbUser = new UserDBContext();
        dbUser.addNewUser(u);

        if (role.equals("2")) {
            Seller seller = new Seller();
            int sellerId = dbUser.getUserId(mail, password);
            seller.setSellerId(sellerId);
            seller.setSellerName(fullName);
            dbUser.addNewSeller(seller);
        }

        response.sendRedirect("login");
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
