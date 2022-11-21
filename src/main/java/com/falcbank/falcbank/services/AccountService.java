package com.falcbank.falcbank.services;

import com.falcbank.falcbank.dtos.Request.AccountDtoRequest;
import com.falcbank.falcbank.dtos.Request.TransactionDtoRequest;
import com.falcbank.falcbank.dtos.Response.AccountDtoResponse;
import com.falcbank.falcbank.dtos.Response.TransactionDtoResponse;
import com.falcbank.falcbank.models.AccountModel;
import com.falcbank.falcbank.models.ClientModel;
import com.falcbank.falcbank.repositories.AccountRepository;
import com.falcbank.falcbank.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Service
public class AccountService {


    final ClientRepository clientRepository;
    final AccountRepository accountRepository;
    final ClientService clientService;

    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    public AccountService(ClientRepository clientRepository, AccountRepository accountRepository,ClientService clientService) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.clientService = clientService;
    }

    @Transactional
    public AccountDtoResponse saveAccount(AccountDtoRequest accountDtoRequest) throws Exception {
        AccountModel accountModel = new AccountModel();
        BeanUtils.copyProperties(accountDtoRequest,accountModel);
        accountModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        ClientModel clientModel = clientRepository.findById(accountDtoRequest.getIdClient()).orElseThrow(()->new Exception("Cliente não encontrado"));
        accountModel.setClientModel(clientModel);
        accountRepository.save(accountModel);

        return convertEntity(accountModel);
    }

    private AccountDtoResponse convertEntity(AccountModel accountModel) {
        return modelMapper.map(accountModel,AccountDtoResponse.class);
    }

    @Transactional
    public void transfer(TransactionDtoRequest transactionDtoRequest) throws Exception {
        AccountModel accountSender = (accountRepository.findByClientModel_Id(transactionDtoRequest.getIdSender()).
                orElseThrow(() -> new Exception("Conta Remetente não encontrada")));
        AccountModel accountRecepient = (accountRepository.findByClientModel_Id(transactionDtoRequest.getIdRecepient()).
                orElseThrow(() -> new Exception("Conta Destinatário não encontrada")));

        if ((transactionDtoRequest.getValueOperation().compareTo(accountSender.getBalance())) == 1)
            throw new RuntimeException("Saldo Insuficiente");
        if (Objects.equals(accountSender.getClientModel().getTypeUser(), "lojista"))
            throw new RuntimeException("Operação não permitida para esse tipo de usuário");


        accountSender.setBalance(accountSender.getBalance().subtract(transactionDtoRequest.getValueOperation()));
        accountRecepient.setBalance(accountRecepient.getBalance().add(transactionDtoRequest.getValueOperation()));

        accountRepository.save(accountSender);
        accountRepository.save(accountRecepient);



    }



}
