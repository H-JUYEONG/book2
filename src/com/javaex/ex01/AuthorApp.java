package com.javaex.ex01;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {

		AuthorDao authorDao = new AuthorDao();

		// 추가
		// authorDao.insertAuthor("차은우", "멋쟁이");

		// 삭제
		// authorDao.deleteAuthor(13);

		// 수정
		// authorDao.updateAuthor("변백현", "가수", 2);

		// 조회1
//		AuthorVo authorVo = authorDao.selectAuthorOne(6);
//		System.out.print(authorVo.getAuthorId() + ". ");
//		System.out.print(authorVo.getAuthorName() + "\t");
//		System.out.print(authorVo.getAuthorDesc() + "\t");

		// 전체 조회
		List<AuthorVo> authorList = authorDao.selectAuthorAll(); // new 리스트 만들어서 주소만 전달한다.
		for (int i = 0; i < authorList.size(); i++) {
			System.out.print(authorList.get(i).getAuthorId() + ". ");
			System.out.print(authorList.get(i).getAuthorName() + "\t");
			System.out.println(authorList.get(i).getAuthorDesc());
		}
	}

}
