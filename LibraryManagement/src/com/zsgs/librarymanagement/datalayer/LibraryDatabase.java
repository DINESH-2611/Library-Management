package com.zsgs.librarymanagement.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Library;

public class LibraryDatabase {
	 private static LibraryDatabase libraryDatabase;
	    private Library library;
	    private List<Book> bookList=new ArrayList<>();
	    public static LibraryDatabase getInstance() {
	        if (libraryDatabase == null) {
	            libraryDatabase = new LibraryDatabase();
	        }
	        return libraryDatabase;
	    }
	    public Library getLibrary(){
	        return library;//sql query and its result
	    }

	    public void insertLibrary(Library library2) {
	        this.library=library2;//insert sql query here
	    }
	    public List<Book> getAllbook(){
	        return bookList;
	    }
	    public Book getBook(long bookId){
	        for(Book book:bookList){
	            if(book.getId()==bookId){
	                return book;
	            }
	        }//select query with condition
	        return null;
	    }
	    public  void insertBook(Book book){
	        bookList.add(book);
	    }
	    public List<Book> searchBook(String bookName){
	        List<Book> searchResult=new ArrayList<>();
	        for(Book book:bookList){
	            if(book.getName().contains(bookName)){
	                searchResult.add(book);
	            }
	        }
	        return searchResult;//query
	    }

}
