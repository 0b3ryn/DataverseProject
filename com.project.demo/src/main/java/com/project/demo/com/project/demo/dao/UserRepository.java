package com.project.demo.com.project.demo.dao;

import com.project.demo.com.project.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository {


    void save (User user);
    User findByUserName(String email);
    boolean isEmailUnique(String email);
    void updateUser(User user, String indexEmail);
    void updatePassword(User user,String indexEmail);
}
