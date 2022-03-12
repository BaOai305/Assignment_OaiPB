/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Phamb
 */
public class AccountDBContext extends DBContext {

    public Account getAccoun(String phonenumber, String password) {
        try {
            String sql = "SELECT a.PhoneNumber, a.password, ut.userType FROM Account as a \n"
                    + "INNER JOIN User_type as ut on ut.phoneNumber=a.phoneNumber\n"
                    + "WHERE a.PhoneNumber = ? AND a.password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, phonenumber);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setPhoneNumber(rs.getString("phonenumber"));
                account.setPassword(rs.getString("password"));
                account.setTypeOfUser(rs.getString("userType"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public String checkRole(String phonenumber, String url) {
//        try {
//            String sql = "select ut.userType from User_type as ut where ut.phoneNumber= ?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setString(1, phonenumber);
//            stm.setString(2, url);
//            ResultSet rs = stm.executeQuery();
//            if (rs.next()) {
//                return rs.getString("TypeOfUser");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    public void registerAccount(Account acc) {
        String sql = "INSERT INTO [Account]\n"
                + "           ([phoneNumber]\n"
                + "           ,[password]\n"
                + "           ,[name]\n"
                + "           ,[address1]\n"
                //                + "           ,[address2]\n"
                + "           ,[orderPhoneNumber])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                //                + "           ,\n"
                + "           ,?)";
        PreparedStatement stm = null;
        try {
            connection.setAutoCommit(false);
            stm = connection.prepareStatement(sql);
            stm.setString(1, acc.getPhoneNumber());
            stm.setString(2, acc.getPassword());
            stm.setString(3, acc.getName());
            stm.setString(4, acc.getAddress1());
            stm.setString(5, acc.getPhoneNumber());
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
