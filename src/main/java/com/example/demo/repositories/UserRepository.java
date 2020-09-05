package com.example.demo.repositories;

import com.example.demo.entity.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository < User, Long>, QuerydslPredicateExecutor <User> {

}