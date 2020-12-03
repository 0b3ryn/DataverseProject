package com.project.demo.com.project.demo.dao;

import com.project.demo.com.project.demo.entity.User;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private EntityManager entityManager;

    @Autowired
    public UserRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findByEmail(String email) {

        return null;
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
