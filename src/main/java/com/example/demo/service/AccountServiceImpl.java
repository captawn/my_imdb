package com.example.demo.service;

import com.example.demo.domain.AccountDomain;
import com.example.demo.entity.AccountEntity;
import com.example.demo.mapper.AccountMapperHelper;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {


    private final AccountRepository accountRepository;
    private final AccountMapperHelper accountMapperHelper;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, AccountMapperHelper accountMapperHelper) {
        this.accountRepository = accountRepository;
        this.accountMapperHelper = accountMapperHelper;
    }

    @Override
    public List<AccountDomain> getAllAccount() {
        List<AccountEntity> accountEntities = accountRepository.findAll();
        return accountMapperHelper.convertAccountEntityListToAccountDomainList(accountEntities);
    }

    @Override
    public Long saveAccount(AccountDomain accountDomain) {
        AccountEntity accountEntity = accountMapperHelper.convertAccountDomainToAccountEntity(accountDomain);
        AccountEntity savedAccount = accountRepository.save(accountEntity);
        return savedAccount.getId();
    }

    @Override
    public AccountDomain findAccountById(Long accountId) {
        Optional<AccountEntity> byId = accountRepository.findById(accountId);
        if (byId.isPresent()) {
            AccountEntity accountEntity = byId.get();
            return accountMapperHelper.convertAccountEntityToAccountDomain(accountEntity);
        }
        return null;
    }

    @Override
    public void deleteAccountById(Long accountId) {
        accountRepository.deleteById(accountId);
    }
}
