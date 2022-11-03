package com.falcbank.falcbank.services;

import com.falcbank.falcbank.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
