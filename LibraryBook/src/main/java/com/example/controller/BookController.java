package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService service;

	@PostMapping("/save")
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createBook(book));
	}
	
	@GetMapping("/{isbn}")
	public ResponseEntity<Optional<Book>> getBook(@PathVariable int isbn){
		return ResponseEntity.status(HttpStatus.OK).body(service.getBookById(isbn));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Book>> getBooks(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllBooks());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> update(@RequestBody Book book,@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(service.updateBook(book, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		service.deleteBook(id);
		return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully.."+id);
	}
	
}
