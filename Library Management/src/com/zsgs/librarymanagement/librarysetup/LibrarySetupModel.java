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
		}else{
			librarySetupView.onSetupComplete(library);
		}
	}


	public void setupLibrary(String libraryName, String emailId, String address, long phoneNo, int libraryId) {
		Validation validation=new Validation();
		if (validation.isEmailvalidator(emailId)  && String.valueOf(phoneNo).length()==10 && validation.nameChecker(libraryName)) {
			library = new Library();
			library.setLibraryName(libraryName);
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
		this.library=LibraryDatabase.getInstance().insertLibrary(library2);
		librarySetupView.onSetupComplete(library);
	}
}
    
    


