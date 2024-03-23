package com.zsgs.librarymanagement.manageuser;

import java.util.List;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Credentials;
import com.zsgs.librarymanagement.model.User;
import com.zsgs.librarymanagement.model.Validation;

class ManageUserModel {
	 private ManageUserView manageUserView;
	    private long password=14022024;
	    public  ManageUserModel(ManageUserView manageUserView) {
			this.manageUserView=manageUserView;
		}

	    public  void createUserAccount(String userName, String emailId,String password, String address, long phoneNo, boolean membership) {
	    	Validation validation=new Validation();
	        if(validation.isEmailvalidator(emailId) && String.valueOf(phoneNo).length()==10){
	        	if(LibraryDatabase.getInstance().getUser(userName)==null){
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
	            credentials.setPassword(password);
	            LibraryDatabase.getInstance().addCredentials(credentials);
	        }else {
	        	manageUserView.showAlert("User Already exist");
	        	}
	        }
	        else{
	            manageUserView.showAlert("Invalid user details");
	            manageUserView.checkAgainAdd();
	        }
	    }

	public void updateUserPhoneNo(String userName, long phoneNo) {
			if(LibraryDatabase.getInstance().getUser(userName)!=null){
				LibraryDatabase.getInstance().updateUserPhoneNo(userName,phoneNo);
				manageUserView.showAlert("User phone no updated successfully");
			}else{
				manageUserView.showAlert("User not found");
				manageUserView.updatePhoneNo();
			}
	}
	public void updateUserAdress(String userName,String adress) {
		if(LibraryDatabase.getInstance().getUser(userName)!=null){
			LibraryDatabase.getInstance().updateUserAdress(userName,adress);
			manageUserView.showAlert("User adress updated successfully");
		}else{
			manageUserView.showAlert("User not found");
			manageUserView.updateAdress();
		}
	}
	public void updateUserMembership(String userName, boolean memebership) {
		if(LibraryDatabase.getInstance().getUser(userName)!=null){
			LibraryDatabase.getInstance().updateUserMembership(userName,memebership);
			manageUserView.showAlert("User memebership updated successfully");
		}else{
			manageUserView.showAlert("User not found");
			manageUserView.updateMembership();
		}
	}

	public void viewAlluser() {
			List<User> usersList=LibraryDatabase.getInstance().getAllUser();
			if(usersList.size()==0) {
				manageUserView.showAlert("No user exist");
			}else {
				manageUserView.showUserList(usersList);
			}
	}
}
