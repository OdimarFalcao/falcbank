package com.falcbank.falcbank.repositories;

import com.falcbank.falcbank.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
}
