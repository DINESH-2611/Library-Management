package com.zsgs.librarymanagement.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.zsgs.librarymanagement.model.*;

public class LibraryDatabase {
    private static LibraryDatabase libraryDatabase;
    private Library library;
    private List<Book> bookList = new ArrayList<>();
    private  List<User> userList=new ArrayList<>();
    private List<Credentials> credentialsList=new ArrayList<>();
    private Credentials credentials;
    List<IssueBookDetails> issueBookDetails=new ArrayList<>();

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

    public User getUser(String userName){
        for(User user:userList){
            if(user.getUserName().equals(userName))
                return user;
        }return null;
    }
    public List<User> getAllUser(){
        return userList;
    }

    public void addCredentials(Credentials credentials) {
        credentialsList.add(credentials);
    }

    public void updateUserPhoneNo(String emailId, long phoneNo) {
        getUser(emailId).setPhoneNo(phoneNo);
    }

    public void updateUserAdress(String emailId, String adress) {
        getUser(emailId).setAddress(adress);
    }

    public void updateUserMembership(String emailId, boolean memebership) {
        getUser(emailId).setMembership(memebership);
    }
    public void createCredentials() {
        Credentials credentials=new Credentials();
        credentials.setUserName("zsgs");
        credentials.setPassword("admin");
        this.credentials=credentials;
    }
    public Credentials getCredentials(){
        return credentials;
    }

    public void insertIssuedBooks(IssueBookDetails issueBookDetails) {
        this.issueBookDetails.add(issueBookDetails);
    }

    public List<IssueBookDetails> getIssuedBookList() {
        return this.issueBookDetails;
    }

    public void removeIssuedBook(IssueBookDetails issueBookDetails) {
        this.issueBookDetails.remove(issueBookDetails);
    }
//    public void setCredentialsPassword(String password){
//        this.credentials.setPassword(password);
//    }

	public Credentials getCredentialsList(String userName) {
		for(Credentials credential:credentialsList) {
			if(credential.getUserName().equals(userName))
				return credential;
		}
		return null;
	}

	public IssueBookDetails getMyBookList(String userName) {
//		List<IssueBookDetails> myBookList=new ArrayList<IssueBookDetails>();
		for(IssueBookDetails issueBookDetails2:issueBookDetails) {
			if(issueBookDetails2.getUserName().equals(userName)) {
				return issueBookDetails2;
			}
		}
		return null;
		
		
	}

	public boolean isUser(String userName, String password) {
		for(Credentials credentials:credentialsList) {
			if(credentials.getUserName().equals(userName) && credentials.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

}
