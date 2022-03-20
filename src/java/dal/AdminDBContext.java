/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.Category;
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
 * @author AdminDBContext
 */
public class AdminDBContext extends DBContext {

    public ArrayList<Product> getProductsAdmin() {
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
                    + "  FROM [tblProduct]";
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
                p.setUser_post(rs.getInt("user_post"));
                p.setStatus(rs.getInt("status"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public void addProductT(Product product) {
        try {
            String sql = "INSERT INTO [dbo].[tblProduct]\n"
                    + "           ([productName]\n"
                    + "           ,[image]\n"
                    + "           ,[price]\n"
                    + "           ,[quantity]\n"
                    + "           ,[categoryID]\n"
                    + "           ,[importDate]\n"
                    + "           ,[usingDate]\n"
                    + "           ,[user_post]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (<productName, nvarchar(100),>\n"
                    + "           ,<image, text,>\n"
                    + "           ,<price, float,>\n"
                    + "           ,<quantity, int,>\n"
                    + "           ,<categoryID, int,>\n"
                    + "           ,<importDate, nchar(50),>\n"
                    + "           ,<usingDate, nchar(50),>\n"
                    + "           ,<user_post, int,>\n"
                    + "           ,<status, int,>)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, product.getProductName());
            stm.setString(2, product.getImage());
            stm.setFloat(3, product.getPrice());
            stm.setInt(4, product.getQuantity());
            stm.setInt(5, product.getCategoryID());
            stm.setString(6, product.getImportDate());
            stm.setString(7, product.getUsingDate());
            stm.setInt(8, product.getUser_post());
            stm.setInt(9, product.getStatus());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(AdminDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
