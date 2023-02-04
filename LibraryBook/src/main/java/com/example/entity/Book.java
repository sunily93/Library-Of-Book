package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int isbn;
	private String bookName;
	private String title;
	private String language;
	private String author;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(int isbn, String bookName, String title, String language, String author) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.title = title;
		this.language = language;
		this.author = author;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int bookId) {
		this.isbn = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}	
}
