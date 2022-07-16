package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    public static Connection getConnection() throws SQLException {

        Connection conn;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Teispace","root","");
        return conn;
    }

}
