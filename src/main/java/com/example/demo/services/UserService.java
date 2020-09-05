package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;
import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger( UserService.class);

    @Autowired
    UserRepository userRepository;

    public Page< User > findAll ( Pageable pageable ) {
        return userRepository.findAll ( pageable );
    }

    @Transactional
    public User createUser ( User user ) {
        return userRepository.save ( user );
    }

    public Iterable< User > findAll ( Predicate predicate ) {
        return userRepository.findAll ( predicate );
    }

    public User getUser ( long id ) {
        return userRepository.findById ( id ).get ();
    }
}
