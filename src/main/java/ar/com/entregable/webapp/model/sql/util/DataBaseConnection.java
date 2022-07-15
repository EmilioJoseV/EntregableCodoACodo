package ar.com.entregable.webapp.model.sql.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnection {
    //Using Singleton Data Pattern Design
    private static final Logger logger = (Logger) LoggerFactory.getLogger(DataBaseConnection.class);
    private static String url = "jdbc:mysql://localhost:3306/webapp?serverTimezone=America/Argentina/Buenos_Aires";
    private static String username = "root";
    private static String password = "root";
    private static BasicDataSource pool;
    private static BasicDataSource getInstance() throws SQLException {
        if (pool == null )
        {
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);
            pool.setInitialSize(3); //3 conexiones creadas
            pool.setMinIdle(1); //Minimo 3 conecciones inactivas.
            pool.setMaxIdle(8); //Maximo 8 conecciones inactivas.
            pool.setMaxTotal(8);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
