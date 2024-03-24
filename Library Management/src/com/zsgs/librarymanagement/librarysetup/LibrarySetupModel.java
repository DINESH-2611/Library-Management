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

	public void startSetup(String userName) {
		if (library == null || library.getLibraryId()==null) {
			librarySetupView.initiateSetup(userName);
		}else{
			librarySetupView.onSetupComplete(library,userName);
		}
	}


	public void setupLibrary(String libraryName, String emailId, String address, long phoneNo, String userName) {
		Validation validation=new Validation();
		if (validation.isEmailvalidator(emailId)  && String.valueOf(phoneNo).length()==10 && validation.nameChecker(libraryName)) {
			library = new Library();
			library.setLibraryName(libraryName);
			library.setEmailId(emailId);
			library.setAddress(address);
			library.setLibraryId(libraryName.substring(0,3)+generateId());
			library.setPhoneNo(phoneNo);
			createLibrary(library,userName);
		} else {
			librarySetupView.showAlert("Invalid library details");
			librarySetupView.initiateSetup(userName);

		}
	}


	public void createLibrary(Library library2, String userName) {
		this.library=LibraryDatabase.getInstance().insertLibrary(library2);
		librarySetupView.onSetupComplete(library, userName);
	}
	private int generateId(){
		return (int)(Math.random()*999+999);
	}

    public void bookFile() {
		LibraryDatabase.getInstance().bookFromFile();
    }

	public void userFile() {
		LibraryDatabase.getInstance().userFromFile();
	}

	public void saveLibrary() {
		LibraryDatabase.getInstance().saveLibrary();
	}

	public void IssueBookFile() {
		LibraryDatabase.getInstance().isuueBookFromFile();
	}
}
    
    


