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

import com.cmc.app.book.entity.Gender;

import com.cmc.app.book.service.GenderService;

@RestController
@RequestMapping("genders")
public class GenderController {

	@Autowired
	private GenderService genderService;

	@GetMapping("/list")
	public List<Gender> findAll(Gender genders) {
		return genderService.findAll(genders);
	}

	@GetMapping("/genders/{genderId}")
	public ResponseEntity<Gender> getUserbyUserId(@PathVariable("genderId") Long genderId) {
		Gender genders = genderService.findById(genderId);
		if (genders == null) {
			return ResponseEntity.notFound().build();
		}
		Gender gender = genderService.findById(genderId);
		return ResponseEntity.ok(gender);
	}

	@PostMapping("/save")
	public Gender save(@RequestBody Gender genders) {
		return genderService.save(genders);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		genderService.delete(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> edit(@RequestBody Gender genders, @PathVariable Long id) {

		Gender genderUp = genderService.findById(id);

		if (genderUp == null) {
			return ResponseEntity.notFound().build();
		}

		genderUp.setGenderName(genders.getGenderName());

		genderService.save(genderUp);
		return ResponseEntity.ok(genders);

	}

}
