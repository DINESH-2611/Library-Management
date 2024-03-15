package com.zsgs.librarymanagement.managebook;

import java.util.Scanner;

public class ManageBookView {
	private ManageBookModel bookModel;
	public ManageBookView() {
		bookModel=new ManageBookModel(this);
	}
	
	public void init() {
		Scanner scanner=new Scanner(System.in);
		System.out.println();
	}

	public void showLibraryName(String libraryName) {
		System.out.println("Current Library Name-"+libraryName);
	}

}
