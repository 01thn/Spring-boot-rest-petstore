package com.thn.restpetstore.storage;

import com.thn.restpetstore.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserStorage {

    private List<User> users = new ArrayList<>();

    private static long counter = 1L;

    public User saveUser(User user) {
        user.setId(counter++);
        users.add(user);
        return user;
    }

    public boolean userExists(String username){
        return users
                .stream()
                .filter(user -> user.getUsername()
                        .equals(username)).count() > 0;
    }

    public Optional<User> getUserByUsername(String username){
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    public Optional<User> deleteUserByUsername(String username){
        Optional<User> userOptional = users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
        userOptional.ifPresent(user -> users.remove(user));
        return userOptional;
    }
}
