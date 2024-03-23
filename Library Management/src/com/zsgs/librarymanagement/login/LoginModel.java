package com.zsgs.librarymanagement.login;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.manageuseraccount.ManageUserAccountView;
import com.zsgs.librarymanagement.model.Credentials;
import com.zsgs.librarymanagement.model.User;

public class LoginModel {
    private LoginView loginView;
    private Credentials credentials;

    LoginModel(LoginView loginView) {
        this.credentials = LibraryDatabase.getInstance().getCredentials();
        this.loginView = loginView;

    }

    public void validateUser(String userName, String password) {
        if (validateUserName(userName)) {
            if (validatePassword(password)) {
                loginView.onSuccess();

            } else {
                loginView.showAlert("Invalid password");
            }
        } else {
            if (isUser(userName, password)) {
                return;
            }
            else if (validatePassword(password))
                loginView.showAlert("Invalid username");
            else
            	loginView.showAlert("Invalid user name and password");


        }

    }

    private boolean isUser(String userName, String password) {

        if(LibraryDatabase.getInstance().isUser(userName,password)) {
        	new ManageUserAccountView().init(userName);
        	return true;
        }return false;
    }

//    public void lbrarySetup() {
//
//    }

    private boolean validateUserName(String userName) {
        return userName.equals(credentials.getUserName());
    }

    private boolean validatePassword(String password) {
        return password.equals(credentials.getPassword());
    }

}
