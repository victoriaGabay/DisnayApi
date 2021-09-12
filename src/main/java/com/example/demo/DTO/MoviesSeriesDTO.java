package com.example.demo.DTO;

import java.util.Date;

public class MoviesSeriesDTO {

	private String imageUrl;
	private String title;
	private Date creationDate;
	public MoviesSeriesDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	

}
