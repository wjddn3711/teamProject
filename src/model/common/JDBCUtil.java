package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
    static String driver="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3306/jdbc";
    static String user="root";
    static String password="dnflwlq0527!";
    public static Connection connect() {
        Connection conn=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }
    public static void disconnect(PreparedStatement pstmt,Connection conn) {
        try {
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
