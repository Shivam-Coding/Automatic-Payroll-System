package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DBConnection;

public class Logindao {
	Connection conn;
	
int count;
public int loginAuth(String email, String password){
	
	conn = DBConnection.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select count(empcode) from EMPLOYEE Where emailid='" + email + "' and password='" + password + "'";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				 count = rs.getInt(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			 count = 0;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count; 	
	}

public String getNamefromreg(String email){
	conn = DBConnection.getConnection();
	String name = null;
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select firstName from EMPLOYEE Where emailid='" + email + "'";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			 name = rs.getString(1);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		name = "NO";
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return name; 	
}
public String getEmpcodefromreg(String email){
	conn = DBConnection.getConnection();
	String name = null;
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select empcode from EMPLOYEE Where emailid='" + email + "'";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			 name = rs.getString(1);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		name = "NO";
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return name; 	
}

public String getDesignationfromreg(String empcode){
	conn = DBConnection.getConnection();
	String name = null;
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select designation from EMPLOYEE Where empcode='" + empcode + "'";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			 name = rs.getString(1);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		name = "NO";
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return name; 	
}

public String getEmpcoderole(String email){
	conn = DBConnection.getConnection();
	String name = null;
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select roleid from EMPLOYEE Where emailid='" + email + "'";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			 name = rs.getString(1);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		name = "NO";
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return name; 
}

}
