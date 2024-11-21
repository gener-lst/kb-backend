package com.kb.itisme.account.DTO;

import com.kb.itisme.account.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class AccountDTO {
    private Long accountNumber;
    private Long userNumber;
    private String accountType;
    private Long balance;
    private Long senderAccountNumber;
    private Long receiverAccountNumber;

    public static AccountDTO ofDTO(Account account) {
        return account == null ? null : AccountDTO.builder()
                .accountNumber(account.getAccountNumber())
                .userNumber(account.getUserNumber())
                .accountType(account.getAccountType())
                .balance(account.getBalance())
                .build();
    }

    public static Account toEntity(AccountDTO accountDTO) {
        return Account.builder()
                .accountNumber(accountDTO.getAccountNumber())
                .userNumber(accountDTO.getUserNumber())
                .accountType(accountDTO.getAccountType())
                .balance(accountDTO.getBalance())
                .build();
    }
}
