/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import model.Product2;

/**
 *
 * @author Phamb
 */
public class ProductDBContext2 extends DBContext {

    public ArrayList<Product2> getProducts() {
        ArrayList<Product2> products = new ArrayList<>();
        try {
            String sql = "select p.productID, \n"
                    + "		 p.productName, \n"
                    + "		 p.image, \n"
                    + "		 p.price, \n"
                    + "		 p.quantity, \n"
                    + "		 c.categoryName, \n"
                    + "		 p.importDate, \n"
                    + "		 p.usingDate, \n"
                    + "		 s.fullName, \n"
                    + "		 p.status\n"
                    + "  from tblProduct as p\n"
                    + "  inner join tblCategory as c on c.categoryID = p.categoryID\n"
                    + "  inner join tblSeller as s on s.userID = p.user_post\n"
                    + "  where p.status = 1 and p.quantity > 0";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product2 p = new Product2();
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCategoryID(rs.getString("categoryName"));
                p.setImportDate(rs.getString("importDate"));
                p.setUsingDate(rs.getString("usingDate"));
                p.setUser_post(rs.getString("fullName"));
                p.setStatus(rs.getInt("status"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public ArrayList<Product2> getAllProductPost(int id) {
        ArrayList<Product2> products = new ArrayList<>();
        try {
            String sql = "select p.productID, \n"
                    + "		 p.productName, \n"
                    + "		 p.image, \n"
                    + "		 p.price, \n"
                    + "		 p.quantity, \n"
                    + "		 c.categoryName, \n"
                    + "		 p.importDate, \n"
                    + "		 p.usingDate, \n"
                    + "		 s.fullName, \n"
                    + "		 p.status\n"
                    + "  from tblProduct as p\n"
                    + "  inner join tblCategory as c on c.categoryID = p.categoryID\n"
                    + "  inner join tblSeller as s on s.userID = p.user_post\n"
                    + "  where p.status = 1 and p.user_post = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product2 p = new Product2();
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCategoryID(rs.getString("categoryName"));
                p.setImportDate(rs.getString("importDate"));
                p.setUsingDate(rs.getString("usingDate"));
                p.setUser_post(rs.getString("fullName"));
                p.setStatus(rs.getInt("status"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public Product2 getProductByID(int productID) {
        Product2 p = new Product2();
        try {
            String sql = "  select p.productID, \n"
                    + "		 p.productName, \n"
                    + "		 p.image, \n"
                    + "		 p.price, \n"
                    + "		 p.quantity, \n"
                    + "		 c.categoryName, \n"
                    + "		 p.importDate, \n"
                    + "		 p.usingDate, \n"
                    + "		 s.fullName, \n"
                    + "		 p.status\n"
                    + "  from tblProduct as p\n"
                    + "  inner join tblCategory as c on c.categoryID = p.categoryID\n"
                    + "  inner join tblSeller as s on s.userID = p.user_post\n"
                    + "  where p.status = 1 and p.productID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, productID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCategoryID(rs.getString("categoryName"));
                p.setImportDate(rs.getString("importDate"));
                p.setUsingDate(rs.getString("usingDate"));
                p.setUser_post(rs.getString("fullName"));
                p.setStatus(rs.getInt("status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public void addProduct(Product2 product) {
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
            stm.setString(5, product.getCategoryID());
            stm.setString(6, product.getImportDate());
            stm.setString(7, product.getUsingDate());
            stm.setString(8, product.getUser_post());
            stm.setInt(9, product.getStatus());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e);
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
