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
	public void setupBook(String bookName, String author, String publication, String edition, String journal,
			long bookId, int availableCount, int volume) {
		if(LibraryDatabase.getInstance().getBook(bookId)==null) {
			Book book=new Book();
			book.setAuthor(author);
			book.setAvailableCount(availableCount);
			book.setEdition(edition);
			book.setId(bookId);
			book.setJournal(journal);
			book.setName(bookName);
			book.setPublication(publication);
			book.setVolume(volume);
			createBook(book);
		}else {
			manageBookview.showAlert("Book id already exist");
			manageBookview.addBook();
		}
//		for(Book book:LibraryDatabase.getInstance().getAllbook()) {
//			if(book.getId()==bookId) {
//				manageBookview.showAlert("Book id already exist");
//			}
//		}
		
	}
	private void createBook(Book book) {
		LibraryDatabase.getInstance().insertBook(book);
		manageBookview.showAlert("Book added successfully");
		
	}
	
	
	

}
