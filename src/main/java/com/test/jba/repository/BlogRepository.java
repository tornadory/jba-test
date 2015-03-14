package com.test.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.jba.entity.Blog;
import com.test.jba.entity.Role;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

}
