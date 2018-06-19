package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Logindao;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = (String) request.getParameter("uname");
		String password = (String) request.getParameter("password");
		
		Logindao l = new Logindao();
		int count = l.loginAuth(uname, password);
		
		
	    
	    if(count>0){
	    		HttpSession session = request.getSession();
			String name = l.getNamefromreg(uname);
		    session.setAttribute("username", name);
		    session.setAttribute("empcode", l.getEmpcodefromreg(uname));
		    String roleid = l.getEmpcoderole(uname);
		    
		    if(roleid.equals("2")){
		    	request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		    }else{
		    	RequestDispatcher rd=request.getRequestDispatcher("emphome.jsp");
			    rd.forward(request,response);
		    }
		    
			
	    	
	    }else{
	    	request.setAttribute("loginerr", "Sorry error in login credentials");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		    rd.forward(request,response);
	    }
	}

}
