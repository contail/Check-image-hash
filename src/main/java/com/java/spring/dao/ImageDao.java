package com.java.spring.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.java.spring.dto.ImageDto;

public class ImageDao implements IImageDao {

	JdbcTemplate template;
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}


	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


	@Override
	public ArrayList<ImageDto> imgDao() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String ItemSearch(String hash) {
		// TODO Auto-generated method stub
		return "";
	}


	@Override
	public String hi() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void imageUpload(String image_name, String image_hash, String new_name) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ArrayList<ImageDto> imgView() {
		// TODO Auto-generated method stub
		return null;
	}


 


	@Override
	public ArrayList<ImageDto> ImageSearch(String hash) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<ImageDto> imgSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
