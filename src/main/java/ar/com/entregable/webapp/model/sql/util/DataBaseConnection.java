package ar.com.entregable.webapp.model.sql.util;

import org.apache.commons.dbcp2.BasicDataSource;


import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnection {
    //Using Singleton Data Pattern Design
    private static String url = "jdbc:mysql://localhost:3306/webapp?serverTimezone=America/Argentina/Buenos_Aires";
    private static String username = "root";
    private static String password = "root";
    private static BasicDataSource pool;
    private static BasicDataSource getInstance() throws SQLException {
        if (pool == null )
        {
            pool = new BasicDataSource();
            pool.setDriverClassName("com.mysql.cj.jdbc.Driver");
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);
            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(8);
            pool.setMaxTotal(8);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
