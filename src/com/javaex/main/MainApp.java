package com.javaex.main;

import java.util.List;

import com.javaex.dao.AuthorDao;
import com.javaex.dao.BookDao;
import com.javaex.vo.AuthorVo;
import com.javaex.vo.BookVo;

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

		BookVo bVo = new BookVo("책이름", "출판사", "1990-09-09", 1);
		BookDao bDao = new BookDao();
		bDao.insertBook(bVo);

		List<BookVo> bookList = bDao.selectBookList();

		System.out.println(bookList.size() + "건 발견됨.");

		for (int i = 0; i < bookList.size(); i++) {
			bVo = bookList.get(i);
			System.out.println(bVo.getBookId() + " " + bVo.getTitle() + " " + 
							   bVo.getPubs() + " " + bVo.getPubDate() + " " + 
							   bVo.getAuthorId() + " " + bVo.getAuthorName() + " " + bVo.getAuthorDesc());
		}

		
	}
}
