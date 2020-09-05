package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity < ? > findUserById(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        return user != null ?
                new ResponseEntity <> (user, HttpStatus.OK) :
                new ResponseEntity <> ( HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity < ? > createUser( @RequestBody User user) {
        return new ResponseEntity < User > (userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public Page< ? > findAllUsers(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @GetMapping("/sortedusers")
    public Page< ? > findAllUsersSortedByName() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("name"));
        return userService.findAll(pageable);
    }

    @GetMapping("/filteredusers")
    public Iterable< ? > getUsersByQuerydslPredicate(@QuerydslPredicate (root = User.class) Predicate predicate) {
        return userService.findAll(predicate);
    }
}
