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

public class Designation {

	private String designation;
	private String basicSalary;
	private String houseRentAllowance;
	private String dearnessAllowance;
	private String workAllowance;
	private String generalProvidentFund;
	private String stateTax;
	private String federalTax;
	private String providentFund;
	private String insurance;
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(String basicSalary) {
		this.basicSalary = basicSalary;
	}
	public String getHouseRentAllowance() {
		return houseRentAllowance;
	}
	public void setHouseRentAllowance(String houseRentAllowance) {
		this.houseRentAllowance = houseRentAllowance;
	}
	public String getDearnessAllowance() {
		return dearnessAllowance;
	}
	public void setDearnessAllowance(String dearnessAllowance) {
		this.dearnessAllowance = dearnessAllowance;
	}
	public String getWorkAllowance() {
		return workAllowance;
	}
	public void setWorkAllowance(String workAllowance) {
		this.workAllowance = workAllowance;
	}
	public String getGeneralProvidentFund() {
		return generalProvidentFund;
	}
	public void setGeneralProvidentFund(String generalProvidentFund) {
		this.generalProvidentFund = generalProvidentFund;
	}
	public String getStateTax() {
		return stateTax;
	}
	public void setStateTax(String stateTax) {
		this.stateTax = stateTax;
	}
	public String getFederalTax() {
		return federalTax;
	}
	public void setFederalTax(String federalTax) {
		this.federalTax = federalTax;
	}
	public String getProvidentFund() {
		return providentFund;
	}
	public void setProvidentFund(String providentFund) {
		this.providentFund = providentFund;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	
	public String addDesignation() throws SQLException{
		Connection con = DBConnection.getConnection();
		String query="insert into DESIGNATION(designation, basicSalary) values(?,?)";
		String query1="select empcode from EMPLOYEE where designation='"+designation+"'";
		String query2 = "insert into EMPLOYEE_HISTORY (empcode, designation, salary, month, year) values(?,?,?,?,?)";
		String msg = "Failed to add designation";
		try{
			Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, designation);
			ps.setString(2, basicSalary);
			ResultSet rs = st.executeQuery(query1);
			PreparedStatement ps1 = con.prepareStatement(query2);
			
			while(rs.next()){
			ps1.setString(1, rs.getString("empcode"));
			ps1.setString(2, designation);
			ps1.setString(3, basicSalary);
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			String c = format.format(new Date());
			String[] cq = c.split("-");
			ps1.setInt(4, Integer.parseInt(cq[1]));
			ps1.setString(5, cq[0]);
			ps1.executeUpdate();
			}
			
			if(ps.executeUpdate() != 0 ){
				msg = "Designation successfully added";
			}else{
				msg = "Failed to add designation";
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			msg = "Failed to add designation";
		}finally{
			con.close();
		}
		
		return msg;

	}
	
	
	public String addBenefits() throws SQLException{
		Connection con = DBConnection.getConnection();
		String query="update DESIGNATION set basicSalary=?, houseRentAllowance=?, dearnessAllowance=?, workAllowance=?  where designation =?";
		String msg = "Failed to add Benefits";
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, basicSalary);
			ps.setString(2, houseRentAllowance);
			ps.setString(3, dearnessAllowance);
			ps.setString(4, workAllowance);
		    ps.setString(5, designation);
			if(ps.executeUpdate() != 0 ){
				msg = "Benefits successfully added";
			}else{
				msg = "Failed to add Benefits";
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			msg = "Failed to add Benefits";
		}finally{
			con.close();
		}
		
		return msg;
		
	}
	
	public String addDeductions() throws SQLException{
		
		Connection con = DBConnection.getConnection();
		String query="update DESIGNATION set basicSalary=?, generalProvidentFund=?, stateTax=?, federalTax=?, providentFund=?, insurance=? where designation =?";
		String msg = "Failed to add employee";
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, basicSalary);
			ps.setString(2, generalProvidentFund);
			ps.setString(3, stateTax);
			ps.setString(4, federalTax);
			ps.setString(5, providentFund);
			ps.setString(6, insurance);
			ps.setString(7, designation);
			if(ps.executeUpdate() != 0 ){
				msg = "Deductions successfully added";
			}else{
				msg = "Failed to add Deductions";
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			msg = "Failed to add Deductions";
		}finally{
			con.close();
		}
		
		return msg;	
	}
	
	public ArrayList<String[]> getData() throws SQLException{
		Connection con = DBConnection.getConnection();
		String query="select designation, basicSalary from DESIGNATION";
		ArrayList<String[]> data = new ArrayList<String[]>();
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				String[] da = new String[2];
				da[0] = rs.getString("designation");
				da[1] = rs.getString("basicSalary");
				data.add(da);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		
		return data;
		
	}
	
	
}
