package com.qrcode.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qrcode.bean.FolderBean;
import com.qrcode.bean.UserBean;
import com.qrcode.dao.DbConnection;

/**
 * Servlet implementation class CreateFolder
 */
@WebServlet("/CreateFolder")
public class CreateFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateFolder() {
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
		String folder_name = request.getParameter("folder");
		String username = request.getParameter("username");
		
		PrintWriter out = response.getWriter();
		UserBean ub = new UserBean();
		DbConnection db=new DbConnection();
		FolderBean fb = new FolderBean();
		
//		System.out.println(folder_name);
//		System.out.println(username);
		ub.setFolder_name(folder_name);
		fb.setFolder_name(folder_name);
		ub.setUserName(username);
		
		
		try {
			db.createFolder();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println("<script type=\"text/javascript\">");
		out.println("location='home.jsp';");
		out.println("</script>");
	}

}
