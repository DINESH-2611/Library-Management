package com.zsgs.librarymanagement.login;

import com.zsgs.librarymanagement.librarysetup.LibrarySetupView;

import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;
   public LoginView(){
       loginModel=new LoginModel(this);

    }
    public void init(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the username");
        String userName=scanner.next();
        System.out.println("Enter the password");
        String password=scanner.next();
        loginModel.validateUser(userName,password);

    }
    public void onSuccess(){
        System.out.println("Login Success");
        LibrarySetupView librarySetupView=new LibrarySetupView();
        librarySetupView.init();
    }
    public void showAlert(String alert){
        System.out.println(alert);
    }
}
