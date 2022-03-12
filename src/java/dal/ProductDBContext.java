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
import model.Product;

/**
 *
 * @author Phamb
 */
public class ProductDBContext extends DBContext {

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "Select p.proId, p.proName, s.sellerName, "
                    + "p.proImage, tp.typeName, p.proPrice\n"
                    + "from Product as p\n"
                    + "inner join Seller as s on s.sellerId=p.proSeller\n"
                    + "inner join TypeOfProduct as tp on tp.typeId=p.proType";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProId(rs.getInt("proId"));
                p.setProName(rs.getString("proName"));
                p.setProSeller(rs.getString("sellerName"));
                p.setProImage(rs.getString("proImage"));
                p.setProType(rs.getString("typeName"));
                p.setProPrice(rs.getInt("proPrice"));
                products.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
}
