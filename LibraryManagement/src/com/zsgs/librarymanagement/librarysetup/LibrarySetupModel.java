package com.zsgs.librarymanagement.librarysetup;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Library;

class LibrarySetupModel {

	private LibrarySetupView librarySetupView;
	private Library library;

   
	public LibrarySetupModel(LibrarySetupView librarySetupView) {
		 this.librarySetupView=librarySetupView;
		 library=LibraryDatabase.getInstance().getLibrary();
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
	public void setupLibrary(int libraryId){
		library=new Library();
		library.setLibraryId(libraryId);
		startSetup();
	}


	public void createLibrary(Library library2) {
		boolean valid=true;
		if(valid) {
			LibraryDatabase.getInstance().insertLibrary(library2);
			librarySetupView.onSetupComplete();
		}else {
			librarySetupView.showAlert("Invalid library details");
		}
		}
	}

