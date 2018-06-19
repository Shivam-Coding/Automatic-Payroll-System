package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Designation;

/**
 * Servlet implementation class DesignationServlet
 */

public class DesignationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DesignationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("addDesignation")){
		String designation = request.getParameter("adddesignation");
		String basicSalary = request.getParameter("basicsalary");
		Designation desig = new Designation();
		desig.setBasicSalary(basicSalary);
		desig.setDesignation(designation);
		String msg = null;
		try {
			msg = desig.addDesignation();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "Failed to add";
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("addDesignation.jsp").forward(request, response);
		}
		
		
		if(action.equals("addBenefits")){
			String designation = request.getParameter("designation");
			String basicSalary = request.getParameter("basicsalary");
			String houseRentAllowance = request.getParameter("hra");
			String dearnessAllowance = request.getParameter("da");
			String workAllowance = request.getParameter("wa");
			Designation desig = new Designation();
			desig.setBasicSalary(basicSalary);
			desig.setDesignation(designation);
			desig.setHouseRentAllowance(houseRentAllowance);
			desig.setDearnessAllowance(dearnessAllowance);
			desig.setWorkAllowance(workAllowance);
			String msg = null;
			ArrayList<String[]> data = new ArrayList<String[]>();
			try {
				msg = desig.addBenefits();
				data = desig.getData();
				request.setAttribute("data", data);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg = "Failed to add";
			}
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("addBenefits.jsp").forward(request, response);
			}
		
		if(action.equals("addDeduction")){
			String designation = request.getParameter("designation");
			String basicSalary = request.getParameter("basicsalary");
			String generalProvidentFund = request.getParameter("gpf");
			String stateTax = request.getParameter("stateTax");
			String federalTax = request.getParameter("federalTax");
			String providentFund = request.getParameter("pf");
			String insurance = request.getParameter("insurane");
			Designation desig = new Designation();
			desig.setBasicSalary(basicSalary);
			desig.setDesignation(designation);
			desig.setGeneralProvidentFund(generalProvidentFund);
			desig.setStateTax(stateTax);
			desig.setFederalTax(federalTax);
			desig.setProvidentFund(providentFund);
			desig.setInsurance(insurance);
			String msg = null;
			ArrayList<String[]> data = new ArrayList<String[]>();
			try {
				msg = desig.addDeductions();
				data = desig.getData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg = "Failed to add";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("data", data);
			request.getRequestDispatcher("addDeductions.jsp").forward(request, response);
			}
		
		if(action.equals("data")){
			String page = request.getParameter("page");
			ArrayList<String[]> data = new ArrayList<String[]>();
			Designation design = new Designation();
			try{
				data = design.getData();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			request.setAttribute("data", data);
			if(page.equals("benefits")){
			request.getRequestDispatcher("addBenefits.jsp").forward(request, response);
			}
			if(page.equals("deductions")){
				request.getRequestDispatcher("addDeductions.jsp").forward(request, response);
			}
			if(page.equals("addemployee")){
				request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
			}
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
