package com.kb.itisme.account.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_number")
    private Long accountNumber;
    @Column(name="user_number")
    private Long userNumber;
    private String accountType;
    private Long balance;
}
