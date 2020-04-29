package com.ss.lms.entity;

public class Genre extends Entity{
	
	private Integer genreId;
	private String genreName;
	
	public Integer getGenreId() {
		return genreId;
	}
	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	@Override
	public String getMenuString() {
		// TODO Auto-generated method stub
		return null;
	}	

}
