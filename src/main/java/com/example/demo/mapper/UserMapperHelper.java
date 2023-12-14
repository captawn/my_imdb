package com.example.demo.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.domain.UserDomain;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperHelper {

    private final ObjectMapper mapper;

    @Autowired
    public UserMapperHelper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<UserDomain> convertUserEntityListToUserDomainList(List<UserEntity> userEntities) {
        List<UserDomain> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            users.add(UserDomain.builder()
                    .id(userEntity.getId())
                    .username(userEntity.getUsername())
                    .build());
        }

        return users;
    }

    public List<UserDTO> convertUserDomainListToUserDTOList(List<UserDomain> userDomains) {
        List<UserDTO> userDTOs = new ArrayList<>();
        for (UserDomain user : userDomains) {
            userDTOs.add(mapper.convertValue(user, UserDTO.class));
        }

        return userDTOs;
    }

    public UserDTO convertUserDomainToUserDTO(UserDomain userDomain) {
        return mapper.convertValue(userDomain, UserDTO.class);
    }


    public UserEntity convertUserDomainToUserEntity(UserDomain userDomain) {
        return mapper.convertValue(userDomain, UserEntity.class);
    }

    public UserDomain convertUserDTOToUserDomain(UserDTO userDTO) {
        return mapper.convertValue(userDTO, UserDomain.class);
    }

    public UserDomain convertUserEntityToUserDomain(UserEntity userEntity) {
//        return mapper.convertValue(userEntity, UserDomain.class);
        UserDomain domain = UserDomain.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .build();
        return domain;
    }

}
