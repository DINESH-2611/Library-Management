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
//		if (user != null) {
//			System.out.println("hhhhhhhhhhhh");

		if (user.getBookCount() < 3) {
			assignBookView.wantBook(userName);
		} else {
			assignBookView.showAlert("You have reached the limit,Return the book first then you can get a book");
			assignBookView.checkReturn(userName);
		}
	}

//		else {
//			assignBookView.showAlert("User not found,Please check the emaillId or create user acoount first");
//			assignBookView.createUserAccount();
//		}

	public void isBookExist(String userName, String bookName) {
		List<Book> bookList = LibraryDatabase.getInstance().searchBook(bookName.toUpperCase());
//		System.out.println(bookList.get(0));
		if (bookList.size() == 0) {
			assignBookView.showAlert("Book doesn't exist now");
//			System.out.println(123);
			assignBookView.checkAgain(userName);
		} else {
			for (Book book : bookList) {
//				System.out.println(book.getName());
				if (bookName.toUpperCase().equalsIgnoreCase(book.getName()) && book.getAvailableCount() > 0) {
					book.setAvailableCount(book.getAvailableCount() - 1);
					assignBook(userName, book);
//					System.out.println(000);
				} else {
					assignBookView.showAlert("Book doesn't exist now");
					assignBookView.checkAgain(userName);
//					System.out.println(777);
				}

			}

		}

	}

	private void assignBook(String userName, Book book) {
		IssueBookDetails issueBookDetails = LibraryDatabase.getInstance().getMyBookList(userName);
//		System.out.println(12);
		if (issueBookDetails == null) {
			issueBookDetails = new IssueBookDetails();
			issueBookDetails.getBookList().add(book);
			issueBookDetails.setUserName(userName);
//			System.out.println(666);
			LibraryDatabase.getInstance().insertIssuedBooks(issueBookDetails);
		} else {
//			System.out.println(222);
			issueBookDetails.getBookList().add(book);
//			LibraryDatabase.getInstance().insertIssuedBooks(issueBookDetails);
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
//		List<IssueBookDetails> issueBookDetailsList = LibraryDatabase.getInstance().getIssuedBookList();
		IssueBookDetails issueBookDetails = LibraryDatabase.getInstance().getMyBookList(userName);
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
//				return;
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

//	public void returnBook(String emailId, String bookName) {
//		// TODO Auto-generated method stub
//		
//	}
}
