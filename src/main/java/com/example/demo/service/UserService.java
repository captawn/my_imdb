package com.example.demo.service;

import com.example.demo.domain.UserDomain;

import java.util.List;


public interface UserService {
    List<UserDomain> getAllUser();

    Long saveUser(UserDomain userDomain);

    UserDomain findUserById(Long userId);

    void deleteUserById(Long userID);
}
