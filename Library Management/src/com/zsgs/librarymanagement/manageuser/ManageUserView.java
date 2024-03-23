package com.zsgs.librarymanagement.manageuser;

import com.zsgs.librarymanagement.model.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ManageUserView {
    Scanner scanner = new Scanner(System.in);
    private ManageUserModel manageUserModel;

    public ManageUserView() {

        manageUserModel = new ManageUserModel(this);
    }

    public void init() {
        try{
        while (true) {
//        	scanner.nextLine();
            System.out.println("\n1. Add User\n2. Update User\n3. view User\n4.Return to Home page");
            int choice = scanner.nextInt();
//            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    initAdd();
                    break;
                case 2:
                    initUpdate();
                    break;
                case 3:
                    viewUser();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("\nPlease Enter valid choice\n");
                    init();
            }
        }

        }catch (InputMismatchException e){
            showAlert("Type mismatch.Please enter valid choice");
            init();
        }

    }

    public void viewUser() {
       manageUserModel.viewAlluser();
    }

    private void initUpdate() {
        try{
            System.out.println("1.Update phone no\n2.Update Address\n3.Update Membership\n4.Return to previous page");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:updatePhoneNo();
                       break;
                case 2:updateAdress();
                       break;
                case 3:updateMembership();
                       break;
                case 4:return;
                default:showAlert("Invali dchoice,Enter vali choice");
                        initUpdate();
            }
        }catch (InputMismatchException e){
            showAlert("Tyme mismatch,please enter valid choice");
            initUpdate();
        }
    }

    void updateMembership() {
        try {
            System.out.println("Enter user name of the user");
            String userName=scanner.nextLine();
            System.out.println("Enter memebership");
            boolean membership=scanner.nextBoolean();
            manageUserModel.updateUserMembership(userName,membership);
        }catch (InputMismatchException e){
            showAlert("Type mismatch,Enter valid memebership");
            updateMembership();
        }
    }

     void updateAdress() {
            System.out.println("Enter user name of the user");
            String userName=scanner.nextLine();
            System.out.println("Enter the address");
            String address=scanner.nextLine();
            manageUserModel.updateUserAdress(userName,address);
    }

     void updatePhoneNo() {
        try {
            System.out.println("Enter user name of the user");
            String userName=scanner.nextLine();
            System.out.println("Enter the phone no");
            long phoneNo=scanner.nextLong();
            manageUserModel.updateUserPhoneNo(userName,phoneNo);
        }catch (InputMismatchException e){
            showAlert("Type mismatch,Enter valid phone No");
            updatePhoneNo();
        }
    }
//	       getUserDetails();


    public void initAdd() {
        try {
            scanner.nextLine();
            System.out.println("Enter the following User details");
            System.out.println("Enter user name with alpha numeric character");
            String userName = scanner.nextLine();
//            scanner.nextLine();
            System.out.println("Enter user email id");
            String emailId = scanner.nextLine();
            System.out.println("Enter the passWord");
            String password=scanner.nextLine();
            System.out.println("Enter user address");
            String address = scanner.nextLine();
            System.out.println("Enter user phone number");
            long phoneNo = scanner.nextLong();
            scanner.nextLine();

        manageUserModel.createUserAccount(userName, emailId,password, address, phoneNo, true);
        }catch (InputMismatchException e){
            showAlert("Type mismatch,Please enter valid phone number");
            initAdd();
        }
    }


    public void showAlert(String alert) {

        System.out.println(alert);
    }

    public void checkAgainAdd() {
        System.out.println("Do you want to continue\nYes\nNo");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes"))
            initAdd();
        else if (choice.equalsIgnoreCase("no"))
            System.out.println("Thank you");
        else {
            System.out.println("Invalid choice");
            checkAgainAdd();
        }
    }

    public void showUserList(List<User> allUser) {
        System.out.printf("%-15s %-25s %-15s %-15s %-15s %-15s","User Name","Email id","Phone No","Address","Membership","Book Count");
        System.out.println();
        for (User user:allUser){
//        	System.out.println(user.getUserName());
            System.out.printf("%-15s %-25s %-15s %-15s %-15s %-15s",user.getUserName(),user.getEmailId(),user.getPhoneNo(),user.getAddress(),user.isMembership(),user.getBookCount());
            System.out.println();
        }
    }
}



