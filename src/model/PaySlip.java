package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DBConnection;

public class PaySlip {

	private String empcode;
	private String month;
	private String year;
	public String getEmpcode() {
		return empcode;
	}
	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	String salary1, name;
	
	public String[] calcucatePaySlip() throws SQLException{
		String pay[] = new String[11];
		String query = "select salary, month from EMPLOYEE_HISTORY where empcode ='"+empcode+"' and year='"+year+"'";
		Connection con = DBConnection.getConnection();
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			int month1 = Integer.parseInt(month);
			while(rs.next()){
				int m = rs.getInt("month");
				String s = rs.getString("salary");
				salary1 = s;
				if(rs.next()){
				int m1 = rs.getInt("month");
//				String s1 = rs.getString("salary");
				if(month1 >= m && month1 < m1){
					break;
				}
				}
			}
			float hra = (float) 0.0, da = (float) 0.0, wa = (float) 0.0, gpf = (float) 0.0, stateTax = (float) 0.0, federalTax = (float) 0.0, insurance = (float) 0.0, pf = (float) 0.0, salary = (float) 0.0;
			salary = Float.parseFloat(salary1); 
			String query1 = "select firstName, lastName, designation from EMPLOYEE where empcode ='"+empcode+"'";
			st  = con.createStatement();
			rs = st.executeQuery(query1);
			Statement st1 = con.createStatement();
			
			if(rs.next()){
				name = rs.getString("firstName")+" "+rs.getString("lastName");
				String query2 = "select houseRentAllowance, dearnessAllowance, workAllowance, generalProvidentFund, stateTax, federalTax, providentFund, insurance from DESIGNATION where designation ='"+rs.getString("designation")+"'";  
				ResultSet rs1 = st1.executeQuery(query2);
				try{
				if(rs1.next()){
					hra = Float.parseFloat(rs1.getString("houseRentAllowance"));
					da = Float.parseFloat(rs1.getString("dearnessAllowance"));
					wa = Float.parseFloat(rs1.getString("workAllowance"));
					gpf = Float.parseFloat(rs1.getString("generalProvidentFund"));
					stateTax = Float.parseFloat(rs1.getString("stateTax"));
					federalTax = Float.parseFloat(rs1.getString("federalTax"));
					pf = Float.parseFloat(rs1.getString("providentFund"));
					insurance = Float.parseFloat(rs1.getString("insurance"));
				}
				}catch(NullPointerException e){
					
				}
			}
			pay[0]=name;
			pay[1]=salary+"";
			pay[2]=""+(hra/100)*salary;
			pay[3]=""+(da/100)*salary;
			pay[4]=""+(wa/100)*salary;
			pay[5]=""+(gpf/100)*salary;
			pay[6]=""+(stateTax/100)*salary;
			pay[7]=""+(federalTax/100)*salary;
			pay[8]=""+(pf/100)*salary;
			pay[9]=""+(insurance/100)*salary;
		  salary = salary + ((hra / 100) + (da / 100) + (wa / 100) - (gpf / 100) - (stateTax / 100) - (federalTax / 100) - (pf / 100) - (insurance / 100)) * salary;	
			pay[10]=""+salary;
			
		}catch(SQLException e){
			e.printStackTrace();
			pay = null;
		}
		catch(NullPointerException n){
			n.printStackTrace();
			pay = null;
		}
		finally{
			con.close();
		}
		
		return pay;
	}
	
}
