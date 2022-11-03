package com.falcbank.falcbank.services;

import com.falcbank.falcbank.repositories.TransactionsRepository;

public class TransactionsService {

    final TransactionsRepository transactionsRepository;

    public TransactionsService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }
}
