package com.project.demo.com.project.demo.dao;

import com.project.demo.com.project.demo.entity.User;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
    }

    @Override
    public User findByUserName(String userName) {

        Query theQuery = entityManager.createQuery("from User where email= :username");
        theQuery.setParameter("username", userName);
        User tempUser = (User) theQuery.getSingleResult();
        return tempUser;
    }

    @Override
    public boolean isEmailUnique(String email) {

        Query theQuery = entityManager.createQuery("from User where email= :inputEmail");
        theQuery.setParameter("inputEmail", email);
        List<User> tempUser = theQuery.getResultList();

        if(tempUser.size()>0){
            return false;
        }

        return true;
    }
}
