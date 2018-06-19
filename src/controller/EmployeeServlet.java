package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */

public class EmployeeServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action.equals("addEmp")){
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String empcode = request.getParameter("employeecode");
		String emailid = request.getParameter("email");
		String address1 = request.getParameter("al1");
		String address2 = request.getParameter("al2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String phoneNumber = request.getParameter("phonenumber");
		String dob = request.getParameter("dob");
		String designation = request.getParameter("designation");
//		String password = request.getParameter("");
		String gender = request.getParameter("gender");
		
		Employee emp = new Employee();
		emp.setAddress1(address1);
		emp.setAddress2(address2);
		emp.setCity(city);
		emp.setDesignation(designation);
		emp.setDob(dob);
		emp.setEmailid(emailid);
		emp.setEmpcode(empcode);
		emp.setFirstName(firstName);
		emp.setGender(gender);
		emp.setLastName(lastName);
		emp.setState(state);
		emp.setZipcode(zipcode);
		emp.setPhoneNumber(phoneNumber);
		emp.setPassword("changeme");
		String msg = null;
		try {
			msg = emp.addEmployee();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "Failed to add";
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
		}
		
		if(action.equals("viewEmp")){
			
			ArrayList<String[]> al = new ArrayList<String[]>();
			Employee emp = new Employee();
			try{
				al = emp.viewEmployee();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			request.setAttribute("data", al);
			request.getRequestDispatcher("viewEmployee.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
