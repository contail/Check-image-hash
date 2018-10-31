package com.java.spring.ImagePro;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.ibatis.session.SqlSession;

public class MatchingService {
	
	public String Matching(File file){
		grayscale gray = new grayscale();
		String hash_val=null;
		 
		try {
		 
			BufferedImage uploadImg = ImageIO.read(file);			 
			BufferedImage img_resize = resize.resize(gray.luminosity(uploadImg),7,6);			 
			 hash_val = dhash.dhash(dhash.getRGB(img_resize));
		 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 return hash_val;
	}

}
