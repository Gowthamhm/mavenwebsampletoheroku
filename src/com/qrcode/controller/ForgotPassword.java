package com.qrcode.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qrcode.bean.UserBean;
import com.qrcode.dao.DbConnection;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
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
//		doGet(request, response);
		String user = request.getParameter("username");
		String email = request.getParameter("email");
		String newpassword = request.getParameter("newpassword");
		String confpassword = request.getParameter("confirmpassword");
		
		UserBean ub = new UserBean();
		DbConnection db = new DbConnection();
		PrintWriter out = response.getWriter();
		System.out.println(newpassword+"             "+confpassword);
		if(newpassword.equals(confpassword)) {
			 ub.setPassword(newpassword);	
		}else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Entered New Password and Confirm Password are not equal');");
			out.println("location='forgot.jsp';");
			out.println("</script>");
		}
		 ub.setUserName(user);
		 ub.setEmail(email);
		 db.updatepassword(ub);
		 
		//	System.out.println(ub.isConfvalid());
			/*
			 * System.out.println(user); System.out.println(email);
			 * System.out.println(newpassword); System.out.println(confpassword);
			 */
		 if(ub.isConfvalid() == true) {
			 out.println("<script type=\"text/javascript\">");
				out.println("alert('Password Updated Successfully,Login using Username and New Password');");
				out.println("location='login.jsp';");
				out.println("</script>");
		 }else if(ub.isConfvalid() ==false) {
			 out.println("<script type=\"text/javascript\">");
				out.println("alert('Provided Username or email id is Invalid');");
				out.println("location='forgot.jsp';");
				out.println("</script>");
		 }
	}

}
