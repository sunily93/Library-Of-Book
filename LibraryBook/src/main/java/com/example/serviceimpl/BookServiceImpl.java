package com.example.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.service.BookService;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository repository;
	
	@Override
	public Book createBook(Book book) {
		return repository.save(book);
	}

	@Override
	public Optional<Book> getBookById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	@Override
	public Book updateBook(Book book, int id) {
		Optional<Book> findById = repository.findById(id);
		Book b=null;
		if(findById.isPresent()) {
			b=findById.get();
			b.setBookName(book.getBookName());
			b.setLanguage(book.getLanguage());
			b.setAuthor(book.getAuthor());
			b.setTitle(book.getTitle());
		}
		return repository.save(b);
	}

	@Override
	public void deleteBook(int id) {
		repository.deleteById(id);
		
	}

}
