package com.zsgs.librarymanagement.librarysetup;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.zsgs.librarymanagement.LibraryManagement;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.login.LoginView;
import com.zsgs.librarymanagement.managebook.ManageBookView;
import com.zsgs.librarymanagement.manageuser.ManageUserView;
import com.zsgs.librarymanagement.model.Library;

public class LibrarySetupView {
	Scanner scanner=new Scanner(System.in);
	  private  LibrarySetupModel librarySetupModel;
	    public LibrarySetupView(){
	         librarySetupModel=new LibrarySetupModel(this);
	    }
	    public void init(){
	    	librarySetupModel.startSetup();
	    }
	    
	    public void onSetupComplete(Library library ) {
	    	System.out.println("\nLibrary setup  completed");
	    	showLibraryName(library.getLibraryName());
	    	while(true) {
	    		System.out.println("1.Manage Books\n2.Add User\n3.Logout\n0.Exit\nEnter the choice");
	    		int choice=0;
	    		try {
					choice=scanner.nextInt();
				} catch (InputMismatchException e) {
					showAlert("Type mismatch,Enter valid choice");
					onSetupComplete(library);
				}
	    		scanner.nextLine();
	    		switch(choice) {
	    		case 1:{
	    			new ManageBookView().init();
	    			break;
	    		}
	    		case 2:{
	    			new ManageUserView().init();
	    			break;
	    		}
	    		case 3:{
	    			System.out.println("\t\t\tYou are logged out successfully");
	    			new LoginView().init();
	    			return;
	    		}
	    		case 0:{
	    			System.out.println("\t\t\t---Thanks for using "+LibraryManagement.getInstance().getAppName()+"---");
	    			return;
	    		}
	    		default:{
	    			System.out.println("Invalid choice,Please Enter valid choice");
	    		}
	    		}
	    	}
			
	    }
	    
	    private void showLibraryName(String libraryName) {
			System.out.println("Current Library Name-"+libraryName);
			
		}
		public void showAlert(String alert) {
	    	System.out.println(alert);
	    }
	    
	    public void initiateSetup() {
//	    	System.out.println("\n\nGet Library Details From Here.");
	    	
			
			System.out.println("Enter library name");
			String libraryName=scanner.next();
			scanner.nextLine();
			System.out.println("Enter library email");
			String emailId=scanner.next();
			System.out.println("Enter libray address");
			String address=scanner.next();
			System.out.println("Enter library phone no");
			long phoneNo=0;
			int libraryId=0;
			try {
				 phoneNo=scanner.nextLong();
			} catch (InputMismatchException e) {
				System.out.println("Invalid phone number,Enter valid ph no");
				initiateSetup();
			}
			System.out.println("Enter library id");
			try {
				 libraryId=scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid library id,Enter valid library id");
				initiateSetup();
			}
			
			librarySetupModel.setupLibrary(libraryName, emailId, address, phoneNo, libraryId);
	    
	    }


}
