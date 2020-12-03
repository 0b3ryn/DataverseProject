package com.project.demo.com.project.demo.service;

import com.project.demo.com.project.demo.dao.UserRepository;
import com.project.demo.com.project.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl( UserRepository userRepository){
         this.userRepository = userRepository;
    }
    @Override
    @Transactional
    public void save(User user) {

        userRepository.save(user);
    }

    @Override
    public User findByName(String name) {
        return null;
    }
}
