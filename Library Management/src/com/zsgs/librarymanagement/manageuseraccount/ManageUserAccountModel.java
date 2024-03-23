package com.zsgs.librarymanagement.manageuseraccount;

import java.util.List;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.IssueBookDetails;

class ManageUserAccountModel {
	private ManageUserAccountView manageUserAccountView;
	public ManageUserAccountModel(ManageUserAccountView manageUserAccountView) {
		this.manageUserAccountView=manageUserAccountView;
	}
	public void viewBooks(String userName) {
		IssueBookDetails issueBookDetails=LibraryDatabase.getInstance().getMyBookList(userName);
		if(issueBookDetails==null) {
			manageUserAccountView.showAlert("Your book list is empty");
		}else {
			manageUserAccountView.showBook(issueBookDetails);
		}
		}
		
	}


