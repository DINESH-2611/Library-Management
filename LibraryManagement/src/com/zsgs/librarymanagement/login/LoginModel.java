package com.zsgs.librarymanagement.login;

public class LoginModel {
	private LoginView loginView;

	LoginModel(LoginView loginView) {
		this.loginView = loginView;

	}

	public void validateUser(String userName, String password) {
		if (validateUserName(userName)) {
			if (validatePassword(password)) {
				loginView.onSuccess();

			} else {
				loginView.showAlert("Invalid password");
				loginView.getLoginDetials();
			}
		} else {
			loginView.showAlert("Invalid username");
			loginView.getLoginDetials();
		}

	}

	public void lbrarySetup() {

	}

	private boolean validateUserName(String userName) {
		return userName.equals("zsgs");
	}

	private boolean validatePassword(String password) {
		return password.equals("admin");
	}

}
