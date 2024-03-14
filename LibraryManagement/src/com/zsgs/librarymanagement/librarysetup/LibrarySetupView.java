package com.zsgs.librarymanagement.librarysetup;

import com.zsgs.librarymanagement.managebook.ManageBookView;

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
	    
	    public void showAlert() {
	    	System.out.println("\nPrint any errors here.");
	    }
	    
	    public void initiateSetup() {
	    	System.out.println("\n\nGet Library Details From Here.");
	    
	    }


}
