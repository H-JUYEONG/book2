package com.javaex.ex02;

import java.util.List;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BookDao bookDao = new BookDao();
		List<BookVo> bookList = bookDao.selectBookAll();

		while (true) {

			System.out.print("키워드를 입력하세요: ");
			String keyword = sc.nextLine();
			boolean found = false;

			for (int i = 0; i < bookList.size(); i++) {
				String title = bookList.get(i).getTitle();
				String pubs = bookList.get(i).getTitle();
				String authorName = bookList.get(i).getTitle();
				
				if (title.contains(keyword) || ) {
					System.out.print(bookList.get(i).getBookId() + ". ");
					System.out.print(bookList.get(i).getTitle() + "\t");
					System.out.print(bookList.get(i).getPubs() + "\t");
					System.out.print(bookList.get(i).getPubDate() + "\t");
					System.out.println(bookList.get(i).getAuthorId());
					found = true;
				}
			}
			
			if (found) {
				System.out.println("");
				break; // 검색된 결과가 있으면 while 루프를 빠져나감
			} else {
				System.out.println("[다시 입력해주세요.]");
			}

			if (keyword.equals("q")) {
				break;
			}

		}

		// 추가
		// int add = bookDao.insertBook("해리포터", "문학수첩", "2019-11-19", 2);

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
//		List<BookVo> bookList = bookDao.selectBookAll();
//		for (int i = 0; i < bookList.size(); i++) {
//			System.out.print(bookList.get(i).getBookId() + ". ");
//			System.out.print(bookList.get(i).getTitle() + "\t");
//			System.out.print(bookList.get(i).getPubs() + "\t");
//			System.out.print(bookList.get(i).getPubDate() + "\t");
//			System.out.println(bookList.get(i).getAuthorId());
//		}

	}

}
