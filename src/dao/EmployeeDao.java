package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import dao.DBConnection;

public class EmployeeDao {

	
	
	

public LinkedHashMap<String, ArrayList> getEmployeeProfile(String empid){
	
	Connection con = DBConnection.getConnection();
	
	ArrayList<String> empcode = new ArrayList<String>();
	ArrayList<String> firstName = new ArrayList<String>();
	ArrayList<String> lastName = new ArrayList<String>();
	ArrayList<String> emailid = new ArrayList<String>();
	ArrayList<String> password = new ArrayList<String>();
	ArrayList<String> designation = new ArrayList<String>();
	ArrayList<String> dob = new ArrayList<String>();
	ArrayList<String> al1 = new ArrayList<String>();
	ArrayList<String> al2 = new ArrayList<String>();
	ArrayList<String> city = new ArrayList<String>();
	ArrayList<String> state = new ArrayList<String>();
	ArrayList<String> zipcode = new ArrayList<String>();
	ArrayList<String> phone = new ArrayList<String>();
	
	
	LinkedHashMap<String, ArrayList> emp= new LinkedHashMap<String, ArrayList>();
	
	String query="select * from EMPLOYEE where empcode='"+empid+"'";
	Statement s;
	try {
		s = con.createStatement();
	
	ResultSet rs = s.executeQuery(query);
	while(rs.next()){
		empcode.add(rs.getString("empcode"));
		firstName.add(rs.getString("firstName"));
		lastName.add(rs.getString("lastName"));
		emailid.add(rs.getString("emailid"));
		password.add(rs.getString("password"));
		designation.add(rs.getString("designation"));
		dob.add(rs.getString("dob"));
		al1.add(rs.getString("address1"));
		al2.add(rs.getString("address2"));
		city.add(rs.getString("city"));
		state.add(rs.getString("state"));
		zipcode.add(rs.getString("zipcode"));
		phone.add(rs.getString("phoneNumber"));
		
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	emp.put("empcode", empcode);
	emp.put("firstName", firstName);
	emp.put("lastName", lastName);
	emp.put("emailid", emailid);
	emp.put("password", password);
	emp.put("designation", designation);
	emp.put("dob", dob);
	emp.put("al1", al1);
	emp.put("al2", al2);
	emp.put("city", city);
	emp.put("state", state);
	emp.put("zipcode", zipcode);
	emp.put("phone", phone);
	return emp;
	
}

public int updateEmpInfo(String empcode,String email,String al1,String al2,String city,String state,String zipcode,String phone, String pwd){
	int i = 0;
	Connection con = DBConnection.getConnection();
	String q = "update EMPLOYEE set password='"+pwd+"',emailid='"+email+"',address1='"+al1+"',address2='"+al2+"',city='"+city+"',state='"+state+"',zipcode='"+zipcode+"',phoneNumber='"+phone+"' where empcode='"+empcode+"';";
	try {

	Statement s = con.createStatement();
	
			 i = s.executeUpdate(q);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return i;
}

public int insertTime(String empcode,String sdate,String stime){
	int i = 0;
	Connection con = DBConnection.getConnection();
	String q = "insert into TIMEPUNCHES(empcode,entrydate,entrytime) values('"+empcode+"','"+sdate+"','"+stime+"');";
	try {

	Statement s = con.createStatement();
	
			 i = s.executeUpdate(q);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return i;
}

public int updateTime(String empcode,String sdate,String edate,String etime){
	int i = 0;
	Connection con = DBConnection.getConnection();
	String q = "update TIMEPUNCHES set exitdate='"+edate+"',exittime='"+etime+"' where entrydate='"+sdate+"' and empcode='"+empcode+"';";
	try {

	Statement s = con.createStatement();
	
			 i = s.executeUpdate(q);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return i;
}

}
