package com.cmc.app.user.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cmc.app.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Transactional
	@Modifying
	@Query("update User u set u.name = ?1, u.secondName = ?2 where u.id = ?3")
	void setUserInfoById(String name, String secondName, Long id);
}
