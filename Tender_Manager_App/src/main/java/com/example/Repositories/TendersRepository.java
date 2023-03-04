package com.example.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Tenders;
import com.example.entities.Users;


@Repository
public interface TendersRepository extends JpaRepository<Tenders, Integer>{
	public Tenders findByname(String name);
	public List<Tenders> findByVendor(Users v);
}
