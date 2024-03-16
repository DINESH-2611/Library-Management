package com.zsgs.librarymanagement.managebook;

import com.zsgs.librarymanagement.CustomerAccountCreation.CustomerAccountCreationView;
import com.zsgs.librarymanagement.model.Book;

import java.util.InputMismatchException;
import java.util.List;
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
			if(choice==0)
				break;
			
		}
		CustomerAccountCreationView.init();
	}
	

	public void updateBook() {
		System.out.println("1.Update edition\n2.Update volume\n3.Update available count\nEnter the choice");
		int choice=scanner.nextInt();
//		scanner.nextLine();
		switch (choice){
			case 1:{
				updateEditon();
				break;
			}
			case 2:{
				updateVolume();
				break;
			}
			case 3:{
				updateAvailableCount();
				break;
			}
			default:{
				System.out.println("Invalid choice");
			}
		}
		
	}

	private void updateAvailableCount() {
		System.out.println("Enter Book id to update");
		long bookId=scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter the available count");
		int availableCount=scanner.nextInt();
		manageBookModel.updateBookAvailableCount(bookId,availableCount);
	}

	private void updateVolume() {
		System.out.println("Enter Book id to update");
		long bookId=scanner.nextLong();
//		scanner.nextLine();
		System.out.println("Enter the volume");
		int volume=scanner.nextInt();
		manageBookModel.updateBookVolume(bookId,volume);
	}

	private void updateEditon(){
		System.out.println("Enter Book id to update");
		long bookId=scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter the edition");
		String edition=scanner.nextLine();
		manageBookModel.updateBookEdition(bookId,edition);
		}


	private void viewBook() {
		manageBookModel.viewBook();
		
	}

	private void searchBook() {
		scanner.nextLine();
		System.out.println("Enter book name");
		String bookName=scanner.nextLine();
		manageBookModel.findBook(bookName);
	}
	public void showBook(List<Book> bookList){
		System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s","Book Id","Book name","Author","Publication","Edition","Avialable Count","Journal","Volume");
		System.out.println();
		for(Book book:bookList){
			System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s",book.getId(),book.getName(),book.getAuthor(),book.getPublication(),book.getEdition(),book.getAvailableCount(),book.getJournal(),book.getVolume());
			System.out.println();
		}
	}

	public void addBook() {
		System.out.println("Enter book name");
		String bookName=scanner.next();
		System.out.println("Enter author name");
		String author=scanner.next();
		System.out.println("Enter publication");
		String publication=scanner.next();
		System.out.println("Enter edition");
		scanner.nextLine();
		String edition=scanner.next();
		scanner.nextLine();
		System.out.println("Enter journal");
		String journal=scanner.next();
		System.out.println("Enter book id");
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
//		System.out.println("No");
		scanner.nextLine();
		manageBookModel.setupBook(bookName,author,publication,edition,journal,bookId,availableCount,volume);
		
	}

	public void showLibraryName(String libraryName) {
		System.out.println("Current Library Name-"+libraryName);
	}

	public void showAlert(String alert) {
		System.out.println(alert);
	}

}
