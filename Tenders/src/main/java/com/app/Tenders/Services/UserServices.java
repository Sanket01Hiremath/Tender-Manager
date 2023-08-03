package com.app.Tenders.Services;

import com.app.Tenders.Entity.User;
import com.app.Tenders.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private userRepo urepo;

    public User newUser(User u){
        return urepo.save(u);
    }

    public User login(String username,String password){
        User user=urepo.findByusername(username);
        return user;
    }
}
