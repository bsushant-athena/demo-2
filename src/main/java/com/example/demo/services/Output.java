package com.example.demo.services;

import com.example.demo.entity.Users;
import com.example.demo.repositories.TeamsRepository;
import com.example.demo.repositories.UsersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Output {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TeamsRepository teamsRepository;

    @Transactional
    public List <Users> firstQuery(String email){
        List <Users> usersList = usersRepository.findByEmailAndDeleted ( email, 0 );
        return usersList;
    }
}
