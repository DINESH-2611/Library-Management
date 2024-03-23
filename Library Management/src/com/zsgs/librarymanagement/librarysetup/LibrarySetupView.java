package com.zsgs.librarymanagement.librarysetup;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.zsgs.librarymanagement.LibraryManagement;
import com.zsgs.librarymanagement.assignbook.AssignBookView;
import com.zsgs.librarymanagement.changepassword.ChangePasswordView;
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
	    	
	    	try {
	    		
	    	System.out.println("\nLibrary setup  completed");
	    	showLibraryName(library.getLibraryName());
	    	
	    	while(true) {
//	    		scanner.nextLine();
	    		System.out.println("1.Manage Books\n2.Manage User\n3.Change Password\n4.Manage Issue Book\n5.Logout\nEnter the choice");
//	    		scanner.nextLine();
	    		int choice=scanner.nextInt();
//	    		scanner.nextLine();
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
						new ChangePasswordView().init();
						break;
					}
				case 4:{
					new AssignBookView().init();
					break;
				}
	    		case 5:{
	    			System.out.println("\t\t\tYou are logged out successfully");
	    			new LoginView().init();
	    			return;
	    		}
//					case 6:System.out.println("\t\t\tYou are logged out successfully");
//	    			new LoginView().init();
//						return;
	    		case 0:{
	    			return;
	    		}
	    		default:{
	    			System.out.println("Invalid choice,Please Enter valid choice");
	    		}
	    		}
	    	}
	    	}	catch (InputMismatchException e) {
				showAlert("Type mismatch,Enter valid choice");
				onSetupComplete(library);
			}
			
	    }
	    
	    private void showLibraryName(String libraryName) {
			System.out.println("Current Library Name-"+libraryName);
			
		}
		public void showAlert(String alert) {
	    	System.out.println(alert);
	    }
	    
	    public void initiateSetup() {
	    	System.out.println("\n");
//	    	System.out.println("\n\nGet Library Details From Here.");
	    	
			try {
//				scanner.nextLine();
			System.out.println("Enter library name");
			String libraryName=scanner.next();
			scanner.nextLine();
			System.out.println("Enter library email");
			String emailId=scanner.next();
			System.out.println("Enter libray address");
			String address=scanner.next();
			System.out.println("Enter library phone no");
			long phoneNo=scanner.nextLong();
			System.out.println("Enter library id");
			int libraryId=scanner.nextInt();
			librarySetupModel.setupLibrary(libraryName, emailId, address, phoneNo, libraryId);
	    
	    }catch (InputMismatchException e) {
			showAlert("Type mismatch,Enter valid details");
			scanner.nextLine();
			initiateSetup();
			}
	    }


}
