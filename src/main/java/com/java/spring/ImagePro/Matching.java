package com.java.spring.ImagePro;

 

import com.java.spring.dto.ImageDto;

public class Matching {

	static double per;
	public static double getPer() {
		return per;
	}
	public void setPer(double per) {
		Matching.per = per;
	}
	public static boolean Result(ImageDto aa, String b)
	{
		double count =0;
		 
		 
		 for(int i=0;i<b.length();i++)
		{
			 
			if(aa.getImage_hash().charAt(i) == b.charAt(i))
				count++;
			
		}	
		 
		 System.out.println("count의 값" + count);
		
		 if(count >4)
			{
			  
			 per = (double)(count/8 * 100) ;
			 System.out.println("per의 값" + per);
				return true;
			}
			 
		  
			return false;	 
		
	}
	
 
}
