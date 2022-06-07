package com.thn.restpetstore.dao;

import com.thn.restpetstore.entity.User;
import com.thn.restpetstore.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryUserDao {
    @Autowired
    UserStorage userStorage;

    public User saveUser(User newUser) {
        User user = null;
        if (!userStorage.userExists(newUser.getUsername())) {
            user = userStorage.saveUser(newUser);
        }
        return user;
    }

    public Optional<User> getUserByUsername(String username) {
        return userStorage.getUserByUsername(username);
    }

    public Optional<User> deleteUserByUsername(String username){
        return userStorage.deleteUserByUsername(username);
    }
}
