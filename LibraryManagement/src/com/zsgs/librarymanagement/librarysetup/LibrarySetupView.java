package com.zsgs.librarymanagement.librarysetup;

import com.zsgs.librarymanagement.managebook.ManageBookView;
import com.zsgs.librarymanagement.model.Library;

import java.util.Scanner;

public class LibrarySetupView {
	  private  LibrarySetupModel librarySetupModel;
	  private boolean repeat;
	    public LibrarySetupView(){
	         librarySetupModel=new LibrarySetupModel(this);
	    }
	    public void init(){
	    	librarySetupModel.startSetup();
	    }
	    
	    public void onSetupComplete() {
	    	System.out.println("\nLibrary setup already completed");
			new ManageBookView().init();
	    }
	    
	    public void showAlert(String alert) {

			System.out.println(alert);
	    }
	    
	    public void initiateSetup() {
//	    	System.out.println("\n\nGet Library Details From Here.");
			Library library=new Library();
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter library id");
			int libraryId=scanner.nextInt();
			librarySetupModel.createLibrary(library);
	    
	    }


}
