package com.falcbank.falcbank.controllers;

import com.falcbank.falcbank.dtos.AccountDtoRequest;
import com.falcbank.falcbank.dtos.TransactionDtoRequest;
import com.falcbank.falcbank.repositories.TransactionsRepository;
import com.falcbank.falcbank.services.AccountService;
import com.falcbank.falcbank.services.TransactionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/falc-bank1")
public class AccountController {

    final AccountService accountService;
    final TransactionsService transactionsService;

    public AccountController(AccountService accountService, TransactionsRepository transactionsRepository, TransactionsService transactionsService) {
        this.accountService = accountService;
        this.transactionsService = transactionsService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAccount(@RequestBody @Valid AccountDtoRequest accountDtoRequest) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.saveAccount(accountDtoRequest));
    }


    @PostMapping("/transferencia")
    public ResponseEntity<Object> transfer(@RequestBody TransactionDtoRequest transactionDtoRequest) throws Exception {
        System.out.println(transactionDtoRequest);

        accountService.findAccount(transactionDtoRequest);


        return null;
    }


}
