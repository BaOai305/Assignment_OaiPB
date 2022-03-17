/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phamb
 */
public class UserDBContext extends DBContext {

    public static ArrayList<User> getAllUser() {
        ArrayList<User> list = new ArrayList<>();
        try {
            Connection conn = dal.DB.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from tblUsers");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setFullName(rs.getString("fullName"));
                u.setPassword(rs.getString("password"));
                u.setRoleID(rs.getInt("roleID"));
                u.setAddress(rs.getString("address"));
                u.setBirthday(rs.getString("birthday"));
                u.setPhone(rs.getString("phone"));
                u.setMail(rs.getString("mail"));
                u.setStatus(rs.getInt("status"));
                list.add(u);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("loi get User :" + e);
        }
        return list;
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT [userID]\n"
                    + "      ,[fullName]\n"
                    + "      ,[password]\n"
                    + "      ,[roleID]\n"
                    + "      ,[address]\n"
                    + "      ,[birthday]\n"
                    + "      ,[phone]\n"
                    + "      ,[mail]\n"
                    + "      ,[status]\n"
                    + "  FROM [tblUsers]\n";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setFullName(rs.getString("fullName"));
                u.setPassword(rs.getString("password"));
                u.setRoleID(rs.getInt("roleID"));
                u.setAddress(rs.getString("address"));
                u.setBirthday(rs.getString("birthday"));
                u.setPhone(rs.getString("phone"));
                u.setMail(rs.getString("mail"));
                u.setStatus(rs.getInt("status"));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public User loginUser(String Email, String password) {
        User user = new User();
        UserDBContext dbUser = new UserDBContext();
        ArrayList<User> users = dbUser.getUsers();
        for (User u : users) {
            if (u.getMail().trim().equals(Email) && u.getPassword().trim().equals(password)) {
                user = u;
                return user;
            }
        }
        return null;

    }

    public User getUserByID(int userID) {
        User user = new User();
        UserDBContext dbUser = new UserDBContext();
        ArrayList<User> users = dbUser.getUsers();
        for (User u : users) {
            if (u.getUserID() == userID) {
                user = u;
                return user;
            }
        }
        return null;
    }


    public void addNewUser(User u) {
        try {
            String sql = "INSERT INTO [dbo].[tblUsers]\n"
                    + "           ([fullName]\n"
                    + "           ,[password]\n"
                    + "           ,[roleID]\n"
                    + "           ,[address]\n"
                    + "           ,[birthday]\n"
                    + "           ,[phone]\n"
                    + "           ,[mail]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, u.getFullName());
            stm.setString(2, u.getPassword());
            stm.setInt(3, u.getRoleID());
            stm.setString(4, u.getAddress());
            stm.setString(5, u.getBirthday());
            stm.setString(6, u.getPhone());
            stm.setString(7, u.getMail());
            stm.setInt(8, u.getStatus());
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
