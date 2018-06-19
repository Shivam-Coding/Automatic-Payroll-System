package controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PaySlip;

/**
 * Servlet implementation class PaySlipServlet
 */

public class PaySlipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaySlipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("adminPaySlip")){
		
		String empcode = request.getParameter("employeecode");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		PaySlip ps = new PaySlip();
		ps.setEmpcode(empcode);
		ps.setMonth(month);
		ps.setYear(year);
		String[] pay = null;
		try{
			pay = ps.calcucatePaySlip();
		}catch(SQLException e){
			e.printStackTrace();
		}
		request.setAttribute("pay", pay);
		request.getRequestDispatcher("viewPaySlip.jsp").forward(request, response);
		
		}
		if(action.equals("paySlip")){
			HttpSession se = request.getSession();
			String empcode = (String) se.getAttribute("empcode");
			String month = request.getParameter("month");
			String year = request.getParameter("year");
			PaySlip ps = new PaySlip();
			ps.setEmpcode(empcode);
			ps.setMonth(month);
			ps.setYear(year);
			String[] pay = null;
			try{
				pay = ps.calcucatePaySlip();
			}catch(SQLException e){
				e.printStackTrace();
			}
			request.setAttribute("pay", pay);
			request.getRequestDispatcher("viewPaySlipEmp.jsp").forward(request, response);
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
