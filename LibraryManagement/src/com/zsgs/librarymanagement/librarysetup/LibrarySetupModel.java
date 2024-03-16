package com.zsgs.librarymanagement.librarysetup;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.model.Validation;

class LibrarySetupModel {
	private LibrarySetupView librarySetupView;
	private Library library;


	public LibrarySetupModel(LibrarySetupView librarySetupView) {
		this.librarySetupView = librarySetupView;
		library = LibraryDatabase.getInstance().getLibrary();

	}

	public void startSetup() {
		if (library == null || library.getLibraryId() == 0) {
			librarySetupView.initiateSetup();
		}
//		else {
//			librarySetupView.onSetupComplete();
//		}
	}

	public void setupLibrary(String libraryNaeme, String emailId, String address, long phoneNo, int libraryId) {
		if (new Validation().isEmailvalidator(emailId)  && String.valueOf(phoneNo).length()==10 && libraryId>0 ) {
			library = new Library();
			library.setLibraryName(libraryNaeme);
			library.setEmailId(emailId);
			library.setAddress(address);
			library.setLibraryId(libraryId);
			library.setPhoneNo(phoneNo);
			createLibrary(library);
		} else {
			librarySetupView.showAlert("Invalid library details");
			librarySetupView.initiateSetup();

		}
	}


	public void createLibrary(Library library2) {
//		boolean valid=true;
//		if(valid) {
		LibraryDatabase.getInstance().insertLibrary(library2);
		librarySetupView.onSetupComplete();
//		}else {
//			librarySetupView.showAlert("Invalid library details");
//		}
	}
}
    
    


