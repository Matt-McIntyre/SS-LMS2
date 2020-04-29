package com.ss.lms.userinterface;

public class BranchUpdateNode extends MenuNode {
	
	public BranchUpdateNode(String name, String banner) {
		super(name, banner);
	}

	@Override
	public MenuNode execute() {
		
		String newName;
		String newAdd;
		
		System.out.println("You have chosen to update the Branch with\nBranchId: "
				+ service.branchSelection.getBranchId() + " and\nBranchName: " +
				service.branchSelection.getBranchName() + "\nType quit to cancel.");
		
		System.out.println("Enter new name or N/A for no change:");		
		String userInput = ConsoleReader.readString();
		
		if("quit".equalsIgnoreCase(userInput)) {
			return getParent().getParent();
		} else {
			newName = (userInput == "N/A" || userInput == null) ? null : userInput;
			
			
			System.out.println("Enter new address or N/A for no change:");
			userInput = ConsoleReader.readString();
			
			if("quit".equalsIgnoreCase(userInput)) {
				return getParent().getParent();
			} else {
				newAdd = (userInput == "N/A" || userInput == null) ? null : userInput;
				
				if(!newName.equals(null)) service.branchSelection.setBranchName(newName);
				if(!newAdd.equals(null)) service.branchSelection.setBranchAddress(newAdd);
				
				service.updateBranches(service.branchSelection);
				
				System.out.println("Update executed");
				return getParent().getParent();
			}

		}
		
	}

}
