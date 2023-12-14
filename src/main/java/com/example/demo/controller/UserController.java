package com.example.demo.controller;

import com.example.demo.domain.UserDomain;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapperHelper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final UserMapperHelper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapperHelper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<UserDomain> userDomains = userService.getAllUser();
        return userMapper.convertUserDomainListToUserDTOList(userDomains);
    }

    @PostMapping
    public Long saveUser(@RequestBody UserDTO userDTO) {
        UserDomain userDomain = userMapper.convertUserDTOToUserDomain(userDTO);
        return userService.saveUser(userDomain);
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        UserDomain userDomain = userService.findUserById(userId);
        return userMapper.convertUserDomainToUserDTO(userDomain);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
    }

}
