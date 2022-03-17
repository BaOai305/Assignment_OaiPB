/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phamb
 */
public class DB {
    public static Connection getConnection() throws SQLServerException{
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("BAOAI");
        ds.setUser("sa");
        ds.setPassword("123456");
        ds.setDatabaseName("Assignment_OaiPB");
        ds.setPortNumber(1433);
        return ds.getConnection();
    }
   
}
