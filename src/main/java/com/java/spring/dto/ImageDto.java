package com.java.spring.dto;

import java.sql.Timestamp;

public class ImageDto {
	
	
	public String getImage_hash() {
		return Image_hash;
	}
	public void setImage_hash(String Image_hash) {
		this.Image_hash = Image_hash;
	}
	public String getnew_name() {
		return new_name;
	}
	public void setnew_name(String new_name) {
		this.new_name = new_name;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	public String getimage_name() {
		return image_name;
	}
	public void setimage_name(String image_name) {
		this.image_name = image_name;
	}
	Timestamp bDate;
	private String new_name;	
	private String image_name;
	private String Image_hash;
	

}
