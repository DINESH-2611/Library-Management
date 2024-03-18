package com.zsgs.librarymanagement.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Credentials;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.model.User;

public class LibraryDatabase {
    private static LibraryDatabase libraryDatabase;
    private Library library;
    private List<Book> bookList = new ArrayList<>();
    private  List<User> userList=new ArrayList<>();
    private List<Credentials> credentialsList=new ArrayList<>();

    public static LibraryDatabase getInstance() {
        if (libraryDatabase == null) {
            libraryDatabase = new LibraryDatabase();
        }
        return libraryDatabase;
    }

    public Library getLibrary() {
        return library;//sql query and its result
    }

    public Library insertLibrary(Library library2) {
        this.library = library2;//insert sql query here
        return library;
    }

    public List<Book> getAllbook() {
        return bookList;
    }

    public Book getBook(long bookId) {
        for (Book book : bookList) {
            if (book.getId() == bookId) {
                return book;
            }
        }//select query with condition
        return null;
    }

    public void insertBook(Book book) {
        bookList.add(book);
    }

    public List<Book> searchBook(String bookName) {
        List<Book> searchResult = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getName().contains(bookName)) {
                searchResult.add(book);
            }
        }
        return searchResult;//query
    }

    public void updateBookEdition(long bookId, String edition) {
        getBook(bookId).setEdition(edition);


    }

    public void updateBookVolume(long bookId, int volume) {
        getBook(bookId).setVolume(volume);
    }

    public void updateBookAvailableCount(long bookId, int availableCount) {
        getBook(bookId).setAvailableCount(availableCount);
    }

    public List<Book> viewBooks() {
        return bookList;
    }

    public void insertUserAccount(User user) {
        userList.add(user);
    }

    public void addCredentials(Credentials credentials) {
        credentialsList.add(credentials);
    }
}
