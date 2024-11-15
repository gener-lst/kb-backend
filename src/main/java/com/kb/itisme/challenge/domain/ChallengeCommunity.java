package com.kb.itisme.challenge.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChallengeCommunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "challenge_community_id")
    private int ccno;
    private String title;
    private String content;
    private String writer;
    private String imgUrl;


}
