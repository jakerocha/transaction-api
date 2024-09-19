package com.educacaovirtual.transaction_api.domain.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDTO {
    private BigDecimal total;
    private LocalDateTime createdAt;
    private String cardNumber;
    private String cvv;
    private String owner;
    private String ein;
}
