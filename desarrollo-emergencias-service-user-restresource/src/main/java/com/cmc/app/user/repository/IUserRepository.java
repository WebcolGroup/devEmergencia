package com.cmc.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cmc.app.commons.user.entity.User;

@RepositoryRestResource(path  ="user")
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {

}
