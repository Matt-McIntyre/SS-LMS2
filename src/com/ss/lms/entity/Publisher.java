package com.ss.lms.entity;

public class Publisher extends Entity {
	
	private Integer publisherId;
	private String publisherName;
	private String publisherAddress;
	private String publisherPhone;	
	
	public Integer getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getPublisherAddress() {
		return publisherAddress;
	}
	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}
	public String getPublisherPhone() {
		return publisherPhone;
	}
	public void setPublisherPhone(String publisherPhone) {
		this.publisherPhone = publisherPhone;
	}
	@Override
	public String getMenuString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
