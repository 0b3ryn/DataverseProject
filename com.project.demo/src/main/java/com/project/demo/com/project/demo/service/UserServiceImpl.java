package com.project.demo.com.project.demo.service;

import com.project.demo.com.project.demo.dao.UserRepository;
import com.project.demo.com.project.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }



    @Override
    public boolean isEmailUnique(String email) {
        return userRepository.isEmailUnique(email);
    }

    @Override
    @Transactional
    public void updateUser(User user, String indexEmail) {
        userRepository.updateUser(user,indexEmail);
    }


    @Override
    @Transactional
    public void updatePassword(User user, String indexEmail) {
        userRepository.updatePassword(user,indexEmail);
    }
}
