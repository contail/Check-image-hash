package com.java.spring.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.java.spring.dto.MemberDto;

public class MemberDao implements IMemberDao {
	JdbcTemplate template;
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	@Override
	public ArrayList<MemberDto> listDao() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void memberJoin(String mEmail, String mPassword, String mName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String memberSearch(String mEmail, String mPassword) {
		// TODO Auto-generated method stub
		return "";
	}
	
	

}
