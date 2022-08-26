package com.thn.restpetstore.controller;

import com.thn.restpetstore.dto.UserDTO;
import com.thn.restpetstore.entity.User;
import com.thn.restpetstore.mapper.UserMapper;
import com.thn.restpetstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody User newUser) {
        User user = userService.save(newUser);
        UserDTO userDto = userMapper.toUserDto(user);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
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
