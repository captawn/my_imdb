package com.example.demo.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.domain.AccountDomain;
import com.example.demo.dto.AccountDTO;
import com.example.demo.entity.AccountEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapperHelper {


    private final ObjectMapper mapper;
    private final UserMapperHelper userMapperHelper;

    @Autowired
    public AccountMapperHelper(ObjectMapper mapper, UserMapperHelper userMapperHelper) {
        this.mapper = mapper;
        this.userMapperHelper = userMapperHelper;
    }

    public List<AccountDomain> convertAccountEntityListToAccountDomainList(List<AccountEntity> accountEntities) {
        return accountEntities.stream()
                .map(this::convertAccountEntityToAccountDomain)
                .collect(Collectors.toList());
    }

    public List<AccountDTO> convertAccountDomainListToAccountDTOList(List<AccountDomain> accountDomains) {
        return accountDomains.stream()
                .map(this::convertAccountDomainToAccountDTO)
                .collect(Collectors.toList());
    }

    public AccountDTO convertAccountDomainToAccountDTO(AccountDomain accountDomain) {
        return mapper.convertValue(accountDomain, AccountDTO.class);
    }

    public AccountEntity convertAccountDomainToAccountEntity(AccountDomain accountDomain) {
        AccountEntity accountEntity = mapper.convertValue(accountDomain, AccountEntity.class);

        // Manually set the UserEntity for the AccountEntity
        if (accountDomain.getUser() != null) {
            UserEntity userEntity = mapper.convertValue(accountDomain.getUser(), UserEntity.class);
            accountEntity.setUserEntity(userEntity);
        }

        return accountEntity;
    }

    public AccountDomain convertAccountDTOToAccountDomain(AccountDTO accountDTO) {
        return mapper.convertValue(accountDTO, AccountDomain.class);
    }

    public AccountDomain convertAccountEntityToAccountDomain(AccountEntity accountEntity) {
        AccountDomain domain = AccountDomain.builder().
                id(accountEntity.getId())
                .accountNumber(accountEntity.getAccountNumber())
                .user(userMapperHelper.convertUserEntityToUserDomain(accountEntity.getUserEntity()))
                .build();

        return domain;


    }
}
