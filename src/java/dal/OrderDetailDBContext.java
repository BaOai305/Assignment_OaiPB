/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.OrderDetail;
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
public class OrderDetailDBContext extends DBContext {

    public ArrayList<OrderDetail> getOrderDetails() {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        try {
            String sql = "SELECT [detailID]\n"
                    + "      ,[price]\n"
                    + "      ,[quantity]\n"
                    + "      ,[orderID]\n"
                    + "      ,[productID]\n"
                    + "  FROM [tblOrderDetail]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                OrderDetail od = new OrderDetail();
                od.setDetailID(rs.getInt("detailID"));
                od.setPrice(rs.getFloat("price"));
                od.setQuantity(rs.getInt("quantity"));
                od.setOrderID(rs.getInt("orderID"));
                od.setProductID(rs.getInt("productID"));
                orderDetails.add(od);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderDetails;
    }
    
    public ArrayList<OrderDetail> getOrderDetailByOrderID(int orderID) {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        try {
            String sql = "SELECT [detailID]\n"
                    + "      ,[price]\n"
                    + "      ,[quantity]\n"
                    + "      ,[orderID]\n"
                    + "      ,[productID]\n"
                    + "  FROM [tblOrderDetail]"
                    + "WHERE [orderID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, orderID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                OrderDetail detail = new OrderDetail();
                detail.setDetailID(rs.getInt("detailID"));
                detail.setPrice(rs.getFloat("price"));
                detail.setQuantity(rs.getInt("quantity"));
                detail.setOrderID(rs.getInt("orderID"));
                detail.setProductID(rs.getInt("productID"));
                orderDetails.add(detail);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderDetails;
    }

    public void addOrderDetail(OrderDetail detail) {
        try {
            String sql = "INSERT INTO [dbo].[tblOrderDetail]\n"
                    + "           ([price]\n"
                    + "           ,[quantity]\n"
                    + "           ,[orderID]\n"
                    + "           ,[productID])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setFloat(1, detail.getPrice());
            stm.setInt(2, detail.getQuantity());
            stm.setInt(3, detail.getOrderID());
            stm.setInt(4, detail.getProductID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteOrderDetailByID(int orderDetailID) {
        try {
            String sql = "DELETE FROM [dbo].[tblOrderDetail]\n"
                    + "      WHERE [detailID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, orderDetailID);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearOrderDetailByOrderID(int orderID) {
        try {
            String sql = "DELETE FROM [dbo].[tblOrderDetail]\n"
                    + "      WHERE [orderID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, orderID);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateOrderDetails(int detailID, int quantity) {
        try {
            String sql = "UPDATE [tblOrderDetail]\n"
                    + "   SET [quantity] = <quantity, int,>\n"
                    + " WHERE [detailID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quantity);
            stm.setInt(2, detailID);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
