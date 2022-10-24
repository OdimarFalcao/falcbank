package com.falcbank.falcbank.controllers;

import com.falcbank.falcbank.dtos.ClientDtoRequest;
import com.falcbank.falcbank.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/falc-bank")
public class ClientController {

    final ClientService bankService;

    public ClientController(ClientService bankService) {
        this.bankService = bankService;
    }

    @PostMapping
    public ResponseEntity<Object> saveClient(@RequestBody @Valid ClientDtoRequest clientDtoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(bankService.saveCB(clientDtoRequest));
    }
}
