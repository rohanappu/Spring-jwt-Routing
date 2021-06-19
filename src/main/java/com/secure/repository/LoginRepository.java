package com.secure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secure.dao.Login;

public interface LoginRepository extends JpaRepository<Login, String>{
	Login findByUsername(String username);

}
