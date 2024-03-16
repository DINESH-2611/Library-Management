package com.zsgs.librarymanagement.CustomerAccountCreation;

import java.util.Scanner;

public class CustomerAccountCreationView {
    Scanner scanner=new Scanner(System.in);
    private CustomerAccountCreationModel customerAccountCreationModel;
    public CustomerAccountCreationView(){
        customerAccountCreationModel=new CustomerAccountCreationModel(this);
    }

    public  void init() {
       getUserDetails();


    }
    public void getUserDetails(){
        System.out.println("Enter User details to create account");
        System.out.println("Enter user name");
        String userName=scanner.nextLine();
        System.out.println("Enter user email id");
        String emailId=scanner.nextLine();
        System.out.println("Enter user address");
        String address=scanner.nextLine();
        System.out.println("Enter user phone number");
        long phoneNo=scanner.nextLong();
        scanner.nextLine();
        customerAccountCreationModel.createUserAccount(userName,emailId,address,phoneNo,true);
    }


    public void showAlert(String alert) {
        System.out.println(alert);
    }

    public void checkAgainAdd() {
        System.out.println("Do you want to create account\nYes\nNo");
        String choice=scanner.nextLine();
        if(choice.equalsIgnoreCase("yes"))
            getUserDetails();
        else if(choice.equalsIgnoreCase("no"))
            System.out.println("Add another feature");
        else{
            System.out.println("Invalid choice");
            checkAgainAdd();
        }
    }
}
