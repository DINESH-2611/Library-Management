package com.zsgs.librarymanagement.librarysetup;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.zsgs.librarymanagement.managebook.ManageBookView;
import com.zsgs.librarymanagement.model.Library;

public class LibrarySetupView {
	  private  LibrarySetupModel librarySetupModel;
	    public LibrarySetupView(){
	         librarySetupModel=new LibrarySetupModel(this);
	    }
	    public void init(){
	    	librarySetupModel.startSetup();
	    }
	    
	    public void onSetupComplete() {
	    	System.out.println("\nLibrary setup  completed");
			new ManageBookView().init();
	    }
	    
	    public void showAlert(String alert) {
	    	System.out.println(alert);
	    }
	    
	    public void initiateSetup() {
//	    	System.out.println("\n\nGet Library Details From Here.");
	    	
			Scanner scanner=new Scanner(System.in);
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
