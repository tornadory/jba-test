package com.test.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.jba.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);

}
