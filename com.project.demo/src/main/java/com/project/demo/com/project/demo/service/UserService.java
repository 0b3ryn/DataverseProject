package com.project.demo.com.project.demo.service;

import com.project.demo.com.project.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {

    void save (User user);
    User findByUserName(String userName);
    boolean isEmailUnique(String email);
    void updateUser(User user, String indexEmail);
    void updatePassword(User user,String indexEmail);

}
