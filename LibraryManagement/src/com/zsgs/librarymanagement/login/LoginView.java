package com.zsgs.librarymanagement.login;

import java.util.Scanner;

import com.zsgs.librarymanagement.LibraryManagement;
import com.zsgs.librarymanagement.librarysetup.LibrarySetupView;

public class LoginView {
	  private LoginModel loginModel;
	   public LoginView(){
	       loginModel=new LoginModel(this);

	    }
	    public void init(){
	    	System.out.println("--- " + LibraryManagement.getInstance().getAppName() + " --- \nversion "
					+ LibraryManagement.getInstance().getAppVersion());
	        Scanner scanner=new Scanner(System.in);
	        System.out.println("Enter the username");
	        String userName=scanner.next();
	        System.out.println("Enter the password");
	        String password=scanner.next();
	        loginModel.validateUser(userName,password);

	    }
	    public void onSuccess(){
	    	System.out.flush();
			System.out.println("\n\nLogin successful...\n\n ---- welcome to " + LibraryManagement.getInstance().getAppName()
					+ " - v" + LibraryManagement.getInstance().getAppVersion() + "----");
	        System.out.println("Login Success");
	        LibrarySetupView librarySetupView=new LibrarySetupView();
	        librarySetupView.init();
	    }
	    public void showAlert(String alert){
	        System.out.println(alert);
	    }

}
