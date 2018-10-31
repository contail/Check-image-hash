# Different Hash 기법을 통하여 이미지 유사도 판별

## 문제점
* Iconfinde는 매월 수 천개의 아이콘이 올라와서 판매되는 마켓 플레이스 스타트업 회사이다. 
* 문제는 타인의 이미지를 다운받고, 그대로 올리거나 약간 수정하여 업로드 후 판매해서 수익을 얻는 사용자가 생기고, 이런 사용자를 자동으로 찾아야 한다는 점이 있다. 
* 또한 지폐에 약간의 낙서가 있어서 지폐교환기가 약간 수정된 지폐를 인식 못하면 문제가 발생한다. 
* 이처럼 기존의 이미지와 기존의 이미지에서 약간 수정된 이미지가 같아야 하는 경우가 있다. 


## 목표
* DHash 구현해보기 (Java)
* Image를 업로드 및 판별 할 수 있는 서버 만들기 (JSP, Spring)


## DHash 구상도
1. 그레이 스케일 이미지.
- 이미지를 그레이 스케일링하여 각 픽셀 값을 광도 값으로 줄입니다. 
- 예를 들어, 흰색 픽셀 (255, 255, 255)은 255의 강도 값으로 감소되고 검은 픽셀 (0, 0, 0)은 0의 강도 값으로 감소됩니다.

```
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

```



2. 이미지를 공통 크기로 축소합니다.
- 이미지를 일반적인 기본 크기 (예 : 9x8 픽셀)로 축소하면 너비가 높이보다 1px 커집니다 
- 이는 또한 이미지의 크기를 조정하거나 늘리더라도 해시 값에 영향을주지 않으며 모든 이미지가 공통 크기로 정규화됨을 의미합니다.

```
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
```

3. 인접한 픽셀을 비교합니다.
- 앞의 두 단계 후에 강도 값을 포함하는 목록이 남은 다음 각 강도 값을 각 행의 인접 값과 비교하여 이진 값의 배열을 얻습니다.

```
//인접한 픽셀 비교 
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
```
4. 차이를 비트로 변환합니다.

- 해시를 저장하고 사용하기 쉽도록 16 진수 문자열로 변환합니다. True 값은 1의 이진 값을 가지며 False 값은 0 중 하나를가집니다.

```
//차이를 비트로 변환 (16진수로) 
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

		for(int i=0; i<k;i++){
			diff[i]=0;
		}

```

## 시나리오

![image](https://user-images.githubusercontent.com/15063135/47767883-fe49c080-dd18-11e8-84d6-f871e913f7bc.png)

![image](https://user-images.githubusercontent.com/15063135/47767963-4ec11e00-dd19-11e8-914b-c4993f275578.png)


* 웹페이지는 중복된 이미지가 없는 이미지들로 저장되어 있다.
* 우선적으로 웹 페이지에 로그인을 한 후 자신의 이미지를 등록하는 과정을 거친다. 
* 이 때 서버에서 DB에 저장된 기존의 이미지들의 해시값을 불러와 새롭게 등록 될 이미지의 해시값을 비교한다. 
* 기존의 이미지와 등록할 이미지(수정된이미지)의 유사도가 80%이상이면 이미지 등록을 거절한다. 


### 시스템 구성도

![image](https://user-images.githubusercontent.com/15063135/47768004-829c4380-dd19-11e8-852a-3f484b9819ad.png)



## 결과
![image](https://user-images.githubusercontent.com/15063135/47768378-3eaa3e00-dd1b-11e8-811f-b86035427bbc.png)

## 시연

![image](https://user-images.githubusercontent.com/15063135/47768408-60a3c080-dd1b-11e8-9bb9-1e60a09fb9bf.png)

- 이미지로 검색하는 기능은 자신이 가지고 있는 이미지를 업로드 통해 유사한 이미지를 찾는 기능이다. 

![image](https://user-images.githubusercontent.com/15063135/47768412-67cace80-dd1b-11e8-8993-ddbd609b7874.png)

- 여기서 자신이 가지고 있는 이미지를 업로드 한다.

![image](https://user-images.githubusercontent.com/15063135/47768416-6a2d2880-dd1b-11e8-9a57-762d6d4f5a10.png)


- 자신이 찾고자 하는 이미지를 전송 버튼 클릭을 통해 원하는 결과를 얻을 수 있다.


![image](https://user-images.githubusercontent.com/15063135/47768424-6dc0af80-dd1b-11e8-91c8-e916913f90fc.png)



- 자신이 찾고자 하는 유사한 이미지를 검색한 결과이다. 
- 현재 서버에 저장되어 데이터베이스에서 Dhash값 비교 분석을 통해 매칭률이 70% 이상이 된 결과물이다.
- 이로서 사용자는 자신이 원하는 비슷한 이미지를 검색 할 수 있다.


![image](https://user-images.githubusercontent.com/15063135/47768428-72856380-dd1b-11e8-9b3b-82aca5d59cb2.png)




- 다음은 ImageShare 사이트에 이미지를 업로드 하는 과정이다. 
- 이때 유의해야 할 점은 업로드 할 때 이미 사이트에 비슷한 이미지가 있으면 업로드가 안된다. 
- 즉, 서버에서 데이터베이스 조회를 통해 업로드 하는 이미지의 Dhash 값과 기존에 데이터베이스에 존재하는 Dhash값이 80%이상의 매칭률을 보이면 업로드 거절이 된다.


![image](https://user-images.githubusercontent.com/15063135/47768432-74e7bd80-dd1b-11e8-80bd-ce20d7e9a813.png)


- 다음은 업로드 실패한 결과이다. 사용자가 자신의 이미지를 업로드 요청을 하였으나, 이미 웹사이트에 비슷한 이미지가 존재한다. 즉 Dhash 분석을 통해 이미지 업로드가 실패된 경우이다.

![image](https://user-images.githubusercontent.com/15063135/47768434-76b18100-dd1b-11e8-8e01-f6a772d56b01.png)

- 자세한 정보를 확인 해보면 업로드 결과가 나타난다. 현재 업로드한 Dhash값, 이미 존재하는 이미지의 업로드 Dhash값 매칭률이 87.5%이다. 따라서 매칭률이 80%이상임으로 업로드 요청이 실패한다.


![image](https://user-images.githubusercontent.com/15063135/47768440-7913db00-dd1b-11e8-9c01-488fa84b4dd2.png)



- 다음은 웹사이트에 존재하는 이미지를 볼 수 있는 기능이다. 데이터베이스 조회를 통해  모든 이미지를 조회하여 보여준다.




[참고자료]
* https://blog.iconfinder.com/detecting-duplicate-images-using-python-cb240b05a3b6
