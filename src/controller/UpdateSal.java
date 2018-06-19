package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnection;

/**
 * Servlet implementation class UpdateSal
 */

public class UpdateSal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSal() {
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
		
		Connection con = DBConnection.getConnection();
		String des = (String) request.getParameter("designation");
		String salary = (String) request.getParameter("basicsalary");
		System.out.println(salary);
		String q = "Update DESIGNATION set basicSalary='"+salary+"' where designation='"+des+"';";
		int i=0;
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
		if(i>0){
			Connection con2 = DBConnection.getConnection();
			String query="select designation, basicSalary from DESIGNATION";
			ArrayList<String[]> data = new ArrayList<String[]>();
			try{
				Statement st = con2.createStatement();
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
				try {
					con2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		request.setAttribute("data", data);
		request.setAttribute("success", "Update Successful");
		
		RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
	    rd.forward(request,response);
	
		}else{
			
			
			Connection con2 = DBConnection.getConnection();
			String query="select designation, basicSalary from DESIGNATION";
			ArrayList<String[]> data = new ArrayList<String[]>();
			try{
				Statement st = con2.createStatement();
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
				try {
					con2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		request.setAttribute("data", data);
		request.setAttribute("success", "Update not Successful");

		
		RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
	    rd.forward(request,response);
			
		}
		
	}

}
