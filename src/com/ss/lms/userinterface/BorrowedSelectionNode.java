package com.ss.lms.userinterface;

import java.util.List;

import com.ss.lms.entity.Book;

public class BorrowedSelectionNode extends MenuNode {
	
	public BorrowedSelectionNode(String name, String banner) {
		super(name, banner);
	}

	@Override
	public MenuNode execute() {
		List<Book> selections = service.booksBorrowed(service.branchSelection, service.borrowerSelection);
		Integer userSelection = null;

		do {
			System.out.println("\n" + this.path);
			System.out.println(this.banner);

			int optionNum = 1;
			for (Book selection : selections) {
				System.out.println(optionNum + ") " + selection.getTitle());
				optionNum++;
			}

			System.out.println(optionNum + ") Back");

			userSelection = ConsoleReader.readInt();
			if (userSelection < 1 || userSelection > selections.size() + 1 || userSelection == null) {
				System.out.println("Select an option between 1 and " + selections.size() + 1);
			}

		} while (userSelection < 1 || userSelection > selections.size() + 1);

		if (userSelection == selections.size() + 1) {
			return getParent();
		} else {
			this.service.bookSelection = selections.get(userSelection - 1);
			this.service.returnBook();
			System.out.println("Book Returned");
			return this;
		}
	}

}
