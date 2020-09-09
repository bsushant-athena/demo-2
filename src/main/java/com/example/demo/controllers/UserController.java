package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity < List < User > > findAllUsers() {
        List<User> users = new ArrayList<>();
        Iterable<User> userIterable = userService.findAll();
        Iterator<User> userIterator = userIterable.iterator ();
        while(userIterator.hasNext ()){
            users.add ( userIterator.next () );
        }
        return users.isEmpty () ? new ResponseEntity < List < User> >(users, HttpStatus.NO_CONTENT)
                : new ResponseEntity < List < User> >(users, HttpStatus.OK);
    }

}
