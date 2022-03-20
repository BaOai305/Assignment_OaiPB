/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Phamb
 */
public class loginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userID = request.getParameter("Email").trim();
        String password = request.getParameter("password").trim();

        UserDBContext dbUser = new UserDBContext();
        User user = dbUser.loginUser(userID, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            String remember = request.getParameter("remember");
            if (remember != null) {
                Cookie c_user = new Cookie("Email", userID);
                Cookie c_pass = new Cookie("password", password);
                c_user.setMaxAge(24 * 3600 * 7);
                c_pass.setMaxAge(24 * 3600 * 7);
                response.addCookie(c_user);
                response.addCookie(c_pass);
            }

            if (user.getRoleID() == 1) {
                request.getSession().removeAttribute("loginError");
                request.getSession().setAttribute("currentUserID", user.getUserID());
                request.getSession().setAttribute("email", user.getMail());
                response.sendRedirect("student");
            } else {
                request.getSession().removeAttribute("loginError");
                request.getSession().setAttribute("currentUserID", user.getUserID());
                response.sendRedirect("seller");

            }
        } else {
            request.getSession().setAttribute("loginError", "UserID or password is incorrect");
            response.sendRedirect("./login.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
