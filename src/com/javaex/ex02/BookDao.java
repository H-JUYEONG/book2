package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	// 필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/book_db";
	private String id = "book";
	private String pw = "book";

	// 생성자

	// 메소드 gs

	// 메소드 일반
	private void getConnection() {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// 추가
	public int insertBook(String title, String pubs, String pubDate, int authorId) {

		int count = -1;

		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// *sql문 준비
			String query = "";
			query += " insert into book ";
			query += " values(null, ?, ?, ?, ?) ";

			// *바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, pubs);
			pstmt.setString(3, pubDate);
			pstmt.setInt(4, authorId);

			// *실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 등록되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		this.close();

		return count;
	}

	// 삭제
	public int deleteBook(int id) {

		int count = -1;
		
		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// *sql문 준비
			String query = "";
			query += " delete from book ";
			query += " where book_id = ? ";

			// *바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);

			// *실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 삭제되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		this.close();

		return count;
	}

	// 수정
	public int updateBook(String name, int id) {

		int count = -1;
		
		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// *sql문 준비
			String query = "";
			query += " update book ";
			query += " set title = ? ";
			query += " where book_id = ? ";

			// *바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, id);

			// *실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 업데이트 되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 

		this.close();

		return count;
	}

	// 조회1
	public BookVo selectBookOne(int id) {

		BookVo bookVo = null;
		
		this.getConnection();
		
		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문 준비(insert문을 자바의 문자열로 만든다.)
			String query = "";
			query += " select book_id, ";
			query += "		  title, ";
			query += "        pubs, ";
			query += "        pub_date, ";
			query += "        author_id ";
			query += " from book ";
			query += " where book_id = ? ";
			query += " order by book_id ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			rs.next();
			int bookId = rs.getInt("book_id");
			String title = rs.getString("title");
			String pubs = rs.getString("pubs");
			String pubDate = rs.getString("pub_date");
			int authorId = rs.getInt("author_id");

			bookVo = new BookVo(bookId, title, pubs, pubDate, authorId);

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		this.close();
		
		return bookVo;
	}

	// 전체 조회
	public List<BookVo> selectBookAll() {

		List<BookVo> bookList = new ArrayList<BookVo>();

		this.getConnection();
		
		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문 준비(insert문을 자바의 문자열로 만든다.)
			String query = "";
			query += " select book_id, ";
			query += "		  title, ";
			query += "        pubs, ";
			query += "        pub_date, ";
			query += "        author_id ";
			query += " from book ";
			query += " order by book_id ";

			// 바인딩
			pstmt = conn.prepareStatement(query);

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {
				int id = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				int authorId = rs.getInt("author_id");

				BookVo bookVo = new BookVo(id, title, pubs, pubDate, authorId);
				bookList.add(bookVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		this.close();
		
		return bookList;
	}

}