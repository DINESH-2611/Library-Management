package com.zsgs.librarymanagement.changepassword;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.login.LoginView;
import com.zsgs.librarymanagement.model.Credentials;

class ChangePasswordModel {
    private ChangePasswordView changePasswordView;
    private Credentials credentials;
    public ChangePasswordModel(ChangePasswordView changePasswordView){
//        this.credentials=LibraryDatabase.getInstance().getCredentials();
        this.changePasswordView=changePasswordView;
    }

    public void changePassword(String userName, String password) {
        LibraryDatabase.getInstance().changePassWord(userName,password);
        changePasswordView.showAlert("Password changed successfully");
        new LoginView().init();
    }

    public void checkPassword(String userName, String password) {
        if(LibraryDatabase.getInstance().passwordMatch(userName,password)){
            changePasswordView.getNewPassword(userName);
        }
    }

    public void isEqualPass(String userName,String newPass, String cnfmPass) {
        if(newPass.equals(cnfmPass)){
            changePassword(userName,newPass);
        }else{
            changePasswordView.showAlert("New password and cnfm password must be same");
            changePasswordView.getNewPassword(userName);
        }
    }
}
