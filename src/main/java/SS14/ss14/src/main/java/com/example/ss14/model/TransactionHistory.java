package com.example.ss14.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_history")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private String amount;

    @Column(name = "message")
    private String message;

    @Column(name = "transaction_time")
    private LocalDateTime transactionTime;



}
