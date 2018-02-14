package com.grayWidjaya.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author G'ray Widjaya
 */
public class DBUtil {
    
    public static Connection createMySQLConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://host:port/Database_OOPL_Project_01","root","");
        connection.setAutoCommit(false);
        return connection;
    }
}
