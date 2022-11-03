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

    final ClientRepository clientRepository;

    public ClientService(ClientRepository bankRepository){
        this.clientRepository = bankRepository;
    }

    @Transactional
    public ClientModel saveClient(ClientDtoRequest clientDtoRequest) {
        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDtoRequest, clientModel);
        clientModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return clientRepository.save(clientModel);
    }
}
