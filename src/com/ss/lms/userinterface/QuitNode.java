package com.ss.lms.userinterface;

public class QuitNode extends MenuNode {
	
	public QuitNode(String name) {
		super(name, null);
	}

	@Override
	public MenuNode execute() {
		System.out.println("Thank you!");
		System.exit(0);
		return null;
	}
}
