package com.kb.itisme.account.service;

import com.kb.itisme.account.DTO.AccountDTO;
import com.kb.itisme.account.domain.Account;
import com.kb.itisme.account.repository.AccountRepository;
import com.kb.itisme.customCommunity.dto.CustomCommunityDTO;
import com.kb.itisme.customPage.domain.CustomPage;
import com.kb.itisme.customPage.dto.CustomPageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;


    @Override
    public List<AccountDTO> AccountsByUserNumber(Long userNum) {
        return accountRepository.findByUserNumber(userNum).stream().map(AccountDTO::ofDTO).toList();    }

    @Override
    public AccountDTO transfer(AccountDTO accountDTO) {
        // 1. 송신 계좌 및 수신 계좌 조회
        Account senderAccount = accountRepository.findById(accountDTO.getSenderAccountNumber())
                .orElseThrow(() -> new IllegalArgumentException("송신 계좌가 존재하지 않습니다."));
        Account receiverAccount = accountRepository.findById(accountDTO.getReceiverAccountNumber())
                .orElseThrow(() -> new IllegalArgumentException("수신 계좌가 존재하지 않습니다."));

        // 2. 잔액 확인
        if (senderAccount.getBalance() < accountDTO.getBalance()) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }

        // 3. 송신 계좌 잔액 차감 및 수신 계좌 잔액 추가
        senderAccount.setBalance(senderAccount.getBalance() - accountDTO.getBalance());
        receiverAccount.setBalance(receiverAccount.getBalance() + accountDTO.getBalance());

        // 4. 변경된 계좌 정보 저장
        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);

        // 5. 결과 반환
        return AccountDTO.ofDTO(senderAccount);
    }

    @Override
    public AccountDTO getWithdrawalAccount(Long userNum) {
        List<Account> accounts = accountRepository.findByUserNumber(userNum);
        for (Account account : accounts) {
            if (account.getAccountType().equals("입출금")) {
                return AccountDTO.ofDTO(account);
            }
        }
        return null;
    }
}
