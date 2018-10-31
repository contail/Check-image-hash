package com.java.spring.dao;

import java.util.ArrayList;

import com.java.spring.dto.MemberDto;

public interface IMemberDao {
	
	public ArrayList<MemberDto> listDao();
	public void memberJoin(String mEmail, String mPassword, String mName);
	public String memberSearch(String mEmail, String mPassword);

}
