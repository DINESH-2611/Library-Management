package com.zsgs.librarymanagement.login;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.zsgs.librarymanagement.LibraryManagement;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.librarysetup.LibrarySetupView;

public class LoginView {
	Scanner scanner = new Scanner(System.in);
	private LoginModel loginModel;

	public LoginView() {
		loginModel = new LoginModel(this);

	}

	public void init() {
		try {
			System.out.println("--- " + LibraryManagement.getInstance().getAppName() + " --- \nversion "
					+ LibraryManagement.getInstance().getAppVersion());
			System.out.println("1.Login\n2.Exit\nEnter the choice");
			int choice=scanner.nextInt();
			scanner.nextLine();
			while(true) {
				switch (choice) {
					case 1:
						loginModel.getAndSave();
						getLoginDetials();
						break;
					case 2:
						loginModel.saveAll();
						System.out.println("\t\t\t---Thanks for using " + LibraryManagement.getInstance().getAppName() + "---");
						System.exit(0);
//						return;
						break;
					default:
						System.out.println("Invalid choice,Enter valid choice");
						init();
						break;

				}if(choice==2)
					return;
			}
		}catch (InputMismatchException e){
			System.out.println("Invalid input,Enter valid input");
			checker();
		}
	}

	private void checker() {
		scanner.nextLine();
		System.out.println("Do you try again \nYes\nNo");
		String choice=scanner.nextLine();
		if(choice.equalsIgnoreCase("yes"))
			init();
		else if(choice.equalsIgnoreCase("no")) {
			System.out.println("\t\t\t---Thanks for using " + LibraryManagement.getInstance().getAppName() + "---");
			return;
		}
		else {
			System.out.println("Invalid choice\nPlease enter valid choice");
			checker();
		}
	}

	public void getLoginDetials() {
//		System.out.println(88);
		System.out.println("Enter the username");
		String userName = scanner.nextLine();
		System.out.println("Enter the password");
		String password = scanner.nextLine();
		loginModel.validateUser(userName, password);
	}

	public void onSuccess(String userName) {
		System.out.flush();
		System.out.println("\n\nLogin successful...\n\n ---- welcome to " + LibraryManagement.getInstance().getAppName()
				+ " - v" + LibraryManagement.getInstance().getAppVersion() + "----");
//		System.out.println("Login Success");
		loginModel.libraryFile();
		new LibrarySetupView().init(userName);
	}

	public void showAlert(String alert) {
		System.out.println(alert);
		checkForLogin();
	}
	public void checkForLogin() {
		System.out.println("Do you try again \nYes\nNo");
		String choice=scanner.nextLine();
		if(choice.equalsIgnoreCase("yes"))
			getLoginDetials();
		else if(choice.equalsIgnoreCase("no"))
			System.out.println("\t\t\tThank you");
		else {
			System.out.println("Invalid choice\nPlease enter valid choice");
			checkForLogin();
		}
	}

}
