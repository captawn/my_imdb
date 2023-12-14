package com.example.demo.controller;




import com.example.demo.domain.AccountDomain;
import com.example.demo.dto.AccountDTO;
import com.example.demo.mapper.AccountMapperHelper;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;
    private final AccountMapperHelper accountMapperHelper;

    @Autowired
    public AccountController(AccountService accountService, AccountMapperHelper accountMapperHelper) {
        this.accountService = accountService;
        this.accountMapperHelper = accountMapperHelper;
    }

    @GetMapping
    public List<AccountDTO> getAllAccounts() {
        List<AccountDomain> accountDomains = accountService.getAllAccount();
        return accountMapperHelper.convertAccountDomainListToAccountDTOList(accountDomains);
    }

    @PostMapping
    public Long saveAccount(@RequestBody AccountDTO accountDTO) {
        AccountDomain accountDomain = accountMapperHelper.convertAccountDTOToAccountDomain(accountDTO);
        return accountService.saveAccount(accountDomain);
    }

    @GetMapping("/{accountId}")
    public AccountDTO getAccountById(@PathVariable Long accountId) {
        AccountDomain accountDomain = accountService.findAccountById(accountId);
        return accountMapperHelper.convertAccountDomainToAccountDTO(accountDomain);
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccountById(@PathVariable Long accountId) {
        accountService.deleteAccountById(accountId);
    }
}
