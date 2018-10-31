package com.java.spring.ImagePro;

import java.awt.Color;
import java.awt.image.BufferedImage;
 

public class grayscale {

	 public static BufferedImage luminosity(BufferedImage original) {
		 
		 int alpha, red, green, blue;
	        int newPixel;
	 
	        BufferedImage lum = null;
	        lum = original;
	 
	        for(int i=0; i<original.getWidth(); i++) {
	            for(int j=0; j<original.getHeight(); j++) {
	 
	                // Get pixels by R, G, B
	                alpha = new Color(original.getRGB(i, j)).getAlpha();
	                red = new Color(original.getRGB(i, j)).getRed();
	                green = new Color(original.getRGB(i, j)).getGreen();
	                blue = new Color(original.getRGB(i, j)).getBlue();
	               // L = R * 299/1000 + G * 587/1000 + B * 114/1000
	                
	                red = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
	                // Return back to original format
	                newPixel = colorToRGB(alpha, red, red, red);
	 
	                // Write pixels into image
	                lum.setRGB(i, j, newPixel);
	 
	            }
	        }
	 
	        return lum;
	    }
	 
	 private static int colorToRGB(int alpha, int red, int green, int blue) {
		 
	        int newPixel = 0;
	        newPixel += alpha;
	        newPixel = newPixel << 8;
	        newPixel += red; newPixel = newPixel << 8;
	        newPixel += green; newPixel = newPixel << 8;
	        newPixel += blue; 
	        return newPixel; 
	    }
}
