package com.mlj.Utils;
import java.sql.*;
public class DbUtil {
    public static final String URL="jdbc:mysql://127.0.0.1:3306/Test?serverTimezone=GMT%2B8&useSSL=false";
    public static final String user="root";
    public static final String passwd="123456";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,user,passwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
