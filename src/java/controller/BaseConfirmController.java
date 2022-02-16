/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Phamb
 */
public abstract class BaseConfirmController extends HttpServlet {

    private boolean isConfirmed(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null)//not login, some cookies
            {
                String PhoneNumber = null;
                String Password = null;
                for (Cookie cooky : cookies) {
                    if (cooky.getName().equals("username")) {
                        PhoneNumber = cooky.getValue();
                    }
                    if (cooky.getName().equals("password")) {
                        Password = cooky.getValue();
                    }
                }
                if (PhoneNumber == null || Password == null) {
                    return false;
                } else {
                    AccountDBContext db = new AccountDBContext();
                    account = db.getAccoun(PhoneNumber, Password);
                    if (account != null) {
                        request.getSession().setAttribute("account", account);
                        return true;
                    } else {
                        return false;
                    }
                }
            } else //not login, not cookie
            {
                return false;
            }
        } else {
            String url = request.getServletPath();
            AccountDBContext db = new AccountDBContext();
            String typeOfUser = db.checkRole(account.getPhoneNumber(), url);
            return typeOfUser.equals("admin") || typeOfUser.equals("seller") || typeOfUser.equals("user");
        }
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
        if (isConfirmed(request)) {
            //process business
            processGet(request, response);
        } else {
            response.getWriter().println("access denied!");
        }    }
    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
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
        if (isConfirmed(request)) {
            //process business
            processPost(request, response);
        } else {
            response.getWriter().println("access denied!");
        }    }

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