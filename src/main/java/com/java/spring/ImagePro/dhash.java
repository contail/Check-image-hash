package com.java.spring.ImagePro;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

 

 

public class dhash {
	 
	
	static int pixel_left;
	static int pixel_right;
	static int decimal; 
	static int arr[][]  = new int [100][100];
	static int diff[] = new int [100];
	static int x=0;
	static int k=0;
	public static BufferedImage getRGB(BufferedImage resize)
	{
		 x=0;
		int h = resize.getHeight();
		int w = resize.getWidth();
		 
		for (int i = 0; i < h; i++) {
		      for (int j = 0; j < w; j++) {		        
		        int pixel = resize.getRGB(j, i);
		        arr[j][i] =  printPixelARGB(pixel);	   
		        x++;   	        
		      }
		    }  
		return resize;
	}
	
	 private static int printPixelARGB(int pixel) {
		 
		  
		    int red = (pixel >> 8) & 0xff;	  
			return red;
		   
	}

	public static String dhash(BufferedImage image) {
		 
		 StringBuffer sb = new StringBuffer();
		int decimal =0;
		 k=0; 
		 pixel_left=0;
		 pixel_right=0;
		 
		  for(int i=0;i<image.getHeight();i++)
		    {
			  for(int j=0; j<image.getHeight();j++)
			  {
				  pixel_left= arr[j][i];  
			      pixel_right= arr[j+1][i];
			        if(pixel_left>pixel_right)
			        {		        	 
			        	diff[k]=pixel_left;				        	
			        }			
			 		       
			    	k++;
			  }    		
		    
		    }		
		  for(int i=0; i<k;i++)
		  {
			  if(diff[i]!=0 )
			  {
				  decimal += (int)Math.pow(2, i%8);	
				  
			  }
			 
			  if(i%8 ==7)
			  {		
				  String hex = Integer.toHexString(decimal);
			      if(hex.length() < 2) {
			         hex = "0"+ hex;
			      }
			      sb.append(hex);
			         decimal=0;
			          
					 
					 
			  }  
		 
		  }
		  
		  for(int i=0; i<k;i++)
		  {
			  diff[i]=0;
		  }
		 
		return sb.toString();
	  }
	 
	  }
