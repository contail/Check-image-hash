package com.java.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.spring.CommonUtils;
import com.java.spring.ImagePro.Matching;
import com.java.spring.ImagePro.MatchingService;
import com.java.spring.dao.IImageDao;
import com.java.spring.dto.ImageDto;

@Controller
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	// 우선 이미지 업로드 요청이 들어오면

	@Resource(name = "sqlSession_2")
	@Autowired
	private SqlSession sql;

	@RequestMapping("/uploadSuccess")
	public String uploadSuccess() {
		return "uploadSuccess";
	}

	@RequestMapping(value ="/uploadFile", method = RequestMethod.POST)
	public String uploadFileHandler(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		String name = file.getOriginalFilename();
		 
		Boolean check = false;

		String originalFileExtension = name.substring(name.lastIndexOf("."));
		String storedFileName = CommonUtils.getRandomString() + originalFileExtension;
		byte[] bytes = file.getBytes();
		File uploadFile = new File(
				"C:\\Users\\Sangjin\\workspace\\Spring_boot_test\\src\\main\\webapp\\resources\\image\\"
						+ storedFileName);
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadFile));
		stream.write(bytes);
		stream.close();

		MatchingService ms = new MatchingService(); // 기존 파일들과 매칭 시작
		String hash_val = ms.Matching(uploadFile);
		System.out.println(hash_val);
		IImageDao dao = sql.getMapper(IImageDao.class);
	 
		ImageDto bb = null;
	 
		ArrayList<ImageDto> arr = dao.imgDao();
	 
		for (ImageDto aa : arr) {
			if (check = Matching.Result(aa, hash_val)) {
				bb=aa;
				break;
			}
		}
		
		//List<ImageDto> list1 ;
		

		if (check == true) { // 비슷한 이미지가 있다면
			uploadFile.delete();
			
			File uploadFile1 = new File(
					"C:\\tempImage\\"
							+ name);
			 stream = new BufferedOutputStream(new FileOutputStream(uploadFile1));
			stream.write(bytes);
			stream.close();
			
			
			String upload_path = "C:\\tempImage\\"
					+ name;
			
			
			
			model.addAttribute("uploadHash", hash_val);
			model.addAttribute("uploadPath", upload_path);
			model.addAttribute("origHash",bb.getImage_hash());
			model.addAttribute("origPath", bb.getnew_name());
			model.addAttribute("per", Matching.getPer());
		 
			 return "image_upload_fail"; // 우선은 홈으로

		} else // 없다면
		{
			dao.imageUpload(name, hash_val, storedFileName);
			return "uploadSuccess";// 성공했음

		}

	 

	}

}
