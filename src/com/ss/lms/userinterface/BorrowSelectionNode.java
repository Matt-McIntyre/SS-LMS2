package com.ss.lms.userinterface;

import java.util.List;

import com.ss.lms.entity.BookCopies;

public class BorrowSelectionNode extends MenuNode {
	
	public BorrowSelectionNode(String name, String banner) {
		super(name, banner);
	}

	@Override
	public MenuNode execute() {
		List<BookCopies> selections = service.getAvailibleBooks(service.branchSelection);
		Integer userSelection = null;

		do {
			System.out.println("\n" + this.path);
			System.out.println(this.banner);

			int optionNum = 1;
			for (BookCopies selection : selections) {
				System.out.println(optionNum + ") " + selection.getMenuString());
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
			this.service.copiesSelection = selections.get(userSelection - 1);
			this.service.bookSelection = selections.get(userSelection - 1).getBook();
			this.service.borrowBook();
			System.out.println("Book Borrowed");
			return this;
		}
	}

}
