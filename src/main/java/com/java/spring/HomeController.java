package com.java.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);  
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/home")
	public String home_(Locale locale, Model model) {
	 		
		return "home";
	}
	
	@RequestMapping("/home1")
	public String home1(){
		return "home1";
	}
	@RequestMapping("/join_member")
	public String join_member(){
		return "join_member";
	}	
	 
	
	@RequestMapping("/imageUpload")
	public String img_up() {

		return "imageUpload";
	}
	
	@RequestMapping("/image_upload_fail")
	public String imgae_upload_fail(){
		
		return "image_upload_fail";
	}
	
}
