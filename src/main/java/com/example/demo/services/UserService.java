package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger( UserService.class);

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User createUser ( User user ) {
        return userRepository.save ( user );
    }

    public Iterable< User > findAll () {
        return userRepository.findAll ();
    }

    public User getUser ( long id ) {
        Optional<User> user = userRepository.findById ( id );
        return user.isPresent () ? user.get() : null;
    }
}
