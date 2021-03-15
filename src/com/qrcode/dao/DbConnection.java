package com.qrcode.dao;


import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qrcode.bean.FolderBean;
import com.qrcode.bean.UserBean;


public class DbConnection {
	Connection conn;
	UserBean bean = new UserBean();
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public DbConnection() throws IOException{
		String rootPath = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			String path = getPath();
			rootPath = path+"MyDB";
			System.out.println(rootPath);
			this.conn= DriverManager.getConnection("jdbc:derby:"+rootPath+";create=true","","");
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
	public String getPath() throws IOException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String rootPath = fullPath.replace(".metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/","");
		rootPath = rootPath.replace("WEB-INF/classes/","WebContent/WEB-INF/");
		rootPath = rootPath.replace("/","\\").substring(1);
		System.out.println(rootPath);
		return rootPath;
}
	public UserBean login(UserBean ub) {
		Statement stmt = null;

		String username = bean.getUsername();
		String password = bean.getPassword();
		
		ResultSet rs=null;
		String searchQuery = "select * from users where username='" + username + "' AND password='" + password + "'";
		System.out.println("Your user name is " + username);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + searchQuery);
		try {
			stmt = conn.createStatement();
		
	//	System.out.println(stmt);
		rs = stmt.executeQuery(searchQuery);
	//	System.out.println(rs);
		boolean more = rs.next();

		// if user does not exist set the isValid variable to false
		if (!more) {
			System.out.println("Sorry, you are not a registered user! Please sign up first");
			bean.setValid(false);
		}

		// if user exists set the isValid variable to true
		else if (more) {
			String dbusername = rs.getString("username");
			String dbpassword = rs.getString("password");
	     	
            System.out.println("Welcome " + dbusername );
            System.out.println("password " + dbpassword );
            bean.setValid(true);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ub;
	}
	public UserBean updatepassword(UserBean ub) {
		Statement stmt = null;
		String username=bean.getUsername();
		String email= bean.getEmail();
		String password = bean.getPassword();
		ResultSet rs=null;
		String searchQuery = "select * from users where username='" + username + "' AND email_id='" + email + "'";
		try {
			stmt = conn.createStatement();
	//	System.out.println(stmt);
		rs = stmt.executeQuery(searchQuery);
	//	System.out.println(rs);
		boolean more = rs.next();

		// if user does not exist set the isValid variable to false
		if (!more) {
			System.out.println("Sorry, you are not a registered user! Please sign up first");
			bean.setConfvalid(false);
		}

		// if user exists set the isValid variable to true
		else if (more) {
			String upquery = "update users set password='"+password + "'where username='"+username+"'and email_id ='"+email+"'";
			try {
				stmt = conn.createStatement();
				int num = stmt.executeUpdate(upquery);
				System.out.println("Number of records updated are: "+num);
				if(num==1) {
					bean.setConfvalid(true);	
				}else if(num > 1) {
					
				}else {
					System.out.println("Not Updated Successfully");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
            
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ub;
	}
	public void createFolder() throws SQLException {
		FolderBean fb = new FolderBean();
		String folder_name = bean.getFolder_name();
		String username=bean.getUsername();
		ResultSet rs=null;
		Statement stmt = null;
		stmt = conn.createStatement();
		System.out.println(folder_name);
		System.out.println(username);
		
		String query = "insert into FOLDERS("
                + "folder_name, creator) VALUES "
                + "('" + folder_name + "',"
                + "'" + username + "')";
		System.out.println(query);
       stmt.execute(query);
       System.out.println("Values inserted");

	}
	
	public ArrayList<FolderBean> getAllFolderDetails()
	{
		ResultSet rs = null;
		PreparedStatement ps=null;
		
		ArrayList<FolderBean> folders = new ArrayList<FolderBean>();
		
			String query1 = "Select * from Folders ";
			try {
				ps = conn.prepareStatement(query1);
				rs = ps.executeQuery();
				while(rs.next())
				{
					FolderBean fb = new FolderBean();
					//System.out.println(rs.getString("foldername"));
					fb.setFolder_name(rs.getString("folder_name"));
					//String folder_name = rs.getString("foldername"); 
					//System.out.println(rs.getString("creator"));
					fb.setCreator(rs.getString("creator"));
					System.out.println(fb);
					folders.add(fb);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return folders;
	}
}