package com.java.spring.Command;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.SavepointManager;
import org.springframework.web.multipart.MultipartFile;

import com.java.spring.CommonUtils;
import com.java.spring.ImagePro.Matching;
import com.java.spring.ImagePro.MatchingService;
import com.java.spring.ImagePro.SmillarMatching;
import com.java.spring.dao.IImageDao;
import com.java.spring.dto.ImageDto;

@Controller
public class FileCommand   {
	
	
//	private String image_arr[];
//
//	public String[] getImage_arr() {
//		return image_arr;
//	}
//
//	public void setImage_arr(String[] image_arr) {
//		this.image_arr = image_arr;
//	}
//
//	@Resource(name ="sqlSession_2")
//	@Autowired
//	private SqlSession sql;
//
//	public String file(MultipartFile file) {
//		String name = file.getOriginalFilename();
//		Boolean check = false;
//		if (!file.isEmpty()) {
//			try {
//
//				String originalFileExtension = name.substring(name.lastIndexOf("."));
//				String storedFileName = CommonUtils.getRandomString() + originalFileExtension;
//				byte[] bytes = file.getBytes();
//				File uploadFile = new File(
//						"C:\\Users\\Sangjin\\workspace\\Spring_boot_test\\src\\main\\webapp\\resources\\image\\"
//								+ storedFileName);
//				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadFile));
//				stream.write(bytes);
//				stream.close();
//
//				MatchingService ms = new MatchingService(); // 기존 파일들과 매칭 시작
//				String hash_val = ms.Matching(uploadFile);
//				System.out.println(hash_val);
//				IImageDao dao = sql.getMapper(IImageDao.class);
//			
//
//				ArrayList<ImageDto> arr = dao.imgDao();
//				for (ImageDto aa : arr) {
//					if (check = Matching.Result(aa, hash_val)) {
//						break;
//					}
//				}
//
//				if (check == true) { // 비슷한 이미지가 있다면
//					uploadFile.delete();
//					return "uploadSuccess"; // 우선은 홈으로
//
//				} else // 없다면
//				{
//					dao.imageUpload(name, hash_val, storedFileName);
//					// 완료 후 홈으로
//
//					return "uploadSuccess";// 성공했음
//				}
//
//			} catch (Exception e) {
//				return "redirect:home";
//			}
//		} else {
//			return "redirect:home";
//		}
//	}
//
//	
	

}
