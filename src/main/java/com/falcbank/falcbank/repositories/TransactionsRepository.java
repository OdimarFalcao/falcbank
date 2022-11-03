package com.falcbank.falcbank.repositories;

import com.falcbank.falcbank.models.TransactionsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<TransactionsModel,Long> {
}
