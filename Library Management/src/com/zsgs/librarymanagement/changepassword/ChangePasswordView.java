package com.zsgs.librarymanagement.changepassword;

import java.util.Scanner;

public class ChangePasswordView {
    Scanner scanner=new Scanner(System.in);
    private ChangePasswordModel changePasswordModel;
    public ChangePasswordView(){
        this.changePasswordModel=new ChangePasswordModel(this);
    }

    public void init(String userName) {
        System.out.println("Enter your old password");
        String oldPass=scanner.nextLine();
        changePasswordModel.checkPassword(userName,oldPass);
    }

    public void getNewPassword(String userName) {
        System.out.println("Enter new password");
        String newPass=scanner.nextLine();
        System.out.println("Confim password");
        String cnfmPass=scanner.nextLine();
        changePasswordModel.isEqualPass(userName,newPass,cnfmPass);
    }

    public void showAlert(String alert) {
        System.out.println(alert);
    }
}
