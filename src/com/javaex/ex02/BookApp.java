package com.javaex.ex02;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {

		BookDao bookDao = new BookDao();
 
		// 추가
		// bookDao.insertBook("해리포터", "문학수첩", "2019-11-19", 2);

		// 삭제
		// bookDao.deleteBook(12);

		// 수정
		// bookDao.updateBook("순정만화", 6);

		// 조회1
//		BookVo bookVo = bookDao.selectBookOne(6);
//		System.out.print(bookVo.getBookId() + ". ");
//		System.out.print(bookVo.getTitle() + "\t");
//		System.out.print(bookVo.getPubs() + "\t");
//		System.out.print(bookVo.getPubDate() + "\t");
//		System.out.print(bookVo.getAuthorId());

		// 전체 조회
		List<BookVo> bookList = bookDao.selectBookAll();
		for (int i = 0; i < bookList.size(); i++) {
			System.out.print(bookList.get(i).getBookId() + ". ");
			System.out.print(bookList.get(i).getTitle() + "\t");
			System.out.print(bookList.get(i).getPubs() + "\t");
			System.out.print(bookList.get(i).getPubDate() + "\t");
			System.out.println(bookList.get(i).getAuthorId());
		}

	}

}
