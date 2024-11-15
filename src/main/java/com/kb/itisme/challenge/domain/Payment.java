package com.kb.itisme.challenge.domain;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "payment_id")
    private Long pno;
    private String category;
    private Long expense;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;
}
