package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection(){
		Connection conn = null;
		try{
		
		String driver = "com.mysql.jdbc.GoogleDriver";
    
        
        Class.forName(driver);
        
conn = DriverManager.getConnection("jdbc:google:mysql://storied-link-124705:java-study1/Payroll?user=root");
    }catch(Exception e){
        e.printStackTrace();
    }
        return conn;
	}
}
