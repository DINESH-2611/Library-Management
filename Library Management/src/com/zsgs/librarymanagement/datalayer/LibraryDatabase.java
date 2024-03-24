package com.zsgs.librarymanagement.datalayer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zsgs.librarymanagement.model.*;

public class LibraryDatabase {
    private static LibraryDatabase libraryDatabase;
    private List<Library> libraryList=new ArrayList<>();
    private List<Book> bookList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private List<Credentials> credentialsList = new ArrayList<>();
    //    private Credentials adminCredential;
    List<IssueBookDetails> issueBookDetailsList = new ArrayList<>();

    public static LibraryDatabase getInstance() {
        if (libraryDatabase == null) {
            libraryDatabase = new LibraryDatabase();
        }
        return libraryDatabase;
    }

    public Library getLibrary() {
        if(libraryList.size()==0){
            return null;
        }else{
            return libraryList.get(0);
        }//sql query and its result
    }

    public Library insertLibrary(Library library2) {
       libraryList.add(library2);
       return library2;
    }

    public List<Book> getAllbook() {
        return bookList;
    }

    public Book getBook(String ISBN) {
        for (Book book : bookList) {
            if (book.getISBN().equals(ISBN)) {
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

    public void updateBookEdition(String ISBN, String edition) {
        getBook(ISBN).setEdition(edition);


    }

    public void updateBookVolume(String ISBN, int volume) {
        getBook(ISBN).setVolume(volume);
    }

    public void updateBookAvailableCount(String ISBN, int availableCount) {
        getBook(ISBN).setAvailableCount(availableCount);
    }

    public List<Book> viewBooks() {
        return bookList;
    }

    public void insertUserAccount(User user) {
        userList.add(user);
    }

    public User getUser(String userName) {
        for (User user : userList) {
            if (user.getUserName().equals(userName))
                return user;
        }
        return null;
    }

    public List<User> getAllUser() {
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
        Credentials credentials = new Credentials();
        credentials.setUserName("zsgs");
        credentials.setPassword("admin");
        credentials.setRole(0);
        credentialsList.add(credentials);
    }
//    public Credentials getCredentials(){
//        return adminCredential;
//    }

    public void insertIssuedBooks(IssueBookDetails issueBookDetails) {
//        System.out.println(issueBookDetailsList.size());
        issueBookDetailsList.add(issueBookDetails);
//        System.out.println(issueBookDetailsList.size());
//        System.out.println(111);
//        for(IssueBookDetails issueBookDetails1:issueBookDetailsList){
//            System.out.println(issueBookDetails1.getUserName()+"  "+issueBookDetails1.getBookList().get(0).getName());
//        }
    }

    public List<IssueBookDetails> getIssuedBookList() {
        return this.issueBookDetailsList;
    }

    public void removeIssuedBook(IssueBookDetails issueBookDetails) {
        this.issueBookDetailsList.remove(issueBookDetails);
    }
//    public void setCredentialsPassword(String password){
//        this.credentials.setPassword(password);
//    }

    public Credentials getCredentialsList(String userName) {
        for (Credentials credential : credentialsList) {
            if (credential.getUserName().equals(userName))
                return credential;
        }
        return null;
    }

   public IssueBookDetails getMyBookList(String userName){
//       System.out.println(issueBookDetailsList.size());
        for(IssueBookDetails issueBookDetails:issueBookDetailsList){
//            System.out.println(999);
            if(issueBookDetails.getUserName().equals(userName)){
//                System.out.println(888);
                return issueBookDetails;
            }
        }
//       System.out.println(777);
        return null;
   }

    public boolean passwordMatch(String userName, String password) {
        if(getPassword(userName)!=null){
            return getPassword(userName).equals(password);
        }return false;

    }

    private String getPassword(String userName) {
        for (Credentials credentials : credentialsList) {
            if (credentials.getUserName().equals(userName))
                return credentials.getPassword();
        }
        return null;
    }



    public void saveUsers() {
            Gson gson = new Gson();
            String jsonString = gson.toJson(userList);

            try (FileWriter writer = new FileWriter("D:\\Java\\User.json")) {
                writer.write(jsonString);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void saveBook() {
//        if (bookList.size() != 0) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(bookList);

            try (FileWriter writer = new FileWriter("D:\\Java\\Book.json")) {
                writer.write(jsonString);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }
    }

    public void saveIssueBook() {
//        if (issueBookDetails.size() != 0) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(issueBookDetailsList);
            for(IssueBookDetails issueBookDetails1:issueBookDetailsList){
                issueBookDetails1.getUserName();
            }

            try (FileWriter writer = new FileWriter("D:\\Java\\IssuedBooks.json")) {
                writer.write(jsonString);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }
    }

    public void saveCredentials() {
//        if (credentialsList.size() != 0) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(credentialsList);

            try (FileWriter writer = new FileWriter("D:\\Java\\Credentials.json")) {
                writer.write(jsonString);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }
    }
    public void saveLibrary() {
//        if (credentialsList.size() != 0) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(libraryList);

        try (FileWriter writer = new FileWriter("D:\\Java\\Library.json")) {
            writer.write(jsonString);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        }
    }

//    public void saveAll() {
//        saveUsers();
//        saveBook();
//        saveIssueBook();
//        saveCredentials();
//
//    }

    public boolean isUSer(String userName) {
        for (Credentials credentials : credentialsList) {
            if (credentials.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public int getRole(String userName) {
        for (Credentials credentials : credentialsList) {
            if (credentials.getUserName().equals(userName)) {
                return credentials.getRole();
            }
        }
        return 0;
    }

    public void changePassWord(String userName, String password) {
        for (Credentials credentials : credentialsList) {
            if (credentials.getUserName().equals(userName)) {
                credentials.setPassword(password);
            }
        }
    }

    private List<User> loadUsers()  {
        Gson gson = new Gson();
        List<User> loadedList = new ArrayList<>();
       try {
           File file=new File("D:\\Java\\User.json");
           if(!file.exists()){
               file.createNewFile();
           }
       }catch (IOException e){
           e.printStackTrace();
       }


        try (
                FileReader reader = new FileReader("D:\\Java\\User.json")) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }

            String jsonString = sb.toString();
            if (jsonString.isEmpty()) {
                return loadedList;
            }

            Type type = new TypeToken<List<User>>() {
            }.getType();
            loadedList = gson.fromJson(jsonString, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedList;


    }
    private static List<Book> loadBooks() {
        Gson gson = new Gson();
        List<Book> loadedList = new ArrayList<>();
        try {
            File file=new File("D:\\Java\\Book.json");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("D:\\Java\\Book.json")) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }

            String jsonString = sb.toString();
            if (jsonString.isEmpty()) {
                return loadedList;
            }

            Type type = new TypeToken<List<Book>>() {}.getType();
            loadedList = gson.fromJson(jsonString, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedList;


    }
    private static List<Credentials> loadCredentials() {
        Gson gson = new Gson();
        List<Credentials> loadedList = new ArrayList<>();
        try {
            File file=new File("D:\\Java\\Credentials.json");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("D:\\Java\\Credentials.json")) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }

            String jsonString = sb.toString();
            if (jsonString.isEmpty()) {
                return loadedList;
            }

            Type type = new TypeToken<List<Credentials>>() {}.getType();
            loadedList = gson.fromJson(jsonString, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedList;


    }
    private static List<IssueBookDetails> loadIssueBooks() {
        Gson gson = new Gson();
        List<IssueBookDetails> loadedList = new ArrayList<>();
        try {
            File file=new File("D:\\Java\\IssuedBooks.json");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("D:\\Java\\IssuedBooks.json")) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }

            String jsonString = sb.toString();
            if (jsonString.isEmpty()) {
                return loadedList;
            }

            Type type = new TypeToken<List<IssueBookDetails>>() {}.getType();
            loadedList = gson.fromJson(jsonString, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedList;


    }
    private static List<Library> loadLibrary() {
        Gson gson = new Gson();
        List<Library> loadedList = new ArrayList<>();
        try {
            File file=new File("D:\\Java\\Library.json");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("D:\\Java\\Library.json")) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }

            String jsonString = sb.toString();
            if (jsonString.isEmpty()) {
                return loadedList;
            }

            Type type = new TypeToken<List<Library>>() {}.getType();
            loadedList = gson.fromJson(jsonString, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedList;


    }




    public void libraryFromFile() {
        this.libraryList=loadLibrary();
    }

    public void bookFromFile() {
        this.bookList=loadBooks();
    }

    public void userFromFile() {
        this.userList=loadUsers();
    }

    public void isuueBookFromFile() {
        this.issueBookDetailsList=loadIssueBooks();
    }

    public void credentialsFromFile() {
        this.credentialsList=loadCredentials();
    }

    public void saveAll() {
        saveIssueBook();
        saveBook();
        saveCredentials();
        saveUsers();
        saveLibrary();
    }

    public void getAllData() {
        isuueBookFromFile();
        bookFromFile();
        userFromFile();
        libraryFromFile();
    }

    public IssueBookDetails getMyBookDetails(String userName) {
//        System.out.println(issueBookDetailsList.size());
        for(IssueBookDetails issueBookDetails1:issueBookDetailsList){
            if(issueBookDetails1.getUserName().equals(userName)){
                return issueBookDetails1;
            }
        }return null;
    }
}
