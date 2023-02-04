package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Book;

public interface BookService {
	
	Book createBook(Book book);
    Optional<Book> getBookById(int id);
	List<Book> getAllBooks();
	Book updateBook(Book book,int id);
	void deleteBook(int id);
}
