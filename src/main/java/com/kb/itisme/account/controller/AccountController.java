package com.kb.itisme.account.controller;

import com.kb.itisme.account.DTO.AccountDTO;
import com.kb.itisme.account.domain.Account;
import com.kb.itisme.account.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/api/account"))
@RequiredArgsConstructor
@Slf4j
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/list")
    public ResponseEntity<List<AccountDTO>> getListAccount(HttpServletRequest request, @RequestParam Long userNum) {

        List<AccountDTO> accounts = accountService.AccountsByUserNumber(userNum);
        return ResponseEntity.ok(accounts);

    }

    @GetMapping()
    public ResponseEntity<AccountDTO> getWithdrawalAccount(HttpServletRequest request, @RequestParam Long userNum) {
        return ResponseEntity.ok(accountService.getWithdrawalAccount(userNum));
    }

    @PostMapping("/transfer")
    public ResponseEntity<AccountDTO> transfer(@RequestBody AccountDTO accountDTO) {
        try {
            AccountDTO updatedAccount = accountService.transfer(accountDTO);
            return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


