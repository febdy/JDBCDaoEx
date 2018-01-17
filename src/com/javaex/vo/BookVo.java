package com.javaex.vo;

public class BookVo {
	private int bookId;
	private String title;
	private String pubs;
	private String pubDate;
	private int authorId;
	private String authorName;
	private String authorDesc;

	public BookVo() {
	}

	public BookVo(String title) {
		this.title = title;
	}

	public BookVo(String title, int authorId) {
		this.title = title;
		this.authorId = authorId;
	}

	public BookVo(String title, String pubs, String pub_date, int authorId) {
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pub_date;
		this.authorId = authorId;
	}

	public BookVo(int bookId, String title, String pubs, String pub_date, int authorId, String authorName,
			String authorDesc) {
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pub_date;
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pub_date) {
		this.pubDate = pub_date;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorDesc() {
		return authorDesc;
	}

	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}

	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pubDate=" + pubDate
				+ ", authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}

}
