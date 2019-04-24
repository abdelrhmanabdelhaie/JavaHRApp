package com.util;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.OracleDriver;


public class EmpDBUtil {

    public static Connection connection = null;
  public static Connection getConnection() {
        try {
            String username = "hr";
            String password = "hr";
            String thinConn = "jdbc:oracle:thin:@localhost:1521:xe";
            DriverManager.registerDriver(new OracleDriver());
            Connection conn = DriverManager.getConnection(thinConn, username, password);
            conn.setAutoCommit(false);
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }


    public static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
