package com.cmc.app.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmc.app.book.dao.IGenderDao;

import com.cmc.app.book.entity.Gender;

@Service
public class GenderService {

	@Autowired
	private IGenderDao genderDao;

	public List<Gender> findAll(Gender genders) {
		return (List<Gender>) genderDao.findAll();
	}

	@Transactional(readOnly = true)
	public Gender findById(Long id) {
		return genderDao.findById(id).orElse(null);
	}

	public Gender save(Gender genders) {
		return genderDao.save(genders);
	}

	public void delete(Long id) {
		genderDao.deleteById(id);
	}
}
