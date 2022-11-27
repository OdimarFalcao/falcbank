package com.falcbank.falcbank.controllers;

import com.falcbank.falcbank.dtos.Request.AccountDtoRequest;
import com.falcbank.falcbank.dtos.Request.ClientDtoRequest;
import com.falcbank.falcbank.dtos.Request.TransactionDtoRequest;
import com.falcbank.falcbank.dtos.Response.AccountDtoResponse;
import com.falcbank.falcbank.dtos.Response.ClientDtoResponse;
import com.falcbank.falcbank.dtos.Response.TransactionDtoResponse;
import com.falcbank.falcbank.repositories.TransactionsRepository;
import com.falcbank.falcbank.services.AccountService;
import com.falcbank.falcbank.services.ClientService;
import com.falcbank.falcbank.services.TransactionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/falc-bank1")
public class AccountController {

    final AccountService accountService;

    final ClientService clientService;
    final TransactionsService transactionsService;

    public AccountController(AccountService accountService, TransactionsRepository transactionsRepository, ClientService clientService, TransactionsService transactionsService) {
        this.accountService = accountService;
        this.clientService = clientService;
        this.transactionsService = transactionsService;
    }

    @PostMapping("/CreateAccount")
    public ResponseEntity<AccountDtoResponse> saveAccount(@RequestBody @Valid AccountDtoRequest accountDtoRequest) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.saveAccount(accountDtoRequest));
    }
    @PostMapping("/CreateCliente")
    public ResponseEntity<ClientDtoResponse> saveClient(@RequestBody @Valid ClientDtoRequest clientDtoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(clientDtoRequest));
    }
    @PutMapping("/UpdateClient/{id}")
    public ResponseEntity<ClientDtoResponse> updateClient(@PathVariable(value = "id") Long id,@RequestBody @Valid ClientDtoRequest clientDtoRequest) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(clientService.update(id,clientDtoRequest));
    }

    @PostMapping("/transferencia")
    public ResponseEntity<TransactionDtoResponse> transfer(@RequestBody TransactionDtoRequest transactionDtoRequest) throws Exception {
        accountService.transfer(transactionDtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionsService.saveTransaction(transactionDtoRequest));
    }
}
