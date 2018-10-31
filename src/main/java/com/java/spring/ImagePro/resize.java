package com.java.spring.ImagePro;

import java.awt.Graphics2D;
 
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class resize {

	public static BufferedImage resize(BufferedImage img, int newW, int newH) {  
	    int w = img.getWidth();  
	    int h = img.getHeight();  
	    BufferedImage dimg = new BufferedImage(newW, newH, img.getType());  
	    Graphics2D g = dimg.createGraphics();  
	    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	    		RenderingHints.VALUE_ANTIALIAS_ON);
	    g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);  
	    g.dispose();  
	    return dimg;  
}
}
