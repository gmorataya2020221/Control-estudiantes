/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guideonmorataya.db;
import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author klbmo
 */
public class Conexion {
    
    private static final String DB="control_estudiantes";
    private static final String HOST="localhost";
    private static final String PUERTO="3306";
    private static final String USER="root";
    private static final String PASS="admin";
    private static final String URL="jdbc:mysql://"+ HOST + ":"+PUERTO+"/"+DB+"?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false&useTimezone=true";
    private static BasicDataSource dataSource;
    
    public static DataSource getDataSource(){
        
        if(dataSource== null){
            dataSource = new BasicDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASS);
        dataSource.setInitialSize(25);
        }
     
        
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement pstmt){
        try {
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection con){
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
}
