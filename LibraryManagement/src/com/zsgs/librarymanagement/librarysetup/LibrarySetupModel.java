package com.zsgs.librarymanagement.librarysetup;

import com.zsgs.librarymanagement.model.Library;

class LibrarySetupModel {
	private LibrarySetupView librarySetupView;
	private Library library=new Library();
//    public LibrarySetupModel(LibrarySetupView librarySetupView) {
//       
//    }
   
	public LibrarySetupModel(LibrarySetupView librarySetupView) {
		 this.librarySetupView=librarySetupView;
//	        library.setLibraryName("ZSGS Library");
//	        library.setLibraryId(1);
//	        library.setPhoneNo(97654321);
//	        library.setEmailId("zsgs.soho@gmail.com");
//	        library.setAddress("Tenkasi");
	}

	public void startSetup() {
		if (library == null || library.getLibraryId() == 0) {
			librarySetupView.initiateSetup();
		} else {
			librarySetupView.onSetupComplete();
		}
	}
    
    

}
