package com.project.demo.com.project.demo.service;

import com.project.demo.com.project.demo.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {

    void save (User user);
    User findByUserName(String userName);
    boolean isEmailUnique(String email);

}
