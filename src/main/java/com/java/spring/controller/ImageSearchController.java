package com.java.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.spring.CommonUtils;
import com.java.spring.ImagePro.MatchingService;
import com.java.spring.ImagePro.SmillarMatching;
import com.java.spring.dao.IImageDao;
import com.java.spring.dto.ImageDto;

@Controller
public class ImageSearchController {

	// private ArrayList<ImageDto> list =new ArrayList<ImageDto>();
	//
	// public ArrayList<ImageDto> getList() {
	// return list;
	// }
	//
	// public void setList(ArrayList<ImageDto> list) {
	// this.list = list;
	// }

	@RequestMapping("/image_search")
	public String image_search() {
		return "image_search";
	}

	@RequestMapping("/image_search_result")
	public String image_search_result() {

		return "image_search_result";
	}

	@RequestMapping("/image_search_result1")
	public String image_search_result1() {
		// 찾는 이미지가 없을 때
		return "image_search_result1";
	}

	@Resource(name = "sqlSession_2")
	@Autowired
	private SqlSession sql;

	@RequestMapping(value = "/image_search1", method = { RequestMethod.POST, RequestMethod.GET })
	public String image_search1(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		String name = file.getOriginalFilename();
		SmillarMatching sc = new SmillarMatching();

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

		IImageDao dao = sql.getMapper(IImageDao.class);
		ArrayList<ImageDto> arr = dao.imgSearch();
		System.out.println("arr사이즈" + arr.size());
		ArrayList<String> search = new ArrayList<String>();
		ArrayList<String> search1 = new ArrayList<String>();

		for (ImageDto aa : arr) {

			search = sc.Result(aa, hash_val);
			if (search.size() != 0) {
				for (int i = 0; i < search.size(); i++)
					search1.add(search.get(i));
			}

		}

		System.out.println("size" + search1.size());

		if (search1.size() == 0) { // 비슷한 이미지가 없다면

			uploadFile.delete();

			// mv.addObject("name",SmillarMatching. );

			return "image_search_result2"; // 실패 페이지로

		} else // 있다면
		{
			System.out.println("비슷한 이미지가 있습니다");
			uploadFile.delete();

			List<ImageDto> list = new ArrayList<ImageDto>();
			for (int i = 0; i < search1.size(); i++) {

				list.addAll(dao.ImageSearch(search1.get(i)));

			}

			model.addAttribute("list", list);

			return "image_search_result";// 성공했음
		}

	}

}
