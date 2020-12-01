package com.example.webtoken.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webtoken.model.*;;

public interface UserRepositoryJPA extends JpaRepository<User, Integer>{
	User findByUserName(String username);
}
