package com.zsgs.librarymanagement.changepassword;

import com.zsgs.librarymanagement.LibraryManagement;

import java.util.Scanner;

public class ChangePasswordView {
    Scanner scanner=new Scanner(System.in);
    private ChangePasswordModel changePasswordModel;
    public ChangePasswordView(){
        this.changePasswordModel=new ChangePasswordModel(this);
    }

    public void init() {
        System.out.println("Enter your old password");
        String oldPass=scanner.nextLine();
        changePasswordModel.checkPassword(oldPass);
    }

    public void getNewPassword() {
        System.out.println("Enter new password");
        String newPass=scanner.nextLine();
        System.out.println("Confim password");
        String cnfmPass=scanner.nextLine();
        changePasswordModel.isEqualPass(newPass,cnfmPass);
    }

    public void showAlert(String alert) {
        System.out.println(alert);
    }
}
