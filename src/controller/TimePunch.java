package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnection;
import dao.EmployeeDao;
import dao.Logindao;

/**
 * Servlet implementation class TimePunch
 */

public class TimePunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimePunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		 String action = (String) request.getParameter("action");
		 
		 if(!action.equals("ExitPunch")){
		 
		 Date date = new Date();
		
		 
		 SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
		 String dateentry = sdfr.format(date);
		 
		 SimpleDateFormat sdfr1 = new SimpleDateFormat("HH:mm:ss");
		 String timeentry = sdfr1.format(date);
		 
		 request.setAttribute("dateentry", dateentry);
		 request.setAttribute("timeentry", timeentry);
		 
		 EmployeeDao e = new EmployeeDao();
			e.insertTime((String)request.getSession().getAttribute("empcode"), dateentry, timeentry);
		 
		 RequestDispatcher rd=request.getRequestDispatcher("timepunch.jsp");
		    rd.forward(request,response);
		
		 
		 }
		 
		 if(action.equals("ExitPunch")){
			 Date dateexit = new Date();
			 DateFormat df1 = new SimpleDateFormat("hh");
			 String hourexit = df1.format(dateexit);
			 
			
			 String designation = new Logindao().getDesignationfromreg((String)request.getSession().getAttribute("empcode"));
			 
			Connection conn = DBConnection.getConnection();
				String sal = null;
				try {
					Statement stmt = conn.createStatement();
					ResultSet rs = null;
					//createCon();
					String q = "Select basicSalary from DESIGNATION Where designation='" + designation + "'";
					rs = stmt.executeQuery(q);
					while (rs.next()) {
						 sal = rs.getString("basicsalary");
						 System.out.println(sal);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
					sal = "NO";
				}finally{
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				
				
				 SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MMM/yyyy");
				 String dateexits = sdf4.format(dateexit);
				 
				 SimpleDateFormat sdfr3 = new SimpleDateFormat("HH:mm:ss");
				 String timeexits = sdfr3.format(dateexit);
				 
				 
				 
				 
				 
				 
				 
				 Date date = new Date();
					
				 String k = null;
				 String p=null;
				 SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
				 String dateentry = sdfr.format(date);
				 Connection con = DBConnection.getConnection();
				 String q = "Select entrytime,entrydate from TIMEPUNCHES where entrydate='"+dateentry+"';";
				 try {
						Statement s = con.createStatement();
					
					ResultSet rs = s.executeQuery(q);
					while(rs.next()){
						 k = rs.getString("entrytime");
						 
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
					
						String hour = k.split(":")[0];
				 
				 int h = Math.abs(Integer.parseInt(hour) - Integer.parseInt(hourexit));
				 
				 System.out.println(sal);
				 System.out.println(h);
				 int salary = (Integer.parseInt(sal)/1920)*(h);
				 
				 request.setAttribute("dateentry", dateentry);
				 request.setAttribute("timeentry", k);
				 request.setAttribute("dateexits", dateexits);
				 request.setAttribute("timeexits", timeexits);
				request.setAttribute("sal", salary);
				
				EmployeeDao e = new EmployeeDao();
				e.updateTime((String)request.getSession().getAttribute("empcode"), dateentry, dateexits, timeexits);
				 RequestDispatcher rd2=request.getRequestDispatcher("timepunch.jsp");
				    rd2.forward(request,response);
			 
		 }
	}

}}
