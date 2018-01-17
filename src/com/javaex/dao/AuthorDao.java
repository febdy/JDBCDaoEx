package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.AuthorVo;

public class AuthorDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null; // Select 할 때만 필요함.

	public void insertAuthor(AuthorVo aVo) {
		// 0. import java.sql.*;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "INSERT INTO author VALUES (seq_author_id.nextval, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, aVo.getAuthorName());
			pstmt.setString(2, aVo.getAuthorDesc()); // query문의 ?부분 채우기
			int cnt = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(cnt + "건 저장 완료");

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

	public List<AuthorVo> selectAuthorList() {
		List<AuthorVo> authorList = new ArrayList<>();
		AuthorVo aVo;
		// 0. import java.sql.*;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "SELECT author_id, author_name, author_desc " +
						   " FROM author" +
						   " ORDER BY author_id";
			pstmt = conn.prepareStatement(query);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();

			while (rs.next()) {
				aVo = new AuthorVo();
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				aVo.setAuthorId(authorId);
				aVo.setAuthorName(authorName);
				aVo.setAuthorDesc(authorDesc);
				authorList.add(aVo);
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

		return authorList;
	}

}
