package com.zsgs.librarymanagement.changepassword;

import com.zsgs.librarymanagement.LibraryManagement;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.login.LoginView;
import com.zsgs.librarymanagement.model.Credentials;

class ChangePasswordModel {
    private ChangePasswordView changePasswordView;
    private Credentials credentials;
    public ChangePasswordModel(ChangePasswordView changePasswordView){
        this.credentials=LibraryDatabase.getInstance().getCredentials();
        this.changePasswordView=changePasswordView;
    }

    public void changePassword(String newPass) {
//        LibraryDatabase.getInstance().setCredentialsPassword(newPass);
        LibraryDatabase.getInstance().getCredentials().setPassword(newPass);
        changePasswordView.showAlert("Password changed successfully");
        new LoginView().init();
    }

    public void checkPassword(String oldPass) {
        if (oldPass.equals(this.credentials.getPassword())) {
            changePasswordView.getNewPassword();
        }else{
            changePasswordView.showAlert("Password incorrect");
            changePasswordView.init();
        }
    }

    public void isEqualPass(String newPass, String cnfmPass) {
        if(newPass.equals(cnfmPass)){
            changePassword(newPass);
        }else{
            changePasswordView.showAlert("New password and cnfm password must be same");
            changePasswordView.getNewPassword();
        }
    }
}
