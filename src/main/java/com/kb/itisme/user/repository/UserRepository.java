package com.kb.itisme.user.repository;

import com.kb.itisme.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
