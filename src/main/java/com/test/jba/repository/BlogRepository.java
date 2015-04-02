package com.test.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.jba.entity.Blog;
import com.test.jba.entity.Role;
import com.test.jba.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

	List<Blog> findByUser(User user);
}
