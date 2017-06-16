package com.clearbases.codehouse.dao;

import com.clearbases.codehouse.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by diego on 6/15/17.
 */
@Repository
public class UserDAO implements UserDetailsService {

    @PersistenceContext
    private EntityManager manager;

    public UserDetails loadUserByUsername(String email) {
        List<User> users = manager.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();

        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User " + email + " was not found");
        }

        return users.get(0);
    }

}
