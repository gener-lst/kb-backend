package com.kb.itisme.customPage.dto;

import com.kb.itisme.customPage.domain.CustomPage;
import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomPageDTO {
    private Long pageID;
    private Long userNum;
    private String pageName;
    private Map<String, String> layoutData;
    private String imagePath;

    public static CustomPageDTO ofDTO(CustomPage customPage) {
        return customPage == null ? null : CustomPageDTO.builder()
                .pageID(customPage.getPageID())
                .userNum(customPage.getUserNum())
                .pageName(customPage.getPageName())
                .layoutData(customPage.getLayoutData())
                .imagePath(customPage.getImagePath())
                .build();
    }

    public static CustomPage toEntity(CustomPageDTO customPageDTO) {
        return CustomPage.builder()
                .pageID(customPageDTO.getPageID())
                .userNum(customPageDTO.getUserNum())
                .pageName(customPageDTO.getPageName())
                .layoutData(customPageDTO.getLayoutData())
                .imagePath(customPageDTO.getImagePath())
                .build();
    }
}
