package com.example.demo.service;

import com.example.demo.domain.AccountDomain;
import com.example.demo.domain.AccountDomain;
import com.example.demo.domain.UserDomain;
import com.example.demo.entity.AccountEntity;

import java.util.List;


public interface AccountService {
    List<AccountDomain> getAllAccount();

    Long saveAccount(AccountDomain accountDomain);

    AccountDomain findAccountById(Long AccountId);

    void deleteAccountById(Long AccountId);
}
