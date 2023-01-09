package com.findpet.Services;


import com.findpet.Entity.User;
import com.findpet.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(Integer owner) {
        return userRepository.findById(owner).get();
    }
}
