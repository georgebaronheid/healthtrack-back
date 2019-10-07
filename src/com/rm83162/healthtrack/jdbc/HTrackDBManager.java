package com.rm83162.healthtrack.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class HTrackDBManager {
    public static Connection obterConexao(){
        Connection connection = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM83162", "090395");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
