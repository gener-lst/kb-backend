package com.kb.itisme.customPage.dto;

import com.kb.itisme.customPage.domain.CustomCommunity;
import com.kb.itisme.customPage.domain.CustomPage;
import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomCommunityDTO {
    private Long pageID;
    private Long heart;
    private Long userNum;
    private String pageName;
    private Map<String, String> layoutData;
    private String imagePath;

    public static CustomCommunityDTO ofDTO(CustomCommunity customCommunity) {
        return customCommunity == null ? null : CustomCommunityDTO.builder()
                .pageID(customCommunity.getPageID())
                .heart(customCommunity.getHeart())
                .userNum(customCommunity.getCustomPage().getUserNum())
                .pageName(customCommunity.getCustomPage().getPageName())
                .layoutData(customCommunity.getCustomPage().getLayoutData())
                .imagePath(customCommunity.getCustomPage().getImagePath())
                .build();
    }

    public static CustomCommunity toEntity(CustomCommunityDTO customCommunityDTO) {
        return CustomCommunity.builder()
                .pageID(customCommunityDTO.getPageID())
                .heart(customCommunityDTO.getHeart())
                .customPage(CustomPage.builder()
                        .pageID(customCommunityDTO.getPageID())
                        .pageName(customCommunityDTO.getPageName())
                        .layoutData(customCommunityDTO.getLayoutData())
                        .imagePath(customCommunityDTO.getImagePath())
                        .build())
                .build();
    }
}
