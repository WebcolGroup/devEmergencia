package com.cmc.app.book.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cmc.app.book.entity.Author;

@Repository
public interface IAuthorDao extends PagingAndSortingRepository<Author, Long> {

}
