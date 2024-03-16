package com.zsgs.librarymanagement.CustomerAccountCreation;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Credentials;
import com.zsgs.librarymanagement.model.User;
import com.zsgs.librarymanagement.model.Validation;

public class CustomerAccountCreationModel {
    private CustomerAccountCreationView customerAccountCreationView;
    private long password=14022024;
    public CustomerAccountCreationModel(CustomerAccountCreationView customerAccountCreationView) {
        this.customerAccountCreationView=customerAccountCreationView;
    }

    public  void createUserAccount(String userName, String emailId, String address, long phoneNo, boolean membership) {
        if(new Validation().isEmailvalidator(emailId) && String.valueOf(phoneNo).length()==0){
            User user=new User();
            user.setUserName(userName);
            user.setAddress(address);
            user.setEmailId(emailId);
            user.setPhoneNo(phoneNo);
            user.setMembership(membership);
            LibraryDatabase.getInstance().insertUserAccount(user);
            customerAccountCreationView.showAlert("User account created successfully");
            Credentials credentials=new Credentials();
            credentials.setUserName(userName);
            credentials.setPassword(password++);
            LibraryDatabase.getInstance().addCredentials(credentials);
//            customerAccountCreationView.showUserId(String userId)
        }else{
            customerAccountCreationView.showAlert("Invalid user details");
            customerAccountCreationView.checkAgainAdd();
        }
    }


}
