package com.falcbank.falcbank.services;

import com.falcbank.falcbank.dtos.TransactionDtoRequest;
import com.falcbank.falcbank.models.AccountModel;
import com.falcbank.falcbank.models.TransactionsModel;
import com.falcbank.falcbank.repositories.AccountRepository;
import com.falcbank.falcbank.repositories.TransactionsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class TransactionsService {

    final TransactionsRepository transactionsRepository;
    final AccountService accountService;

    public TransactionsService(TransactionsRepository transactionsRepository, AccountRepository accountRepository, AccountService accountService) {
        this.transactionsRepository = transactionsRepository;
        this.accountService = accountService;
    }

    @Transactional
    public TransactionsModel saveTransaction(TransactionDtoRequest transactionDtoRequest) throws Exception {
        TransactionsModel transactionsModel = new TransactionsModel();
        BeanUtils.copyProperties(transactionDtoRequest,transactionsModel);
        transactionsModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return transactionsRepository.save(transactionsModel);
    }


    public TransactionDtoRequest transfer(TransactionDtoRequest transferReqTDO) {
        return null;
    }
}
