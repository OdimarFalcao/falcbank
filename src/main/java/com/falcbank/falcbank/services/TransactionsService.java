package com.falcbank.falcbank.services;

import com.falcbank.falcbank.dtos.Request.TransactionDtoRequest;
import com.falcbank.falcbank.dtos.Response.TransactionDtoResponse;
import com.falcbank.falcbank.models.TransactionsModel;
import com.falcbank.falcbank.repositories.AccountRepository;
import com.falcbank.falcbank.repositories.TransactionsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class TransactionsService {

    final TransactionsRepository transactionsRepository;
    final AccountService accountService;

    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    public TransactionsService(TransactionsRepository transactionsRepository, AccountRepository accountRepository, AccountService accountService) {
        this.transactionsRepository = transactionsRepository;
        this.accountService = accountService;
    }

//        @Transactional
//    public TransactionDtoResponse saveTransaction(TransactionDtoRequest transactionDtoRequest) throws Exception {
//        TransactionsModel transactionsModel = new TransactionsModel();
//        BeanUtils.copyProperties(transactionDtoRequest,transactionsModel);
//        transactionsModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
//        transactionsRepository.save(transactionsModel);
//        return convertEntity(transactionsModel);
//    }
    @Transactional
    public TransactionsModel saveTransaction(TransactionDtoRequest transactionDtoRequest) throws Exception {
        TransactionsModel transactionsModel = new TransactionsModel();
        BeanUtils.copyProperties(transactionDtoRequest, transactionsModel);
        System.out.println(transactionsModel);
        transactionsModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return transactionsRepository.save(transactionsModel);
    }

    private TransactionDtoResponse convertEntity(TransactionsModel transactionsModel) {
        return modelMapper.map(transactionsModel, TransactionDtoResponse.class);
    }


}
