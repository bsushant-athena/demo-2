package com.example.demo.controllers;

import com.example.demo.entity.Users;
import com.example.demo.services.Output;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class DummyController {

    @Autowired
    Output output;

    @GetMapping
    public  ResponseEntity< List < Users > > getUsers( @RequestParam("email") String email ){
        List<Users> usersList = output.firstQuery (email);
        //System.out.println("list output="+usersList.toString());
        return new ResponseEntity <List<Users>> ( usersList, HttpStatus.OK );
    }
}
