package com.falcbank.falcbank.services;

import com.falcbank.falcbank.dtos.ClientDtoRequest;
import com.falcbank.falcbank.dtos.TransactionDtoRequest;
import com.falcbank.falcbank.models.ClientModel;
import com.falcbank.falcbank.repositories.ClientRepository;
import com.falcbank.falcbank.repositories.TransactionsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class ClientService {

    final ClientRepository clientRepository;
    final TransactionsRepository transactionsRepository;

    public ClientService(ClientRepository bankRepository, TransactionsRepository transactionsRepository){
        this.clientRepository = bankRepository;
        this.transactionsRepository = transactionsRepository;
    }

    @Transactional
    public ClientModel saveClient(ClientDtoRequest clientDtoRequest) {
        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDtoRequest, clientModel);
        clientModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return clientRepository.save(clientModel);
    }
    @Transactional
    public ClientModel findByIdClient(Long id) throws Exception {
        ClientModel clientModel = this.clientRepository.findById(id).
                orElseThrow(() -> new Exception("Client not Found"));
        return clientModel;
    }
}
