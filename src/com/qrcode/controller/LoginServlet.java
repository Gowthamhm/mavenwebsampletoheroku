package com.qrcode.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qrcode.bean.FolderBean;
import com.qrcode.bean.UserBean;
import com.qrcode.dao.DbConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserBean ub = new UserBean();
		DbConnection db = new DbConnection();
		
		HttpSession session=request.getSession();  
        session.setAttribute("user", user);
        
		PrintWriter out = response.getWriter();
		ub.setUserName(user);
		ub.setPassword(password);
		db.login(ub);
		
		Boolean valid =ub.isValid();
		
//		System.out.println(user);
//		System.out.println(password);
//		System.out.println(valid);
		if(valid==true) {
			ArrayList<FolderBean> folderDetail = db.getAllFolderDetails();
for(int i=0;i<folderDetail.size();i++) {
	System.out.println(folderDetail.get(i));
	System.out.println(folderDetail.get(i).getCreator());
	System.out.println(folderDetail.get(i).getFolder_name());
}
			request.setAttribute("folderDetail", folderDetail);
			session.setAttribute("folderDetail", folderDetail);
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
	
		}else {
//			request.setAttribute("error", "Login failed");
//		request.getRequestDispatcher("login.jsp").forward(request, response);
			out.println("<script type=\"text/javascript\">");
			out.println("location='login.jsp';");
			out.println("</script>");
		}
	}

}
