package com.zsgs.librarymanagement.manageuser;

import java.util.Scanner;

public class ManageUserView {
	 Scanner scanner=new Scanner(System.in);
	    private ManageUserModel manageUserModel;
	    public  ManageUserView() {
			manageUserModel=new ManageUserModel(this);
		}

	    public  void init() {
	       getUserDetails();


	    }
	    public void getUserDetails(){
	        System.out.println("Enter the following User details");
	        System.out.println("Enter user name");
	        String userName=scanner.nextLine();
	        System.out.println("Enter user email id");
	        String emailId=scanner.nextLine();
	        System.out.println("Enter user address");
	        String address=scanner.nextLine();
	        System.out.println("Enter user phone number");
	        long phoneNo=scanner.nextLong();
	        scanner.nextLine();
	       manageUserModel.createUserAccount(userName,emailId,address,phoneNo,true);
	    }


	    public void showAlert(String alert) {
	        System.out.println(alert);
	    }

	    public void checkAgainAdd() {
	        System.out.println("Do you want to try again\nYes\nNo");
	        String choice=scanner.nextLine();
	        if(choice.equalsIgnoreCase("yes"))
	            getUserDetails();
	        else if(choice.equalsIgnoreCase("no"))
	            System.out.println("Thank you");
	        else{
	            System.out.println("Invalid choice");
	            checkAgainAdd();
	        }
	    }

}
