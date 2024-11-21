package com.kb.itisme.customPage.domain;

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
@Table(name = "custom_page")
@Builder
public class CustomPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_id")
    private Long pageID;

    @Column(name = "user_number", unique = true, nullable = false)
    private Long userNum;

    @Convert(converter = JsonConverter.class)
    @Column(name = "layout_data")
    private List<Map<String, Object>> layoutData;

    @Column(name = "image_url")
    private String imagePath;
}
