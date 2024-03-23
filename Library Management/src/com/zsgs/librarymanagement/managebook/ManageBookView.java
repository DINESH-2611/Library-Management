package com.zsgs.librarymanagement.managebook;

//import com.zsgs.librarymanagement.CustomerAccountCreation.CustomerAccountCreationView;
import com.zsgs.librarymanagement.model.Book;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ManageBookView {
	private Scanner scanner = new Scanner(System.in);
	private ManageBookModel manageBookModel;

	public ManageBookView() {
		manageBookModel = new ManageBookModel(this);
	}

	public void init() {
		try {
			while (true) {
				System.out.println(
						"1.Add Book\n2.Search Book\n3.Update Book\n4.View All Books\n5.Return To Home page \nEnter the choice");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1: {
					addBook();
					break;
				}
				case 2: {
					searchBook();
					break;
				}
				case 3: {
					updateBook();
					break;
				}
				case 4: {
					viewBook();
					break;
				}
				case 5: {
//				break;
					return;
				}
				default:
					System.out.println("Invalid choice");
				}
			}
		} catch (InputMismatchException e) {
			showAlert("Type mismatch,Enter valid choice");
			init();
		}
//			if(choice==5)
//				break;

	}
//		CustomerAccountCreationView.init();

	public void updateBook() {
		System.out.println(
				"1.Update edition\n2.Update volume\n3.Update available count\n4.return to the previous page\nEnter the choice");
		int choice = 0;
		try {
			choice = scanner.nextInt();
		} catch (InputMismatchException e) {
			showAlert("Type mismatch,Enter valid choice");
			updateBook();
		}
//		scanner.nextLine();
		switch (choice) {
		case 1: {
			updateEditon();
			break;
		}
		case 2: {
			updateVolume();
			break;
		}
		case 3: {
			updateAvailableCount();
			break;
		}
		case 4: {
			break;
		}
		default: {
			showAlert("Invalid choice");
			updateBook();
		}
		}

	}

	private void updateAvailableCount() {
		try {
		System.out.println("Enter Book id to update");
		long bookId = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter the available count");
		int availableCount = scanner.nextInt();
		manageBookModel.updateBookAvailableCount(bookId, availableCount);
		}catch (InputMismatchException e) {
			showAlert("invalid input,Enter valid input");
			updateAvailableCount();
		}
	}

	private void updateVolume() {
		try {
		System.out.println("Enter Book id to update");
		long bookId = scanner.nextLong();
//		scanner.nextLine();
		System.out.println("Enter the volume");
		int volume = scanner.nextInt();
		manageBookModel.updateBookVolume(bookId, volume);
		}catch (InputMismatchException e) {
			showAlert("invalid input,Enter valid input");
			updateAvailableCount();
		}
	}

	private void updateEditon() {
		try {
		System.out.println("Enter Book id to update");
		long bookId = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter the edition");
		String edition = scanner.nextLine();
		manageBookModel.updateBookEdition(bookId, edition);
		}catch (InputMismatchException e) {
			showAlert("invalid input,Enter valid input");
			updateAvailableCount();
		}
	}

	public void viewBook() {
		manageBookModel.viewBook();

	}

	public  void searchBook() {
		scanner.nextLine();
		System.out.println("Enter book name");
		String bookName = scanner.nextLine();
		manageBookModel.findBook(bookName.toUpperCase());
	}

	public void showBook(List<Book> bookList) {
		System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s", "Book Id", "Book name", "Author",
				"Publication", "Edition", "Avialable Count", "Journal", "Volume");
		System.out.println();
		for (Book book : bookList) {
			System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s", book.getId(), book.getName(),
					book.getAuthor(), book.getPublication(), book.getEdition(), book.getAvailableCount(),
					book.getJournal(), book.getVolume());
			System.out.println();
		}
	}

	public void addBook() {
		try {
			scanner.nextLine();
			System.out.println("Enter book name");
			String bookName = scanner.nextLine();
			System.out.println("Enter author name");
			String author = scanner.nextLine();
			System.out.println("Enter publication");
			String publication = scanner.nextLine();
			System.out.println("Enter edition");
//			scanner.nextLine();
			String edition = scanner.nextLine();
//			scanner.nextLine();
			System.out.println("Enter journal");
			String journal = scanner.nextLine();
			System.out.println("Enter book id");
			long bookId = scanner.nextLong();
			System.out.println("Enter book available count");
			int availableCount = scanner.nextInt();
			System.out.println("Enter book volume");
			int volume = scanner.nextInt();
//		System.out.println("No");
			scanner.nextLine();
			manageBookModel.setupBook(bookName, author, publication, edition, journal, bookId, availableCount, volume);

		} catch (InputMismatchException e) {
			System.out.println("Invalid book details,Enter valid details");
			addBook();
		}
	}

//	public void showLibraryName(String libraryName) {
//		System.out.println("Current Library Name-"+libraryName);
//	}

	public void showAlert(String alert) {
		System.out.println(alert);
	}

}
