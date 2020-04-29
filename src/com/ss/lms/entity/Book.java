package com.ss.lms.entity;

import java.util.List;

public class Book extends Entity{
	
	private Integer bookId;
	private String title;
	private Publisher publisher;
	private String authorsString;
	private Integer copies;
	private List<Author> authors;
	private List<Genre> genres;	
	
	public Integer getBookId() {
		return bookId;
	}
	public String getAuthorsString() {
		return authorsString;
	}
	public void setAuthorsString(String authorsString) {
		this.authorsString = authorsString;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public Integer getCopies() {
		return copies;
	}
	public void setCopies(Integer copies) {
		this.copies = copies;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public List<Genre> getGenres() {
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	@Override
	public String getMenuString() {
		return title + " by " + authorsString;
	}	

}
