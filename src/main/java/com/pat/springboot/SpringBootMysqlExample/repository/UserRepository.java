package com.pat.springboot.SpringBootMysqlExample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pat.springboot.SpringBootMysqlExample.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByEmail(String email);
}
