package com.kb.itisme.challenge.domain;
import com.kb.itisme.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_number", nullable = false)
    private User user;

    private String description;

    private Double amount;

    private LocalDate date;


    public Payment(User user, String description, Double amount, LocalDate date) {
        this.user = user;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }
}
