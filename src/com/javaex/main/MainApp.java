package com.javaex.main;

import java.util.List;

import com.javaex.dao.AuthorDao;
import com.javaex.vo.AuthorVo;

public class MainApp {
	public static void main(String[] args) {

		AuthorVo aVo = new AuthorVo("작가이름");
		AuthorDao aDao = new AuthorDao();
		aDao.insertAuthor(aVo);

		List<AuthorVo> authorList = aDao.selectAuthorList();

		System.out.println(authorList.size() + "건 발견됨.");

		for (int i = 0; i < authorList.size(); i++) {
			aVo = authorList.get(i);
			System.out.println(aVo.getAuthorId() + " " + aVo.getAuthorName() + " " + aVo.getAuthorDesc());
		}

	}
}
