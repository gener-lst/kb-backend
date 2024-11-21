package com.kb.itisme.customCommunity.domain;

import com.kb.itisme.common.util.JsonConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "custom_community")
@Builder
public class CustomCommunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shared_id")
    private Long sharedID;

    @Column(name = "user_number", nullable = false)
    private Long userNum;

    @Column(name = "page_name")
    private String pageName;

    @Convert(converter = JsonConverter.class)
    @Column(name = "layout_data")
    private List<Map<String, Object>> layoutData;

    @Column(name = "image_url")
    private String imagePath;

    @Column(name = "heart")
    private Long heart;
}
