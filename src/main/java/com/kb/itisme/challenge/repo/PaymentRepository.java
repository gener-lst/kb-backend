package com.kb.itisme.challenge.repo;

import com.kb.itisme.challenge.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findPaymentsByUser_UserNumAndDateBetween(Long userNum, LocalDate startDate, LocalDate endDate);
}
