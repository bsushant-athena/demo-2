package com.example.demo.repositories;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User>{
    User findByName(String name);

    @Query("select u from User u where u.email = :email")
    User loadByEmail( @Param  ( "email" ) String email);
}