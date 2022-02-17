package com.cmc.app.book.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmc.app.book.dao.IAuthorDao;
import com.cmc.app.book.entity.Author;


@Service
public class AuthorService {

	@Autowired
	private IAuthorDao authorDao;

	public List<Author> findAll(Author author) {
		return (List<Author>) authorDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Author findById(Long id) {
		return authorDao.findById(id).orElse(null);
	}
	
	public Author save(Author users) {
		return authorDao.save(users);
	}

	public void delete(Long id) {
		authorDao.deleteById(id);
	}

}
