package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith ( MockitoExtension.class )
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void test_01_shouldReturnValidUser ( ) {
        User dummyUser = new User();
        dummyUser.setId ( 1 );
        dummyUser.setEmail ( "bob@gmail.com" );
        dummyUser.setName ( "bob" );

        when(userRepository.findById ( 1L )).thenReturn( Optional.of(dummyUser));

        assertEquals(userService.getUser ( 1L ),dummyUser);
    }
}