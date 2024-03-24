package com.zsgs.librarymanagement.manageuseraccount;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.zsgs.librarymanagement.LibraryManagement;
import com.zsgs.librarymanagement.assignbook.AssignBookView;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.login.LoginView;
import com.zsgs.librarymanagement.managebook.ManageBookView;
import com.zsgs.librarymanagement.manageuser.ManageUserView;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.IssueBookDetails;
import com.zsgs.librarymanagement.model.User;

public class ManageUserAccountView {
    Scanner scanner = new Scanner(System.in);
    private ManageUserAccountModel manageUserAccountModel;

    public ManageUserAccountView() {
        this.manageUserAccountModel = new ManageUserAccountModel(this);
    }

    public void init(String userName) {
        ManageBookView manageBookView = new ManageBookView();
        AssignBookView assignBookView = new AssignBookView();
        try {
            while (true) {
                manageUserAccountModel.IssueBookUserBookFile();
                System.out.println(
                        "1.View User\n2.Search Books\n3.View Books\n4.Get Book\n5.Return Book\n6.View My Book List\n7.Logout\nEnter the choice");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        viewUser(userName);
                        break;
                    case 2:
                        manageBookView.searchBook();
                        break;
                    case 3:
                        manageBookView.viewBook();
                        break;
                    case 4:
                        System.out.println(LibraryDatabase.getInstance().getIssuedBookList().size());
                        for(IssueBookDetails issueBookDetails1:LibraryDatabase.getInstance().getIssuedBookList()) {
                            System.out.println(issueBookDetails1.getUserName());
                        }assignBookView.issueBook(userName);
                        break;
                    case 5:
                        assignBookView.returnBook(userName);
                        break;
                    case 6:
                    	manageUserAccountModel.viewBooks(userName);
                        break;
                    case 7:
                        manageUserAccountModel.saveIssueBooksUserBooks();
                        new LoginView().init();
                        return;
                    default:
                        showAlert("Invalid choice,Enter valid choice");
                        init(userName);
                }
            }
        } catch (InputMismatchException e) {
            showAlert("Input mismatch,Enter valid choice");
        }
    }

//    private void viewMyBooks(String userName) {
//        manageUserAccountModel.viewBooks(userName);
//
//    }

    private void viewUser(String userName) {
        User user = LibraryDatabase.getInstance().getUser(userName);
        System.out.printf("%-15s %-25s %-15s %-15s %-15s %-15s", "User Name", "Email id", "Phone No", "Address",
                "Membership","Book count");
        System.out.println();
        System.out.printf("%-15s %-25s %-15s %-15s %-15s %-15s", user.getUserName(), user.getEmailId(), user.getPhoneNo(),
                user.getAddress(), user.isMembership(),user.getBookCount());
        System.out.println();

    }

    void showAlert(String alert) {
        System.out.println(alert);

    }

    public void showBook(IssueBookDetails issueBookDetails) {
    	int n=1;
        System.out.printf("%-20s %-15s", "User Email ID", "Book List");
        System.out.println();
        for(Book book:issueBookDetails.getBookList()) {
        	System.out.printf("%-20s %-15s",issueBookDetails.getUserName(),n+++"."+book.getName()+"\n");
        }
           
        }

    }


