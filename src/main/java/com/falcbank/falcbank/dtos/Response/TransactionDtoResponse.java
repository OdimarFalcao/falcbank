package com.falcbank.falcbank.dtos.Response;

import java.math.BigDecimal;

public class TransactionDtoResponse {
    private Long idSender;
    private Long idRecepient;
    private BigDecimal valueOperation;

    public Long getIdClient() {
        return idSender;
    }

    public void setIdClient(Long idClient) {
        this.idSender = idClient;
    }

    public Long getIdRecepient() {
        return idRecepient;
    }

    public void setIdRecepient(Long idRecepient) {
        this.idRecepient = idRecepient;
    }

    public BigDecimal getValueOperation() {
        return valueOperation;
    }

    public void setValueOperation(BigDecimal valueOperation) {
        this.valueOperation = valueOperation;
    }
}
