package com.zsgs.librarymanagement;


import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.login.LoginView;
import com.zsgs.librarymanagement.model.Credentials;



public class LibraryManagement {
	private static  LibraryManagement libraryManagement;
	
	private String appName = "Library Management System";

	private String appVersion = "0.1.0";


	
	private LibraryManagement() {
		
	}
	
	public static LibraryManagement getInstance() {
		if(libraryManagement == null) {
			libraryManagement = new LibraryManagement();
		}
		return libraryManagement;
	}
	private void create() {
//		LibraryDatabase.getInstance().createCredentials();
//		LibraryDatabase.getInstance().credentialsFromFile();
		LoginView loginView = new LoginView();
		loginView.init();
	}



	public String getAppName() {
		return appName;
	}

	public String getAppVersion() {
		return appVersion;
	}


	public static void main(String[] args) {
		LibraryManagement.getInstance().create();
	}

}
