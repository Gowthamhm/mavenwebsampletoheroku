package com.qrcode.bean;

public class UserBean {
	 private static String username;
     private static String password;
     private static boolean valid;
     private static String email;
     private static boolean confvalid;
     private static String folder_name;

	public String getPassword() {
        return password;
	}

     public void setPassword(String newPassword) {
        password = newPassword;
	}
			
     public String getUsername() {
        return username;
			}

     public void setUserName(String newUsername) {
        username = newUsername;
			}

				
     public boolean isValid() {
        return valid;
	}

     public void setValid(boolean newValid) {
        valid = newValid;
	}

	public  String getEmail() {
		return email;
	}

	public  void setEmail(String email) {
		UserBean.email = email;
	}

	public  boolean isConfvalid() {
		return confvalid;
	}

	public  void setConfvalid(boolean confvalid) {
		UserBean.confvalid = confvalid;
	}

	public String getFolder_name() {
		return folder_name;
	}

	public void setFolder_name(String folder_name) {
		this.folder_name = folder_name;
	}
	

}
