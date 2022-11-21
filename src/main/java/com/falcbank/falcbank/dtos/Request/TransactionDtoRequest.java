package com.falcbank.falcbank.dtos.Request;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


public class TransactionDtoRequest {

    @NotNull(message = "O campo não pode ser vazio ou nulo")
    private Long idRecepient;
    @NotNull(message = "O campo não pode ser vazio ou nulo")
    private Long idSender;

    @NotNull(message = "O campo não pode ser vazio ou nulo")
    private BigDecimal valueOperation;

    public Long getIdSender() {
        return idSender;
    }

    public void setIdSender(Long idSender) {
        this.idSender = idSender;
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
