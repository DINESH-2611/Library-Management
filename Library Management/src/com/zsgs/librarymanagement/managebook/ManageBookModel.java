package com.zsgs.librarymanagement.managebook;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Library;

import java.util.List;

class ManageBookModel {
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
                          String ISBN, int availableCount, int volume) {
        if (LibraryDatabase.getInstance().getBook(ISBN) == null) {
            Book book = new Book();
            book.setAuthor(author);
            book.setAvailableCount(availableCount);
            book.setEdition(edition);
            book.setISBN(ISBN);
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


    public void updateBookEdition(String ISBN, String edition) {
        if (LibraryDatabase.getInstance().getBook(ISBN) == null) {
            manageBookview.showAlert("Book Id not exist");
            manageBookview.updateBook();
        } else {
            LibraryDatabase.getInstance().updateBookEdition(ISBN, edition);
            manageBookview.showAlert("Book edition updated successfiully");
        }
    }

    public void updateBookVolume(String ISBN, int volume) {
        if (LibraryDatabase.getInstance().getBook(ISBN) == null) {
            manageBookview.showAlert("Book Id not exist");
            manageBookview.updateBook();
        } else {
            LibraryDatabase.getInstance().updateBookVolume(ISBN, volume);
            manageBookview.showAlert("Book volume updated successfiully");
        }
    }

    public void updateBookAvailableCount(String ISBN, int availableCount) {
        if (LibraryDatabase.getInstance().getBook(ISBN) == null) {
            manageBookview.showAlert("Book Id not exist");
            manageBookview.updateBook();
        } else {
            LibraryDatabase.getInstance().updateBookAvailableCount(ISBN, availableCount);
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

    public void saveBook() {
        LibraryDatabase.getInstance().saveBook();
    }

//    public void removeBook(String ISBN) {
//        if(LibraryDatabase.getInstance().getBook(ISBN)==null){
//            manageBookview.showAlert("No book exist");
//        }else{
//            if(!(LibraryDatabase.getInstance().getBook(ISBN).getAvailableCount()==0)){
//                int count=LibraryDatabase.getInstance().getBook(ISBN).getAvailableCount();
//                LibraryDatabase.getInstance().getBook(ISBN).setAvailableCount(count-1);
//                manageBookview.showAlert("Book removed succesfully");
//            }
//        }
//    }
}
