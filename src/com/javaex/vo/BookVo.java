package com.javaex.vo;

public class BookVo {
	private int bookId;
	private String title;
	private String pubs;
	private String pubDate;
	private Integer authorId;
	private AuthorVo author;

	public BookVo() {
	}

	public BookVo(String title) {
		this.title = title;
	}

	public BookVo(String title, int authorId) {
		this.title = title;
		this.authorId = authorId;
	}

	public BookVo(String title, String pubs, int authorId) {
		this.title = title;
		this.pubs = pubs;
		this.authorId = authorId;
	}
	
	public BookVo(String title, String pubs, String pub_date, int authorId) {
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pub_date;
		this.authorId = authorId;
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

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public void setAuthor(AuthorVo author) {
		this.author = author;
	}

	public String getAuthorName() {
		return author.getAuthorName();
	}

	public String getAuthorDesc() {
		return author.getAuthorDesc();
	}

	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pubDate=" + pubDate
				+ ", authorId=" + authorId + "]";
	}

}
