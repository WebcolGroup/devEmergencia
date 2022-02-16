package com.cmc.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cmc.app.user.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
