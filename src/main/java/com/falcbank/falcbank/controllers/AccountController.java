package com.falcbank.falcbank.controllers;

import com.falcbank.falcbank.dtos.AccountDtoRequest;
import com.falcbank.falcbank.dtos.ClientDtoRequest;
import com.falcbank.falcbank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAccount(@RequestBody @Valid AccountDtoRequest accountDtoRequest) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.saveAccount(accountDtoRequest));

    }
}
