package com.cmc.app.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmc.app.book.dao.IBookDao;

import com.cmc.app.book.entity.Book;

@Service
public class BookService {

	@Autowired
	private IBookDao bookDao;

	public List<Book> findAll(Book books) {
		return (List<Book>) bookDao.findAll();
	}

	@Transactional(readOnly = true)
	public Book findById(Long id) {
		return bookDao.findById(id).orElse(null);
	}

	public Book save(Book books) {
		return bookDao.save(books);
	}

	public void delete(Long id) {
		bookDao.deleteById(id);
	}

}
