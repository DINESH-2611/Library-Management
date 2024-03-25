package com.zsgs.librarymanagement.login;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.librarysetup.LibrarySetupView;
import com.zsgs.librarymanagement.manageuseraccount.ManageUserAccountView;
import com.zsgs.librarymanagement.model.Credentials;
import com.zsgs.librarymanagement.model.User;

public class LoginModel {
    private LoginView loginView;
//    private Credentials credentials;

    LoginModel(LoginView loginView) {
//        this.credentials = LibraryDatabase.getInstance().getCredentials();
        this.loginView = loginView;

    }

    public void validateUser(String userName, String password) {
        if (LibraryDatabase.getInstance().isUSer(userName)) {
            if (LibraryDatabase.getInstance().passwordMatch(userName, password)) {
                int role = LibraryDatabase.getInstance().getRole(userName);
                if (role == 0) {
//                    LibraryDatabase.getInstance().libraryFromFile();
                    loginView.onSuccess(userName);
                } else {
                    LibraryDatabase.getInstance().isuueBookFromFile();
                    LibraryDatabase.getInstance().bookFromFile();
                    LibraryDatabase.getInstance().userFromFile();
                    new ManageUserAccountView().init(userName);
                }
            } else {
                loginView.showAlert("Invalid password");
            }
        } else {
            loginView.showAlert("Invalid username");
        }
    }


    public void libraryFile() {
        LibraryDatabase.getInstance().libraryFromFile();
    }

    public void getAndSave() {
        LibraryDatabase.getInstance().credentialsFromFile();
        LibraryDatabase.getInstance().createCredentials();
        LibraryDatabase.getInstance().saveCredentials();
    }

    public void saveAll() {
        LibraryDatabase.getInstance().saveAll();
    }
}
