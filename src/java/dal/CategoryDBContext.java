/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.Category;
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
public class CategoryDBContext extends DBContext {

    public ArrayList<Category> getCategorys() {
        ArrayList<Category> categorys = new ArrayList<>();
        try {
            String sql = "SELECT [categoryID]\n"
                    + "      ,[categoryName]\n"
                    + "  FROM [tblCategory] ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCategoryID(rs.getInt("categoryID"));
                c.setCategoryName(rs.getString("categoryName"));
                categorys.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorys;
    }

    public Category getCategoryById(int id) {
        try {
            String sql = "SELECT [categoryID]\n"
                    + "      ,[categoryName]\n"
                    + "  FROM [tblCategory]\n"
                    + "  Where [categoryID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Category c = new Category();
                c.setCategoryID(rs.getInt("categoryID"));
                c.setCategoryName(rs.getString("categoryName"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void deleteCate(int cateId) {
        try {
            String sql = "DELETE FROM [tblCategory]\n"
                    + "      WHERE [categoryID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cateId);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void addCate(Category c) {
        try {
            String sql = "INSERT INTO [tblCategory]\n"
                    + "           ([categoryName])\n"
                    + "     VALUES\n"
                    + "           (?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, c.getCategoryName());
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
