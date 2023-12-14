package com.example.demo.service;

import com.example.demo.domain.UserDomain;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapperHelper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final UserMapperHelper userMapperHelper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository, UserMapperHelper userMapperHelper) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.userMapperHelper = userMapperHelper;
    }


    @Override
    public List<UserDomain> getAllUser() {
        List<UserEntity> UserEntities = userRepository.findAll();
        List<UserDomain> userDomains = userMapperHelper.convertUserEntityListToUserDomainList(UserEntities);
        return userDomains;
    }

    @Override
    public Long saveUser(UserDomain userDomain) {
        UserEntity userEntity = userMapperHelper.convertUserDomainToUserEntity(userDomain);
        UserEntity savedUser = userRepository.save(userEntity);
        return savedUser.getId();
    }

    @Override
    public UserDomain findUserById(Long userId) {
        Optional<UserEntity> byId = userRepository.findById(userId);
        if (byId.isPresent()){
            UserEntity userEntity = byId.get();
            UserDomain userDomain = userMapperHelper.convertUserEntityToUserDomain(userEntity);
        }

        return null;
    }

    @Override
    public void deleteUserById(Long userID) {
        userRepository.deleteById(userID);
    }
}
