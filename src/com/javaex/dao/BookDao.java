package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.AuthorVo;
import com.javaex.vo.BookVo;

public class BookDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null; // Select 할 때만 필요함.

	public void insertBook(BookVo bVo) {
		// 0. import java.sql.*;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "INSERT INTO book VALUES (seq_book_id.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getPubs());
			pstmt.setString(3, bVo.getPubDate());
			
			if(bVo.getAuthorId() == null)
				pstmt.setNull(4, Types.INTEGER);
			else
				pstmt.setInt(4, bVo.getAuthorId());
			
			pstmt.executeUpdate();

			// 4.결과처리

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				/*
				 * if (rs != null) { rs.close(); }
				 */
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
	}

	public List<BookVo> selectBookList() {
		List<BookVo> bookList = new ArrayList<>();
		BookVo bVo;
		AuthorVo aVo;
		// 0. import java.sql.*;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "SELECT b.book_id, b.title, b.pubs, to_char(b.pub_date, 'YY/MM/DD') pub_date,"
					+ " b.author_id, a.author_name, a.author_desc " + 
					" FROM book b, author a " + 
					" WHERE b.author_id = a.author_id" + 
					" ORDER BY b.book_id";
			pstmt = conn.prepareStatement(query);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			
			// 4.결과처리
			while(rs.next()) {
				bVo = new BookVo();
				aVo = new AuthorVo();
				
				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				
				bVo.setBookId(bookId);
				bVo.setTitle(title);
				bVo.setPubs(pubs);
				bVo.setPubDate(pubDate);
				bVo.setAuthorId(authorId);
				aVo.setAuthorName(authorName);
				aVo.setAuthorDesc(authorDesc);
				bVo.setAuthor(aVo);
				
				bookList.add(bVo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
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

		return bookList;
	}

}
