package com.zsgs.librarymanagement.managebook;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Library;

public class ManageBookModel {
	private ManageBookView manageBookview;
//	private Book book;
	public ManageBookModel(ManageBookView manageBookView) {
		this.manageBookview=manageBookView;
		Library library= LibraryDatabase.getInstance().getLibrary();
		manageBookview.showLibraryName(library.getLibraryName());
		
	}
	
	
	

}
