package com.ss.lms.entity;

import java.time.LocalDateTime;

public class BookLoans extends Entity{
	
	private Book book;
	private LibraryBranch branch;
	private Borrower borrower;
	private LocalDateTime dateOut;
	private LocalDateTime dueDate;
	private LocalDateTime dateIn;
	
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
	public Borrower getBorrower() {
		return borrower;
	}
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	public LocalDateTime getDateOut() {
		return dateOut;
	}
	public void setDateOut(LocalDateTime dateOut) {
		this.dateOut = dateOut;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDateTime getDateIn() {
		return dateIn;
	}
	public void setDateIn(LocalDateTime dateIn) {
		this.dateIn = dateIn;
	}
	@Override
	public String getMenuString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
