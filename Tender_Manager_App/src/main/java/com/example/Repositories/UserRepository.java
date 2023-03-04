package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	public Users findAllByusername(String username);
}
