package com.falcbank.falcbank.dtos.Request;

import com.falcbank.falcbank.models.ClientModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class AccountDtoRequest {
    //@Length(min = 1,message = "O campo não pode ser vazio ou nulo")
   // @DecimalMax("10.0")
   // @DecimalMin("0.0")
    @NotNull
    private BigDecimal balance;

    @NotNull(message = "O campo não pode ser vazio ou nulo")
    private Long idClient;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public AccountDtoRequest(BigDecimal balance, Long idClient) {
        this.balance = balance;
        this.idClient = idClient;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
