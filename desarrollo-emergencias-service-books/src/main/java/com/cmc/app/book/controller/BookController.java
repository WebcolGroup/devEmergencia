package com.cmc.app.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.app.book.entity.Book;

import com.cmc.app.book.service.BookService;

@RestController
@RequestMapping("books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/list")
	public List<Book> findAll(Book books) {
		return bookService.findAll(books);
	}

	@GetMapping("/book/{booksId}")
	public ResponseEntity<Book> getUserbyUserId(@PathVariable("booksId") Long bookId) {
		Book books = bookService.findById(bookId);
		if (books == null) {
			return ResponseEntity.notFound().build();
		}
		Book book = bookService.findById(bookId);
		return ResponseEntity.ok(book);
	}

	@PostMapping("/save")
	public Book save(@RequestBody Book books) {
		return bookService.save(books);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		bookService.delete(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> edit(@RequestBody Book books, @PathVariable Long id) {

		Book bookUp = bookService.findById(id);

		if (bookUp == null) {
			return ResponseEntity.notFound().build();
		}

		bookUp.setName(books.getName());

		bookService.save(bookUp);
		return ResponseEntity.ok(books);

	}
}
