package com.kb.itisme.account.repository;

import com.kb.itisme.account.domain.Account;
import com.kb.itisme.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
