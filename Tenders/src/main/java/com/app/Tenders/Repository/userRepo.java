package com.app.Tenders.Repository;

import com.app.Tenders.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepo extends JpaRepository<User,Integer> {
   User findByusername(String username);
}

