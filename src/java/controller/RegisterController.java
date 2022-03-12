/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Phamb
 */
public class RegisterController extends BaseConfirmController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/register.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_typeOfUser = request.getParameter("typeOfUser");
        String raw_name = request.getParameter("name");
        String raw_password = request.getParameter("password");
        String raw_phonenumber = request.getParameter("phonenumber");
        String raw_address1 = request.getParameter("address1");

        // nhớ kiểm tra lại các thông tin có hợp lệ hay không
        Account acc = new Account();
        acc.setTypeOfUser(raw_typeOfUser);
        acc.setName(raw_name);
        acc.setPassword(raw_password);
        acc.setPhoneNumber(raw_phonenumber);
        acc.setAddress1(raw_address1);

        AccountDBContext db = new AccountDBContext();
        db.registerAccount(acc);

        //response.getWriter().println("Student " + s.getId() + " is already added!");
//        response.sendRedirect("");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
