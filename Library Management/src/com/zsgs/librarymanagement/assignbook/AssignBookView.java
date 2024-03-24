package com.zsgs.librarymanagement.assignbook;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.zsgs.librarymanagement.managebook.ManageBookView;
import com.zsgs.librarymanagement.manageuser.ManageUserView;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.IssueBookDetails;
import com.zsgs.librarymanagement.model.User;

public class AssignBookView {
    Scanner scanner=new Scanner(System.in);
    private AssignBookModel assignBookModel;
    public AssignBookView(){
        this.assignBookModel=new AssignBookModel(this);
    }
    public void init(){
    	try {
			while(true) {
				System.out.println("1.View all Books\n2.View Issued books\n3.Return to previous page\nEnter the choice");
				int choice=scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
				case 1: {
					new ManageBookView().viewBook();
					break;
				}
				case 2: {
					viewIssuedBookList();
					break;
				}
				case 3: {
					return;				}
				default:
					showAlert("Invalid choice,Enter valid choice");
					init();
				}
			}
		} catch (InputMismatchException e) {
			showAlert("Input mismatch,Enter valid choice");
			init();
		}

    }
    public void returnIssuedBook() {
    	scanner.nextLine();
		System.out.println("Enter user name");
		String userName=scanner.nextLine();
		returnBook(userName);
		
	}
	public void issueBook(String userName) {
        assignBookModel.isUserExist(userName);
		
	}
	public void wantBook(String userName) {
        System.out.println("Enter book name");
        String bookName=scanner.nextLine();
        assignBookModel.isBookExist(userName,bookName);

    }
    public void showAlert(String alert) {
        System.out.println(alert);

    }
    public void checkAgain(String userName) {
        System.out.println("Do you want to get another book\nYes\nNo");
        String choice=scanner.nextLine();
        if(choice.equalsIgnoreCase("yes"))
            wantBook(userName);
        else if(choice.equalsIgnoreCase("no"))
            return;
        else {
            System.out.println("Invalid choice,Enter valid choice");
            checkAgain(userName);
        }

    }
    public void viewIssuedBookList() {
        assignBookModel.viewIssuedBooks();


    }
    public void createUserAccount() {
        System.out.println("Do you want to create new Account\nYes\nNo");
        String choice=scanner.nextLine();
        if(choice.equalsIgnoreCase("yes")) {
            new ManageUserView().initAdd();
//            issueBook();
        }
        else if(choice.equalsIgnoreCase("no"))
//            issueBook();
        	return;
        else {
            System.out.println("Invalid choice,Enter valid choice");
            createUserAccount();
        }
    }
    public void showIssuedBokk(List<IssueBookDetails> issueBookDetails) {
    	int n=1;
        System.out.printf("%-20s %-15s","User Name","Book Name");
        System.out.println();
        for (IssueBookDetails issueBookDetails1:issueBookDetails){
        	for(Book book:issueBookDetails1.getBookList()) {
            System.out.printf("%-20s %-15s",issueBookDetails1.getUserName(),n+++"."+book.getName()+"\n");
            System.out.println();
        	}
        	n=1;
        }

    }

    public void checkReturn(String userName) {
        System.out.println("Do you want to return the book\nYes\nNo");
        String choice=scanner.nextLine();
        if(choice.equalsIgnoreCase("yes"))
            returnBook(userName);
        else if(choice.equalsIgnoreCase("no"))
            return;
        else{
            showAlert("Invalid choice,Enter valid choice");
            checkAgain(userName);
        }

    }

    public void returnBook(String userName) {
        System.out.println("Enter book name");
        String bookName=scanner.nextLine();
        assignBookModel.returnBook(userName,bookName);
    }
}
