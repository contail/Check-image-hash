package com.java.spring.dao;

import java.util.ArrayList;

import com.java.spring.dto.ImageDto;

public interface IImageDao {
	
	public ArrayList<ImageDto> imgDao();
	public ArrayList<ImageDto> imgView();
	public ArrayList<ImageDto> imgSearch();
	public ArrayList<ImageDto> ImageSearch(String hash);
	public String ItemSearch(String hash);
	public String hi(); 
	public void imageUpload(String image_name, String image_hash, String new_name);
	
}
