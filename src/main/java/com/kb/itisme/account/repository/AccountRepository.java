package com.kb.itisme.account.repository;

import com.kb.itisme.account.DTO.AccountDTO;
import com.kb.itisme.account.domain.Account;
import com.kb.itisme.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {


    List<Account> findByUserNumber(Long userNum);
}
