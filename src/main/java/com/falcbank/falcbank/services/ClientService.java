package com.falcbank.falcbank.services;

import com.falcbank.falcbank.dtos.ClientDtoRequest;
import com.falcbank.falcbank.models.ClientModel;
import com.falcbank.falcbank.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ClientService {

    final ClientRepository bankRepository;

    public ClientService(ClientRepository bankRepository){
        this.bankRepository = bankRepository;
    }

    @Transactional
    public ClientModel saveCB(ClientDtoRequest clientDtoRequest) {
        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDtoRequest, clientModel);
        clientModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return bankRepository.save(clientModel);
    }
}
