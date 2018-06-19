package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.DBConnection;

public class Employee {

	private String firstName;
	private String lastName;
	private String empcode;
	private String dob;
	private String address1;
	private String address2;
	private String phoneNumber;
	private String designation;
	private String city;
	private String state;
	private String zipcode;
	private String password;
	private String emailid;
	private String gender;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmpcode() {
		return empcode;
	}
	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String addEmployee() throws SQLException{
		Connection con = DBConnection.getConnection();
		String query="insert into EMPLOYEE(empcode, firstName, lastName, emailid, password, designation, dob, address1, address2, city, state, zipcode, phoneNumber, gender, roleid ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String query1 = "insert into EMPLOYEE_HISTORY (empcode, designation, salary, month, year) values(?,?,?,?,?)";
		String query2 = "select basicSalary from designation where designation = '"+designation+"'";
		String msg = "Failed to add employee";
		try{
			PreparedStatement ps = con.prepareStatement(query);
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps.setString(1, empcode);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, emailid);
			ps.setString(5, password);
			ps.setString(6, designation);
			ps.setString(7, dob);
			ps.setString(8, address1);
			ps.setString(9, address2);
			ps.setString(10, city);
			ps.setString(11, state);
			ps.setString(12, zipcode);
			ps.setString(13, phoneNumber);
			ps.setString(14, gender);
			ps.setString(15, "1");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query2);
			if(rs.next()){
			ps1.setString(1, empcode);
			ps1.setString(2, designation);
			ps1.setString(3, rs.getString("basicSalary"));
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			String c = format.format(new Date());
			String[] cq = c.split("-");
			ps1.setInt(4, Integer.parseInt(cq[1]));
			ps1.setString(5, cq[0]);
			ps1.executeUpdate();
			}
			if(ps.executeUpdate() != 0 ){
				msg = "Employee successfully added";
			}else{
				msg = "Failed to add employee";
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		
		return msg;
	}
	
	
	
	public ArrayList<String[]> viewEmployee() throws SQLException{
		Connection con = DBConnection.getConnection();
		ArrayList<String[]> al = new ArrayList<String[]>();
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from EMPLOYEE ");
			while(rs.next()){
				String[] d = new String[4];
				d[0] = rs.getString("firstName");
				d[1] = rs.getString("lastName");
				d[2] = rs.getString("emailid");
				d[3] = rs.getString("designation");
				al.add(d);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		
		return al;
	}
	
	
}
