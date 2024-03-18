package com.zsgs.librarymanagement.login;

import java.util.Scanner;

import com.zsgs.librarymanagement.LibraryManagement;
import com.zsgs.librarymanagement.librarysetup.LibrarySetupView;

public class LoginView {
	Scanner scanner = new Scanner(System.in);
	private LoginModel loginModel;

	public LoginView() {
		loginModel = new LoginModel(this);

	}

	public void init() {
		System.out.println("--- " + LibraryManagement.getInstance().getAppName() + " --- \nversion "
				+ LibraryManagement.getInstance().getAppVersion());
		getLoginDetials();
	}

	public void getLoginDetials() {
		System.out.println("Enter the username");
		String userName = scanner.nextLine();
		System.out.println("Enter the password");
		String password = scanner.nextLine();
		loginModel.validateUser(userName, password);
	}

	public void onSuccess() {
		System.out.flush();
		System.out.println("\n\nLogin successful...\n\n ---- welcome to " + LibraryManagement.getInstance().getAppName()
				+ " - v" + LibraryManagement.getInstance().getAppVersion() + "----");
		System.out.println("Login Success");
		LibrarySetupView librarySetupView = new LibrarySetupView();
		librarySetupView.init();
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
