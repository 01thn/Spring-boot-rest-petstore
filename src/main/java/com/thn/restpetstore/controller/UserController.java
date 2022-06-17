package com.thn.restpetstore.controller;

import com.thn.restpetstore.entity.User;
import com.thn.restpetstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User newUser) {
        User user = userService.save(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> find(@PathVariable String username) {
        Optional<User> user = userService.findUserByUsername(username);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> delete(@PathVariable String username) {
        userService.deleteByUsername(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> update(@PathVariable String username,
                                       @RequestBody User newUser) {
        Optional<User> user = userService.findUserByUsername(username);
        if (user.isPresent()) {
            newUser.setId(user.get().getId());
            User updUser = userService.save(newUser);
            return ResponseEntity.ok(updUser);
        }
        return ResponseEntity.badRequest().build();
    }
}
