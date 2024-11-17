package com.kb.itisme.challenge.domain;

import com.kb.itisme.user.domain.User;
import jakarta.persistence.*;
import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "challenge_id")
    private Long cno; //챌린지 테이블 id
    private String title; // 챌린지 테이블 지출 항목
    private Date date;
    private int oneDayExpense; //지출금액(1일)
    private int monthlyExpense; // 지출금액(30일)
    private Long startPrice; // 사용자가 설정한 30일치 금액

    private Boolean monthlyStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_number")
    private User user;
//    @OneToMany(mappedBy = "challenge")
//    private List<Payment> payments;



}
