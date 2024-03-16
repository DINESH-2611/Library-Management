package com.zsgs.librarymanagement.managebook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageBookView {
	private Scanner scanner=new Scanner(System.in);
	private ManageBookModel manageBookModel;
	public ManageBookView() {
		manageBookModel=new ManageBookModel(this);
	}
	
	public void init() {
		while(true) {
			System.out.println("1.Add Book\n2.Search Book\n3.Update Book\n4.View Book\n0.Exit\nEnter the choice");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:{
				addBook();
				break;
			} 
			case 2:{
				searchBook();
				break;
			} 
			case 3:{
				updateBook();
				break;
			} 
			case 4:{
				viewBook();
				break;
			} 
			default:
				System.out.println("Invalid choice");
			}
			
		}
	}
	

	private void updateBook() {
		// TODO Auto-generated method stub
		
	}

	private void viewBook() {
		System.out.println("Enter ");
		
	}

	private void searchBook() {
		// TODO Auto-generated method stub
		
	}

	public void addBook() {
		System.out.println("Enter book name");
		String bookName=scanner.next();
		System.out.println("Enter author name");
		String author=scanner.next();
		System.out.println("Enter publication");
		String publication=scanner.next();
		System.out.println("Enter edition");
		String edition=scanner.next();
		System.out.println("Enter journal");
		String journal=scanner.next();
		long bookId=0;
		try {
			 bookId=scanner.nextLong();
		} catch (InputMismatchException e) {
			System.out.println("Invalid phone number,Enter valid ph no");
			addBook();
		}
		System.out.println("Enter book available count");
		int availableCount=0;
		try {
			 availableCount=scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid available count,Enter valid available count");
			addBook();
		}
		System.out.println("Enter book volume");
		int volume=0;
		try {
			 volume=scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid book volume,Enter valid available count");
			addBook();
		}
		manageBookModel.setupBook(bookName,author,publication,edition,journal,bookId,availableCount,volume);
		
	}

	public void showLibraryName(String libraryName) {
		System.out.println("Current Library Name-"+libraryName);
	}

	public void showAlert(String alert) {
		System.out.println(alert);
	}

}
