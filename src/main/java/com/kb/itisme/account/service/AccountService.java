package com.kb.itisme.account.service;

import com.kb.itisme.account.DTO.AccountDTO;

import java.util.List;

public interface AccountService {
    List<AccountDTO> AccountsByUserNumber(Long userNum);
    AccountDTO transfer(AccountDTO accountDTO);
    AccountDTO getWithdrawalAccount(Long userNum);
}
