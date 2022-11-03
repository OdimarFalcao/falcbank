package com.falcbank.falcbank.services;

import com.falcbank.falcbank.dtos.AccountDtoRequest;
import com.falcbank.falcbank.models.AccountModel;
import com.falcbank.falcbank.models.ClientModel;
import com.falcbank.falcbank.repositories.AccountRepository;
import com.falcbank.falcbank.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class AccountService {

    final AccountRepository accountRepository;
    final ClientRepository clientRepository;
    public AccountService(AccountRepository accountRepository, ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public AccountModel saveAccount(AccountDtoRequest accountDtoRequest) throws Exception {
        AccountModel accountModel = new AccountModel();
        BeanUtils.copyProperties(accountDtoRequest,accountModel);
        accountModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
       ClientModel clientModel = clientRepository.findById(accountDtoRequest.getIdClient()).orElseThrow(()->new Exception("Cliente não encontrado"));
       accountModel.setClientModel(clientModel);
        System.out.println(accountModel);
        return accountRepository.save(accountModel);

    }
}
