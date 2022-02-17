package com.cmc.app.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmc.app.book.entity.Gender;

@Repository
public interface IGenderDao extends JpaRepository<Gender, Long> {

}
