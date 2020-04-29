package com.ss.lms.entity;

import java.util.List;

public class Author extends Entity{

	private Integer authorId;
	private String authorName;
	private List<Book> books;

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String getMenuString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}