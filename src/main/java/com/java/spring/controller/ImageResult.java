package com.java.spring.controller;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.spring.dao.IImageDao;

@Controller
public class ImageResult {
	
	@Resource(name="sqlSession_2")
	@Autowired
	private SqlSession sqlsession;
	
	@RequestMapping("/image_view")
	public String image_view(Model model){
		
		IImageDao dao = sqlsession.getMapper(IImageDao.class);
		model.addAttribute("image_view", dao.imgView());		
	 
		return "image_view";
	}

}
