package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;

/**
 * Servlet implementation class UpdateProfile
 */

public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
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
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String al1 = request.getParameter("al1");
		String al2 = request.getParameter("al2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String phone = request.getParameter("phonenumber");
		String empcode = (String)request.getSession().getAttribute("empcode");
		EmployeeDao e = new EmployeeDao();
		int i = e.updateEmpInfo(empcode, email, al1, al2, city, state, zipcode, phone,password);
		if(i>0){
			request.setAttribute("success", "Successfully Updated");
			EmployeeDao e1 = new EmployeeDao();
			HttpSession session = request.getSession();
			LinkedHashMap<String, ArrayList> emp=e1.getEmployeeProfile((String)(session.getAttribute("empcode")));
			request.setAttribute("emp", emp);
			RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
		    rd.forward(request,response);
		}else{
			
			
			request.setAttribute("success", "Error in Update");
			EmployeeDao e1 = new EmployeeDao();
			HttpSession session = request.getSession();
			LinkedHashMap<String, ArrayList> emp=e1.getEmployeeProfile((String)(session.getAttribute("empcode")));
			request.setAttribute("emp", emp);
			RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
		    rd.forward(request,response);
			
			
		}
		
		
	}

}
