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

import com.cmc.app.book.entity.Author;
import com.cmc.app.book.service.AuthorService;

@RestController
@RequestMapping("authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/list")
	public List<Author> findAll(Author authors) {
		return authorService.findAll(authors);
	}

	@GetMapping("/author/{authorId}")
	public ResponseEntity<Author> getUserbyUserId(@PathVariable("authorId") Long authorId) {
		Author authors = authorService.findById(authorId);
		if (authors == null) {
			return ResponseEntity.notFound().build();
		}
		Author author = authorService.findById(authorId);
		return ResponseEntity.ok(author);
	}

	@PostMapping("/save")
	public Author save(@RequestBody Author authors) {
		return authorService.save(authors);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		authorService.delete(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> edit(@RequestBody Author authors, @PathVariable Long id) {

		Author authorUp = authorService.findById(id);

		if (authorUp == null) {
			return ResponseEntity.notFound().build();
		}

		authorUp.setName(authors.getName());
		authorUp.setMobilPhone(authors.getMobilPhone());

		authorService.save(authorUp);
		return ResponseEntity.ok(authors);

	}
}
