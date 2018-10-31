package com.java.spring.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.spring.dao.IImageDao;
import com.java.spring.dao.IMemberDao;

@Controller
public class LoginController {
	@Resource(name="sqlSession")
	@Autowired
	private SqlSession sqlsseion;
	
	@Resource(name="sqlSession_2")
	@Autowired
	private SqlSession sqlsseion2;
	
	
	@RequestMapping("/join")
	public String join(HttpServletRequest request, Model model){
	IMemberDao dao =  sqlsseion.getMapper(IMemberDao.class);
	System.out.println(request.getParameter("mEmail") +request.getParameter("mPassword")+ request.getParameter("mName") );
	dao.memberJoin(request.getParameter("mEmail"), request.getParameter("mPassword"), request.getParameter("mName"));		
		return "redirect:home";
	}
	
	@RequestMapping("/loginTest")
	public String login_test(HttpServletRequest request, Model model){
		IMemberDao dao = sqlsseion.getMapper(IMemberDao.class);
		String name = dao.memberSearch(request.getParameter("mEmail"), request.getParameter("mPassword"));
		 
	 
	 
		if(name !=null){
		 
			 
			model.addAttribute("name",name);
			
			return "home1"; 
		}
	 
		
		return "redirect:home";
	}
	
	
	@RequestMapping("/loginOk")
	public String login_Ok(){
		
		return "home1";
	}
	
	@RequestMapping("/loginFail")
	public String loginFail(){
		
		return "redirect:home";
	}
	

}
