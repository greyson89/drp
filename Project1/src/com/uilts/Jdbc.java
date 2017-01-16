package com.uilts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {

	public Connection getConn(){
		
		String driver = "com.mysql.jdbc.Driver"; 
        String url = "jdbc:mysql://localhost:3306/project1?useSSL=false"; 
        String user = ""; 
        String password = ""; //test
        Connection conn = null;

        try { 
            Class.forName(driver); 
            conn = DriverManager.getConnection(url,user, password);
//            StringBuffer sql = new StringBuffer();
            return conn;
        } 
        catch(ClassNotFoundException e) { 
            System.out.println("找不到驅動程式類別"); 
            e.printStackTrace(); 
        } 
        catch(SQLException e) { 
            e.printStackTrace(); 
        } 
        
        return null;
		
	}
	
	
}
