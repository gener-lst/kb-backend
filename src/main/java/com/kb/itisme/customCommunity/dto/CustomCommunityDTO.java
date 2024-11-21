package com.kb.itisme.customCommunity.dto;

import com.kb.itisme.customCommunity.domain.CustomCommunity;
import com.kb.itisme.customPage.domain.CustomPage;
import lombok.*;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomCommunityDTO {
    private Long sharedID;
    private Long userNum;
    private String pageName;
    private List<Map<String, Object>> layoutData;
    private String imagePath;
    private Long heart;

    public static CustomCommunityDTO ofDTO(CustomCommunity customCommunity) {
        return customCommunity == null ? null : CustomCommunityDTO.builder()
                .sharedID(customCommunity.getSharedID())
                .userNum(customCommunity.getUserNum())
                .pageName(customCommunity.getPageName())
                .layoutData(customCommunity.getLayoutData())
                .imagePath(customCommunity.getImagePath())
                .heart(customCommunity.getHeart())
                .build();
    }

    public static CustomCommunity toEntity(CustomCommunityDTO customCommunityDTO) {
        return CustomCommunity.builder()
                .sharedID(customCommunityDTO.getSharedID())
                .userNum(customCommunityDTO.getUserNum())
                .pageName(customCommunityDTO.getPageName())
                .layoutData(customCommunityDTO.getLayoutData())
                .imagePath(customCommunityDTO.getImagePath())
                .heart(customCommunityDTO.getHeart())
                .build();
    }
}
