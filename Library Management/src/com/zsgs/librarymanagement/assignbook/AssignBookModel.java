package com.zsgs.librarymanagement.assignbook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.IssueBookDetails;
import com.zsgs.librarymanagement.model.User;

class AssignBookModel {
	private AssignBookView assignBookView;

	public AssignBookModel(AssignBookView assignBookView) {
		this.assignBookView = assignBookView;
	}

	public void isUserExist(String userName) {
		User user = LibraryDatabase.getInstance().getUser(userName);

		if (user.getBookCount() < 3) {
			assignBookView.wantBook(userName);
		} else {
			assignBookView.showAlert("You have reached the limit,Return the book first then you can get a book");
			assignBookView.checkReturn(userName);
		}
	}

	public void isBookExist(String userName, String bookName) {
		List<Book> bookList = LibraryDatabase.getInstance().searchBook(bookName.toUpperCase());
		if (bookList.size() == 0) {
			assignBookView.showAlert("Book doesn't exist now");
			assignBookView.checkAgain(userName);
		} else {
			for (Book book : bookList) {
				if (bookName.toUpperCase().equalsIgnoreCase(book.getName()) && book.getAvailableCount() > 0) {
					book.setAvailableCount(book.getAvailableCount() - 1);
					assignBook(userName, book);
				} else {
					assignBookView.showAlert("Book doesn't exist now");
					assignBookView.checkAgain(userName);
				}

			}

		}

	}
	private IssueBookDetails issueBookDetails = null;
	private void assignBook(String userName, Book book) {

		List<IssueBookDetails> issueBookList=LibraryDatabase.getInstance().getIssuedBookList();
		for(IssueBookDetails issueBookDetails1:issueBookList){
			if(issueBookDetails1.getUserName().equals(userName)){
				issueBookDetails=issueBookDetails1;
			}
		}
		if (issueBookDetails == null) {
			IssueBookDetails issueBookDetails1 = new IssueBookDetails();
			issueBookDetails1.getBookList().add(book);
			issueBookDetails1.setUserName(userName);
			LibraryDatabase.getInstance().insertIssuedBooks(issueBookDetails1);
		} else {
			issueBookDetails.getBookList().add(book);
		}

		User user = LibraryDatabase.getInstance().getUser(userName);
		LibraryDatabase.getInstance().getUser(userName).setBookCount(user.getBookCount() + 1);
		assignBookView.showAlert("Book issued succesfully");

	}

	public void viewIssuedBooks() {
		List<IssueBookDetails> issueBookDetails = LibraryDatabase.getInstance().getIssuedBookList();
		if (issueBookDetails.size() == 0)
			assignBookView.showAlert("No books issued yet");
		else {
			assignBookView.showIssuedBokk(issueBookDetails);
		}

	}

	public void returnBook(String userName, String bookName) {
		if(LibraryDatabase.getInstance().getUser(userName).getBookCount()==0) {
			assignBookView.showAlert("This user is yet to get the book");
			assignBookView.checkReturn(userName);
			return;
		}
		boolean ok = false;
		List<Book> bookList = LibraryDatabase.getInstance().searchBook(bookName.toUpperCase());
		Book book = null;
		for (Book book1 : bookList) {
			if (book1.getName().equalsIgnoreCase(bookName.toUpperCase())) {
				book = book1;
			}
		}
		if (book == null) {
			assignBookView.showAlert("Book not exist in isuued book list");
			assignBookView.checkReturn(userName);
			return;
		}
		if (issueBookDetails != null) {
			List<Book> books = issueBookDetails.getBookList();
			for (Book book2 : books) {
				if (book2.getISBN().equals(book.getISBN())) {
					book.setAvailableCount(book.getAvailableCount() + 1);
					User user = LibraryDatabase.getInstance().getUser(issueBookDetails.getUserName());
					LibraryDatabase.getInstance().getUser(issueBookDetails.getUserName())
							.setBookCount(user.getBookCount() - 1);
					if (user.getBookCount() == 0) {
						LibraryDatabase.getInstance().removeIssuedBook(issueBookDetails);
					}
					assignBookView.showAlert("Book returned successfully");
					ok = true;
					break;
				}
			}
		}
		if (issueBookDetails != null) {
			issueBookDetails.getBookList().remove(book);
		}
		if(!ok) {
			assignBookView.showAlert("Book name does not match");
			assignBookView.checkReturn(userName);
		}
	}
}
