package com.project.demo.com.project.demo.dao;

import com.project.demo.com.project.demo.entity.User;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


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
       try {
           User tempUser = (User) theQuery.getSingleResult();
           return tempUser;
       }
       catch (Exception exc){

       }
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

    @Override
    public void updateUser(User user,String indexEmail) {

        Query theQuery = entityManager.createQuery("UPDATE User SET firstName = :name, lastName = :lastname, email = :email, company = :company where email = :indexemail ");
        theQuery.setParameter("name", user.getFirstName());
        theQuery.setParameter("lastname", user.getLastName());
        theQuery.setParameter("email", user.getEmail());
        theQuery.setParameter("company", user.getCompany());
        theQuery.setParameter("indexemail", indexEmail);
        theQuery.executeUpdate();

    }

    @Override
    public void updatePassword(User user,String indexEmail) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Query theQuery = entityManager.createQuery("UPDATE User SET password = :pass where email = :indexemail");
        theQuery.setParameter("pass", user.getPassword());
        theQuery.setParameter("indexemail", indexEmail);
        theQuery.executeUpdate();

    }
}
