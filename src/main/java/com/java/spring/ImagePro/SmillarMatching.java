package com.java.spring.ImagePro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.spring.dao.IImageDao;
import com.java.spring.dto.ImageDto;

public class SmillarMatching {

	public ArrayList<String> Result(ImageDto aa, String b) {

		ArrayList<String> list = new ArrayList<String>();

		int count = 0;

		for (int i = 0; i < b.length(); i++) {
			if (aa.getImage_hash().charAt(i) == b.charAt(i))
				count++;

			if (count > 3) {

				list.add(aa.getImage_hash());

				break;

			}

		}

		return list;

	}

}
