package com.ss.lms.userinterface;

public class BackNode extends MenuNode {
	
	public BackNode(String name) {
		super(name, null);		
	}
	
	@Override
	public MenuNode execute() {
		return this.getParent().getParent();
	}
}
