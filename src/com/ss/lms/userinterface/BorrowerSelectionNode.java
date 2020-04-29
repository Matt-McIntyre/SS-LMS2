package com.ss.lms.userinterface;

import java.util.List;

import com.ss.lms.entity.Borrower;

public class BorrowerSelectionNode extends MenuNode {

	public BorrowerSelectionNode(String name, String banner) {
		super(name, banner);
	}

	@Override
	public MenuNode execute() {

		List<MenuNode> selections = this.getChildren();
		Borrower user;
		int numTries = 0;

		do {
			System.out.println("\n" + this.path);
			System.out.println(this.banner);

			Integer userInput = ConsoleReader.readInt();
			user = service.getBorrowerByCardNo(userInput);
			numTries++;

		} while (user.getCardNo() == null && numTries < 2 );
		
		if(user.getCardNo() == null) return getParent();

		this.service.borrowerSelection = user;
		System.out.println("\nWelcome " + user.getName());
		
		int optionNum = 1;
		for (MenuNode selection : selections) {
			System.out.println(optionNum + ") " + selection.getName());
			optionNum++;
		}
		
		Integer userSelection = ConsoleReader.readInt();
		if (userSelection < 1 || userSelection > selections.size() || userSelection == null) {
			System.out.println("Select an option between 1 and " + selections.size());
		}

		return selections.get(userSelection - 1);
	}

}
