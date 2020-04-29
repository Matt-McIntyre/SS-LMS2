package com.ss.lms.userinterface;

public class CopiesUpdateNode extends MenuNode {

	public CopiesUpdateNode(String name, String banner) {
		super(name, banner);
	}

	@Override
	public MenuNode execute() {

		Integer userInput;
		
		System.out.println("\n" + this.path);
		System.out.println(this.banner);

		do {
			System.out.println("Enter new # of copies:");
			userInput = ConsoleReader.readInt();

		} while (userInput < 0);

		service.copiesSelection.setNoOfCopies(userInput);

		service.updateNoCopies(service.copiesSelection);

		return getParent().getParent();
	}
}
