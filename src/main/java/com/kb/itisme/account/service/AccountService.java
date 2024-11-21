package com.kb.itisme.account.service;

import com.kb.itisme.account.DTO.AccountDTO;

public interface AccountService {
    AccountDTO getAccount(Long accountNumber);
    AccountDTO transfer(AccountDTO accountDTO);
}
