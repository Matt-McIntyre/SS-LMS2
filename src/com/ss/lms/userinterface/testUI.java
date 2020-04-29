package com.ss.lms.userinterface;

import java.util.Arrays;

import com.ss.lms.service.AdminService;

public class testUI {	

	public static void main(String[] args) {		
		
		System.out.println("WELCOME TO THE GCIT LIBRARY MANAGMENT SYSTEM.");		

		MenuNode nextNode = getUI().execute();
		while(nextNode != null) {
			nextNode = nextNode.execute();
		}	

	}
	
	public static MenuNode getUI() {
		
		AdminService libraryService = new AdminService();

		MenuNode menuRoot = new SelectionNode("Main Menu", "Which Category of user are you?");
		menuRoot.setService(libraryService);
		
		MenuNode LM = new SelectionNode("Librarian", "Which branch do you manage:");
		MenuNode BM = new SelectionNode("Borrower", "Select an option:");
		MenuNode AM = new SelectionNode("Administrator", "Select Opperation:");
		MenuNode QN = new QuitNode("Quit");
		menuRoot.addChildren(Arrays.asList(LM, BM, AM, QN));
		
		MenuNode LM0 = new BranchSelectionNode("Branch List", "Select a Branch:");
		MenuNode LM1 = new BackNode("Back");
		LM.addChildren(Arrays.asList(LM0, LM1));
		
		MenuNode LM00 = new SelectionNode("Modify Branch", "Branch Name");
		MenuNode LM01 = new BackNode("Back");
		LM0.addChildren(Arrays.asList(LM00, LM01));
		
		MenuNode LM000 = new BranchUpdateNode("Update Details of Branch", "Enter New Information:");
		MenuNode LM001 = new CopiesSelectionNode("Add Copies of a Book", "Select a Book");
		MenuNode LM002 = new BackNode("Back");
		LM00.addChildren(Arrays.asList(LM000, LM001, LM002));
		
		MenuNode LM0010 = new CopiesUpdateNode("update copies node", "update copies node");
		MenuNode LM0011 = new BackNode("Back");
		LM001.addChildren(Arrays.asList(LM0010, LM0011));
		
		MenuNode BM0 = new BorrowerSelectionNode("Sign in", "Enter your Card Number:");
		MenuNode BM1 = new BackNode("Back");
		BM.addChildren(Arrays.asList(BM0, BM1));
		
		MenuNode BM00 = new BranchSelectionNode("Check out a book", "Which Branch");
		MenuNode BM01 = new BranchSelectionNode("Return a book", "Which Branch");
		MenuNode BM02 = new BackNode("Back");
		BM0.addChildren(Arrays.asList(BM00, BM01, BM02));
		
		MenuNode BM000 = new BorrowSelectionNode("Select a Book", "xxxx");
		MenuNode BM001 = new BackNode("Back");
		BM00.addChildren(Arrays.asList(BM000, BM001));
		
		MenuNode BM010 = new BorrowedSelectionNode("Select a Book", "xxxx");
		MenuNode BM011 = new BackNode("Back");
		BM01.addChildren(Arrays.asList(BM010, BM011));
		
		MenuNode AMB = new BackNode("Back");
		AM.addChildren(Arrays.asList(AMB));	
		
		return menuRoot;
		
	}

}
