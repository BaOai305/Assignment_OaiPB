/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Phamb
 */
public class AccountDBContext extends DBContext {

    public Account getAccoun(String PhoneNumber, String Password) {
        try {
            String sql = "SELECT PhoneNumber,Password FROM Account WHERE PhoneNumber = ? AND Password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, PhoneNumber);
            stm.setString(2, Password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setPhoneNumber(rs.getString("PhoneNumber"));
                account.setPassword(rs.getString("Password"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String checkRole(String PhoneNumber, String url) {
        try {
            String sql = "SELECT a.TypeOfUser as TypeOfUser\n"
                    + "FROM Account as a WHERE a.TypeOfUser = '?'";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, PhoneNumber);
            stm.setString(2, url);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getString("TypeOfUser");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
