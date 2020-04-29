package com.ss.lms.userinterface;

import java.util.List;
import com.ss.lms.entity.LibraryBranch;

public class BranchSelectionNode extends MenuNode {

	public BranchSelectionNode(String name, String banner) {
		super(name, banner);
	}

	@Override
	public MenuNode execute() {

		List<LibraryBranch> selections = service.readAllBranches();
		Integer userSelection = null;

		do {
			System.out.println("\n" + this.path);
			System.out.println(this.banner);

			int optionNum = 1;
			for (LibraryBranch selection : selections) {
				System.out.println(optionNum + ") " + selection.getMenuString());
				optionNum++;
			}
			
			System.out.println(optionNum + ") " + this.getChild(1).getName());

			userSelection = ConsoleReader.readInt();
			if (userSelection < 1 || userSelection > selections.size() + 1 || userSelection == null) {
				System.out.println("Select an option between 1 and " + selections.size() + 1);
			}

		} while (userSelection < 1 || userSelection > selections.size() + 1);
		
		if(userSelection == selections.size() + 1) {
			return this.getChild(1);
		} else {
			this.service.branchSelection = selections.get(userSelection - 1);
			getChild(0).setBanner(selections.get(userSelection - 1).getMenuString());
			return getChild(0);			
		}
		
	}

}
