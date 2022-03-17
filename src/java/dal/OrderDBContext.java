/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.Order;
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
public class OrderDBContext extends DBContext {

    public ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String sql = "SELECT [orderID]\n"
                    + "      ,[userID]\n"
                    + "      ,[orderDate]\n"
                    + "      ,[total]\n"
                    + "      ,[status]\n"
                    + "  FROM [tblOrders]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderID(rs.getInt("orderID"));
                o.setUserID(rs.getInt("userID"));
                o.setOrderDate(rs.getString("orderDate"));
                o.setTotal(rs.getFloat("total"));
                o.setStatus(rs.getInt("status"));
                orders.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public int getOrderIDByUserID(int userID) {
        int orderId = 0;
        try {
            String sql = "SELECT [orderID]\n"
                    + "  FROM [tblOrders]\n"
                    + "  WHERE  userID = ? and status = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                orderId = rs.getInt("orderID");
                return orderId;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderId;
    }

    public void addNewOrder(int userID) {
        try {
            String sql = "INSERT INTO [tblOrders]\n"
                    + "           ([userID]\n"
                    + "           ,[orderDate]\n"
                    + "           ,[total]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userID);
            stm.setString(2, "0");
            stm.setFloat(3, 0);
            stm.setInt(4, 1);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checkOut(int orderID, float totalPrice) {
        try {
            String sql = "UPDATE [dbo].[tblOrders]\n"
                    + "   SET [total] = ?\n"
                    + "      ,[status] = 2\n"
                    + " WHERE [orderID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setFloat(1, totalPrice);
            stm.setInt(2, orderID);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
