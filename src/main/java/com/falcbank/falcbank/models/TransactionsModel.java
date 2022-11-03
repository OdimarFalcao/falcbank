package com.falcbank.falcbank.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="TB_TRANSACTIONS")
public class TransactionsModel {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_sender;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_recipient;
    @Column(nullable = false)
    private double value_operation;
    @Column(nullable = false, length = 30)
    private LocalDateTime registrationDate;

    public TransactionsModel() {
        this.id_sender = id_sender;
        this.id_recipient = id_recipient;
        this.value_operation = value_operation;
        this.registrationDate = registrationDate;
    }

    public long getId_sender() {
        return id_sender;
    }

    public void setId_sender(long id_sender) {
        this.id_sender = id_sender;
    }

    public long getId_recipient() {
        return id_recipient;
    }

    public void setId_recipient(long id_recipient) {
        this.id_recipient = id_recipient;
    }

    public double getValue_operation() {
        return value_operation;
    }

    public void setValue_operation(double value_operation) {
        this.value_operation = value_operation;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
