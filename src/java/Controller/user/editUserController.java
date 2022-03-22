/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.user;

import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Admin;
import model.User;

/**
 *
 * @author Phamb
 */
public class editUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserDBContext dbUser = new UserDBContext();
        User user = dbUser.getUserByID(userId);
        request.setAttribute("user", user);
        request.getRequestDispatcher("editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int userRole = Integer.parseInt(request.getParameter("userRole"));
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");
        String userAdres = request.getParameter("userAdres");
        String userBirh = request.getParameter("userBirh");
        String userPhone = request.getParameter("userPhone");
        String userMail = request.getParameter("userMail");

        User u = new User();
        u.setUserID(userId);
        u.setFullName(userName);
        u.setPassword(userPass);
        u.setAddress(userAdres);
        u.setBirthday(userBirh);
        u.setPhone(userPhone);
        u.setMail(userMail);

        UserDBContext dbUser = new UserDBContext();
        dbUser.updateUser(u);
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if (admin != null) {
            if (userRole == 1) {
                response.sendRedirect("adminStudent");
            } else {
                response.sendRedirect("adminSeller");
            }
        } else {
            if (userRole == 1) {
                response.sendRedirect("student");
            } else {
                response.sendRedirect("seller");
            }
        }

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
