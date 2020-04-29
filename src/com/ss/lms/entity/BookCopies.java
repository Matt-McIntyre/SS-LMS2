package com.ss.lms.entity;

public class BookCopies extends Entity{
	
	private Book book;
	private LibraryBranch branch;
	private Integer noOfCopies;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public LibraryBranch getBranch() {
		return branch;
	}
	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}
	public Integer getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	
	@Override
	public String getMenuString() {	
		return book.getTitle() + " by " + book.getAuthorsString() + " has ( " + noOfCopies + " ) copies";
	}

}
