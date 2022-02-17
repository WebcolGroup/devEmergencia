package com.cmc.app.book.restresource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cmc.app.book.restresource.entity.Author;

@RepositoryRestResource(path  ="author")
public interface IAuthorRepository extends JpaRepository<Author, Long> {

}
