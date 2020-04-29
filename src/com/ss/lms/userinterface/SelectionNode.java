package com.ss.lms.userinterface;

import java.util.List;

public class SelectionNode extends MenuNode {

	public SelectionNode(String name, String banner) {
		super(name, banner);
	}

	@Override
	public MenuNode execute() {

		List<MenuNode> selections = this.getChildren();
		Integer userSelection = null;

		do {
			System.out.println("\n" + this.path);
			System.out.println(this.banner);

			int optionNum = 1;
			for (MenuNode selection : selections) {
				System.out.println(optionNum + ") " + selection.getName());
				optionNum++;
			}
			userSelection = ConsoleReader.readInt();
			if (userSelection < 1 || userSelection > selections.size() || userSelection == null) {
				System.out.println("Select an option between 1 and " + selections.size());
			}

		} while (userSelection < 1 || userSelection > selections.size());

		return selections.get(userSelection - 1);
	}

}
