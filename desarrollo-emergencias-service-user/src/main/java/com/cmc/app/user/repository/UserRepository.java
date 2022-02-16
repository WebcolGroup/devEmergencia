package com.cmc.app.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cmc.app.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
