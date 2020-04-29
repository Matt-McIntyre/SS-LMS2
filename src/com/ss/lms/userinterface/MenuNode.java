package com.ss.lms.userinterface;

import java.util.ArrayList;
import java.util.List;

import com.ss.lms.service.AdminService;

public abstract class MenuNode {
	
	String name;
	String path;
	String banner;
	AdminService service;
	
	MenuNode parent = null;
	List<MenuNode> children = new ArrayList<MenuNode>();
	
	public abstract MenuNode execute();
	
	public MenuNode() {}
	
	public MenuNode(String name, String banner) {
		this.name = name;
		this.path = name;
		this.banner = banner;
	}	

	public MenuNode addChild(MenuNode child) {
		child.setParent(this);
		child.setService(this.service);
		this.children.add(child);
		return child;
	}
	
	public void addChildren(List<MenuNode> children) {
		children.forEach(child -> child.setParent(this));
		children.forEach(child -> child.setService(this.service));
		this.children.addAll(children);
	}
	
	public List<MenuNode> getChildren(){
		return this.children;
	}
	
	public MenuNode getChild(int c) {
		return this.children.get(c);
	}
	
	public MenuNode getParent() {
		return this.parent;
	}
	
	public void setParent(MenuNode parent) {
		this.parent = parent;
		this.path = parent.path + " > " + this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setBanner(String banner) {
		this.banner = banner;
	}
	
	public AdminService getService() {
		return service;
	}

	public void setService(AdminService service) {
		this.service = service;
	}

}
