package com.thn.restpetstore.controller;

import com.thn.restpetstore.dao.InMemoryUserDao;
import com.thn.restpetstore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private InMemoryUserDao inMemoryUserDao;

    @PostMapping
    public ResponseEntity<User> saveNewUser(@RequestBody User newUser) {
        User user = inMemoryUserDao.saveUser(newUser);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = inMemoryUserDao.getUserByUsername(username);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<User> deleteUserByUsername(@PathVariable String username){
        Optional<User> user = inMemoryUserDao.deleteUserByUsername(username);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
