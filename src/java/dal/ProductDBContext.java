/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.Product;
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
public class ProductDBContext extends DBContext {

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT [productID]\n"
                    + "      ,[productName]\n"
                    + "      ,[image]\n"
                    + "      ,[price]\n"
                    + "      ,[quantity]\n"
                    + "      ,[categoryID]\n"
                    + "      ,[importDate]\n"
                    + "      ,[usingDate]\n"
                    + "      ,[user_post]\n"
                    + "      ,[status]\n"
                    + "  FROM [tblProduct]"
                    + "WHERE [status] = 1"
                    + "AND [quantity] >0";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCategoryID(rs.getInt("categoryID"));
                p.setImportDate(rs.getString("importDate"));
                p.setUsingDate(rs.getString("usingDate"));
                p.setStatus(rs.getInt("status"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public ArrayList<Product> getAllProductPost(int id) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select * from tblProduct where user_post = ? and status=1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCategoryID(rs.getInt("categoryID"));
                p.setImportDate(rs.getString("importDate"));
                p.setUsingDate(rs.getString("usingDate"));
                p.setStatus(rs.getInt("status"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public Product getProductByID(int productID) {
        Product p = new Product();
        try {
            String sql = "select * from tblProduct where productID = ? and status=1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, productID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCategoryID(rs.getInt("categoryID"));
                p.setImportDate(rs.getString("importDate"));
                p.setUsingDate(rs.getString("usingDate"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public static void insertProduct(Product product) {
        try {
            Connection conn = dal.DB.getConnection();
            PreparedStatement stmt = conn.prepareStatement("Insert into  tblProduct values(?,?,?,?,?,?,?,?)");
        } catch (Exception e) {

        }
    }

    public void updateQuantityT(int ID, int quantity) {
        try {
            String sql = "UPDATE [tblProduct]\n"
                    + "   SET[quantity] = ?\n"
                    + " WHERE [productID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quantity);
            stm.setInt(2, ID);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
