package com.bezkoder.spring.hibernate.onetomany.Services;

import com.bezkoder.spring.hibernate.onetomany.model.User;
import com.bezkoder.spring.hibernate.onetomany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser (User user){
        return userRepository.save(user);
    }

    public User findUserById( long id){
        return userRepository.findById(id).orElse(null);
    }


}
