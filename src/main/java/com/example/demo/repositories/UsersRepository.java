package com.example.demo.repositories;

import com.example.demo.entity.Users;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository  extends BaseRepository< Users >{
    List <Users> findByEmailAndDeleted(String email,int deleted);
}
