package com.zsgs.librarymanagement.managebook;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Library;

import java.util.List;

public class ManageBookModel {
    private ManageBookView manageBookview;

    //	private Book book;
    public ManageBookModel(ManageBookView manageBookView) {
        this.manageBookview = manageBookView;
//        Library library = LibraryDatabase.getInstance().getLibrary();
//        manageBookview.showLibraryName(library.getLibraryName());

    }

    private void createBook(Book book) {
        LibraryDatabase.getInstance().insertBook(book);
        manageBookview.showAlert("Book added successfully");

    }

    public void setupBook(String bookName, String author, String publication, String edition, String journal,
                          long bookId, int availableCount, int volume) {
        if (LibraryDatabase.getInstance().getBook(bookId) == null) {
            Book book = new Book();
            book.setAuthor(author);
            book.setAvailableCount(availableCount);
            book.setEdition(edition);
            book.setId(bookId);
            book.setJournal(journal);
            book.setName(bookName.toUpperCase());
            book.setPublication(publication);
            book.setVolume(volume);
            createBook(book);
        } else {
            manageBookview.showAlert("Book id already exist");
            manageBookview.addBook();
        }
//		for(Book book:LibraryDatabase.getInstance().getAllbook()) {
//			if(book.getId()==bookId) {
//				manageBookview.showAlert("Book id already exist");
//			}
//		}

    }

    public void findBook(String bookName) {
        List<Book> bookList = LibraryDatabase.getInstance().searchBook(bookName);
        if (bookList.size() == 0) {
            manageBookview.showAlert("No book exist");
        } else {

            manageBookview.showBook(bookList);
        }


    }


    public void updateBookEdition(long bookId, String edition) {
        if (LibraryDatabase.getInstance().getBook(bookId) == null) {
            manageBookview.showAlert("Book Id not exist");
            manageBookview.updateBook();
        } else {
            LibraryDatabase.getInstance().updateBookEdition(bookId, edition);
            manageBookview.showAlert("Book edition updated successfiully");
        }
    }

    public void updateBookVolume(long bookId, int volume) {
        if (LibraryDatabase.getInstance().getBook(bookId) == null) {
            manageBookview.showAlert("Book Id not exist");
            manageBookview.updateBook();
        } else {
            LibraryDatabase.getInstance().updateBookVolume(bookId, volume);
            manageBookview.showAlert("Book volume updated successfiully");
        }
    }

    public void updateBookAvailableCount(long bookId, int availableCount) {
        if (LibraryDatabase.getInstance().getBook(bookId) == null) {
            manageBookview.showAlert("Book Id not exist");
            manageBookview.updateBook();
        } else {
            LibraryDatabase.getInstance().updateBookAvailableCount(bookId, availableCount);
            manageBookview.showAlert("Book available count updated successfiully");

        }
    }

    public void viewBook() {
        List<Book> bookList = LibraryDatabase.getInstance().viewBooks();
        if (bookList.size() == 0) {
            manageBookview.showAlert("No book exist");

        } else {
            manageBookview.showBook(bookList);
        }
    }
}
