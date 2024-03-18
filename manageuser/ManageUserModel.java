package com.zsgs.librarymanagement.manageuser;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Credentials;
import com.zsgs.librarymanagement.model.User;
import com.zsgs.librarymanagement.model.Validation;

public class ManageUserModel {
	 private ManageUserView manageUserView;
	    private long password=14022024;
	    public  ManageUserModel(ManageUserView manageUserView) {
			this.manageUserView=manageUserView;
		}

	    public  void createUserAccount(String userName, String emailId, String address, long phoneNo, boolean membership) {
	        if(new Validation().isEmailvalidator(emailId) && String.valueOf(phoneNo).length()==10){
	            User user=new User();
	            user.setUserName(userName);
	            user.setAddress(address);
	            user.setEmailId(emailId);
	            user.setPhoneNo(phoneNo);
	            user.setMembership(membership);
	            LibraryDatabase.getInstance().insertUserAccount(user);
	            manageUserView.showAlert("User account created successfully");
	            Credentials credentials=new Credentials();
	            credentials.setUserName(userName);
	            credentials.setPassword(password++);
	            LibraryDatabase.getInstance().addCredentials(credentials);
//	            customerAccountCreationView.showUserId(String userId)
	        }else{
	            manageUserView.showAlert("Invalid user details");
	            manageUserView.checkAgainAdd();
	        }
	    }

}
