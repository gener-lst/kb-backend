package com.kb.itisme.customPage.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "custom_community")
@Builder
public class CustomCommunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_id")
    private Long pageID;

    @Column(name = "heart")
    private Long heart;

    @OneToOne
    @JoinColumn(name = "page_id")
    private CustomPage customPage;
}
