package com.falcbank.falcbank.services;

import com.falcbank.falcbank.dtos.Request.ClientDtoRequest;
import com.falcbank.falcbank.dtos.Response.ClientDtoResponse;
import com.falcbank.falcbank.exception.GenericExceptionNotFound;
import com.falcbank.falcbank.models.ClientModel;
import com.falcbank.falcbank.repositories.ClientRepository;
import com.falcbank.falcbank.repositories.TransactionsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Service
public class ClientService {

    final ClientRepository clientRepository;
    final TransactionsRepository transactionsRepository;

    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    public ClientService(ClientRepository bankRepository, TransactionsRepository transactionsRepository){
        this.clientRepository = bankRepository;
        this.transactionsRepository = transactionsRepository;
    }

    @Transactional
    public ClientDtoResponse saveClient(ClientDtoRequest clientDtoRequest) {
        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDtoRequest, clientModel);
        clientModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        clientRepository.save(clientModel);

        return convertEntity(clientModel);
    }

    private ClientDtoResponse convertEntity(ClientModel clientModel) {
        return modelMapper.map(clientModel,ClientDtoResponse.class);
    }

    @Transactional
    public ClientModel findByIdClient(Long id) throws Exception {
        ClientModel clientModel = this.clientRepository.findById(id).
                orElseThrow(() -> new GenericExceptionNotFound("Client not Found"));
        return clientModel;
    }

    public ClientDtoResponse update(Long id, ClientDtoRequest clientDtoRequest) {
        ClientModel clientModel = clientRepository.findById(id).orElseThrow(()-> new GenericExceptionNotFound("Client not Found"));

        BeanUtils.copyProperties(clientDtoRequest,clientModel);
        clientModel.setId(clientModel.getId());
        clientModel.setRegistrationDate(clientModel.getRegistrationDate());

        clientRepository.save(clientModel);

        return convertEntity(clientModel);
    }
}
